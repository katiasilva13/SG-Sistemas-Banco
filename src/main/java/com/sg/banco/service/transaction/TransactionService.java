package com.sg.banco.service.transaction;

import com.sg.banco.domain.account.Account;
import com.sg.banco.domain.account.CheckingAccount;
import com.sg.banco.domain.account.SavingsAccount;
import com.sg.banco.domain.transaction.Transaction;
import com.sg.banco.enumerator.AccountType;
import com.sg.banco.enumerator.TransactionType;
import com.sg.banco.repository.transaction.TransactionRepository;
import com.sg.banco.service.RateCalculator;
import com.sg.banco.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import static org.springframework.util.StringUtils.trimWhitespace;

@Service
public class TransactionService implements Serializable {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RateCalculator calculator;

    public List<Transaction> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.desc(("timestamp"))));
    }

    public Transaction getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<Transaction> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public Transaction createTransaction(Map<String, String> json) throws Exception {
        TransactionType transactionType = getTransactionTypeFromJson(json);
        Integer sourceAccountId = Integer.parseInt(trimWhitespace(json.get("sourceAccountId")).toUpperCase(Locale.ROOT));
        Account sourceAccount = accountService.getById(sourceAccountId);
        Double value = Double.parseDouble(trimWhitespace(json.get("value")).toUpperCase(Locale.ROOT));
        sourceAccount = calculateIncomeOrInterest(sourceAccount);

        Account destinationAccount = null;
        Transaction transaction = null;
        switch (Objects.requireNonNull(transactionType)) {
            case WITHDRAWAL:
                sourceAccount = setAccountDataForWithdrawalOrTransfer(sourceAccount, value);
                transaction = createWithdrawalOrDeposit(transactionType, sourceAccount, value);
                break;
            case DEPOSIT:
                sourceAccount = setAccountDataForDepositOrTransfer(sourceAccount, value);
                transaction = createWithdrawalOrDeposit(transactionType, sourceAccount, value);
                break;
            case TRANSFER:
                sourceAccount = setAccountDataForWithdrawalOrTransfer(sourceAccount, value);
                destinationAccount = setDestinationAccountDataFromJson(json, value);
                transaction = transferService.createTransfer(transactionType, sourceAccount, value, destinationAccount);
                break;
        }
        if (destinationAccount != null) {
            destinationAccount = calculator.calculateInterest(destinationAccount.getId());
            accountService.update(destinationAccount);
        }
        if (sourceAccount instanceof SavingsAccount && sourceAccount.getBalance().equals(BigDecimal.ZERO))
            ((SavingsAccount) sourceAccount).setInvestmentDay(null);
        sourceAccount = calculateIncomeOrInterest(sourceAccount);
        accountService.update(sourceAccount);
        return this.repository.save(transaction);
    }

    private Account setDestinationAccountDataFromJson(Map<String, String> json, Double value) throws Exception {
        Account destinationAccount;
        String destinationAccountCode = trimWhitespace(json.get("destinationAccountCode")).toUpperCase(Locale.ROOT);
        String destinationAccountBranch = trimWhitespace(json.get("destinationAccountBranch")).toUpperCase(Locale.ROOT);
        destinationAccount = accountService.getByData(destinationAccountCode, destinationAccountBranch);
        destinationAccount = setAccountDataForDepositOrTransfer(destinationAccount, value);
        return destinationAccount;
    }

    private Account calculateIncomeOrInterest(Account sourceAccount) {
        if (sourceAccount instanceof SavingsAccount)
            sourceAccount = calculator.calculateIncome(sourceAccount.getId());

        if (sourceAccount instanceof CheckingAccount)
            sourceAccount = calculator.calculateInterest(sourceAccount.getId());
        return sourceAccount;
    }

    private TransactionType getTransactionTypeFromJson(Map<String, String> json) {
        Integer checkType = Integer.parseInt(trimWhitespace(json.get("transactionType")).toUpperCase(Locale.ROOT));
        TransactionType transactionType = null;
        for (TransactionType type : TransactionType.values()) {
            if (type.getCode().equals(checkType)) transactionType = type;
        }
        return transactionType;
    }

    private Account setAccountDataForDepositOrTransfer(Account destinationAccount, Double value) throws Exception {
        BigDecimal balance = null;
        if (destinationAccount instanceof CheckingAccount) {
            return setCheckingAccountDataForDepositOrTransfer((CheckingAccount) destinationAccount, value);
        } else if (destinationAccount instanceof SavingsAccount) {
            return setSavingsAccountDataForDepositOrTransfer((SavingsAccount) destinationAccount, value);
        } else
            throw new Exception("Erro ao identificar conta");
    }

    private SavingsAccount setSavingsAccountDataForDepositOrTransfer(SavingsAccount destinationAccount, Double value) {
        BigDecimal balance;
        SavingsAccount account = destinationAccount;
        balance = account.getBalance();
        BigDecimal invested = account.getInvested();
        invested = invested.add(BigDecimal.valueOf(value));
        balance = balance.add(BigDecimal.valueOf(value));
        account.setInvested(invested);
        account.setBalance(balance);
        if (Objects.isNull(account.getInvestmentDay()))
            account.setInvestmentDay(LocalDate.now());
        return account;
    }

    private CheckingAccount setCheckingAccountDataForDepositOrTransfer(CheckingAccount account, Double value) {
        BigDecimal balance;
        balance = account.getBalance();
        if (checkInterest(account, value)) {
            BigDecimal valueSubtracted = BigDecimal.valueOf(value).subtract(account.getInterest());
            balance = balance.add(valueSubtracted);
            account.setBalance(balance);
            account.setInterest(BigDecimal.ZERO);
            account.setInterestDay(null);
            return account;
        } else {
            balance = balance.add(BigDecimal.valueOf(value));
            account.setBalance(balance);
            return account;
        }
    }

    private boolean checkInterest(CheckingAccount checkingAccount, Double value) {
        if (checkingAccount.getInterest() == null || checkingAccount.getInterest().doubleValue() <= BigDecimal.ZERO.doubleValue())
            return false;
        return checkingAccount.getInterest().doubleValue() <= value;
    }

    private Account setAccountDataForWithdrawalOrTransfer(Account sourceAccount, Double value) throws Exception {
        if (checkBalance(sourceAccount, value)) {
            BigDecimal valueSubtracted = sourceAccount.getBalance().subtract(BigDecimal.valueOf(value));
            if (sourceAccount instanceof SavingsAccount) {
                sourceAccount = setSavingsAccountDataForWithdrawalOrTransferWhenPositiveBalance(sourceAccount, valueSubtracted);
            } else {
                sourceAccount.setBalance(valueSubtracted);
            }
        } else if (sourceAccount.getAccountType().equals(AccountType.CHECKING_ACCOUNT)) {
            if (checkOverdraftLimit(sourceAccount, value)) {
                sourceAccount = setCheckingAccountDataForWithdrawalOrTransferWhenLimitAvailable(sourceAccount, value);
            } else throw new Exception("Operação inválida. Não há saldo ou limite disponível.");
        } else throw new Exception("Operação inválida. Não há saldo disponível.");
        return sourceAccount;
    }

    private Account setSavingsAccountDataForWithdrawalOrTransferWhenPositiveBalance(Account sourceAccount, BigDecimal valueSubtracted) {
        SavingsAccount savingsAccount = (SavingsAccount) sourceAccount;
        savingsAccount.setBalance(valueSubtracted);
        savingsAccount.setInvested(valueSubtracted);
        sourceAccount = savingsAccount;
        return sourceAccount;
    }

    private Account setCheckingAccountDataForWithdrawalOrTransferWhenLimitAvailable(Account sourceAccount, Double value) throws Exception {
        CheckingAccount checkingAccount = (CheckingAccount) sourceAccount;
        BigDecimal valueSubtracted = BigDecimal.valueOf(value).subtract(sourceAccount.getBalance());
        BigDecimal availableValue = checkingAccount.getOverdraftAvailable();
        if (availableValue.subtract(valueSubtracted).signum() < 0)
            throw new Exception("Operação inválida. Não há limite disponível.");
        availableValue = availableValue.subtract(valueSubtracted);
        checkingAccount.setOverdraftAvailable(availableValue);
        checkingAccount.setBalance(BigDecimal.ZERO);
        checkingAccount.setInterestDay(LocalDate.now());
        BigDecimal interest = checkingAccount.getInterest();
        interest = interest.add(valueSubtracted);
        checkingAccount.setInterest(interest);
        sourceAccount = checkingAccount;
        return sourceAccount;
    }

    private boolean checkOverdraftLimit(Account sourceAccount, Double value) {
        CheckingAccount checkingAccount = (CheckingAccount) sourceAccount;
        return checkingAccount.getOverdraftLimit().doubleValue() > value;
    }

    private boolean checkBalance(Account sourceAccount, Double value) {
        return sourceAccount.getBalance().doubleValue() > value;
    }

    private Transaction createWithdrawalOrDeposit(TransactionType transactionType, Account sourceAccount, Double
            value) {
        Transaction transaction = null;
        transaction = Transaction.builder()
                .transactionType(transactionType)
                .value(value)
                .sourceAccount(sourceAccount)
                .outcome(sourceAccount.getBalance())
                .build();
        return transaction;
    }

}
