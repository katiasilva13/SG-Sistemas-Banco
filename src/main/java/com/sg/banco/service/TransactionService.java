package com.sg.banco.service;

import com.sg.banco.domain.Account;
import com.sg.banco.domain.CheckingAccount;
import com.sg.banco.domain.SavingsAccount;
import com.sg.banco.domain.Transaction;
import com.sg.banco.enumerator.AccountType;
import com.sg.banco.enumerator.TransactionType;
import com.sg.banco.repository.TransactionRepository;
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

import static java.time.temporal.ChronoUnit.DAYS;
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
    private CheckingAccountService checkingAccountService;

    @Autowired
    private SavingsAccountService savingsAccountService;

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
        Integer checkType = Integer.parseInt(trimWhitespace(json.get("transactionType")).toUpperCase(Locale.ROOT));
        TransactionType transactionType = null;
        for (TransactionType type : TransactionType.values()) {
            if (type.getCode().equals(checkType)) transactionType = type;
        }

        Integer sourceAccountId = Integer.parseInt(trimWhitespace(json.get("sourceAccountId")).toUpperCase(Locale.ROOT));
        Account sourceAccount = accountService.getById(sourceAccountId);
        Double value = Double.parseDouble(trimWhitespace(json.get("value")).toUpperCase(Locale.ROOT));

        if (sourceAccount instanceof SavingsAccount)
            sourceAccount = calculateIncome(sourceAccount.getId());

        if (sourceAccount instanceof CheckingAccount)
            sourceAccount = calculateInterest(sourceAccount.getId());

        //TODO checar se as dados estão salvando ou se precisa mudar de account to checking || savings

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
                String destinationAccountType = trimWhitespace(json.get("destinationAccountType")).toUpperCase(Locale.ROOT);
                String destinationAccountCode = trimWhitespace(json.get("destinationAccountCode")).toUpperCase(Locale.ROOT);
                String destinationAccountBranch = trimWhitespace(json.get("destinationAccountBranch")).toUpperCase(Locale.ROOT);
                destinationAccount = accountService.getByData(destinationAccountType,
                        destinationAccountCode, destinationAccountBranch);
                destinationAccount = setAccountDataForDepositOrTransfer(destinationAccount, value);
                transaction = transferService.createTransfer(transactionType, sourceAccount, value, destinationAccount);
                break;
        }

        if (destinationAccount != null) {
            accountService.update(destinationAccount);
        }
        accountService.update(sourceAccount);
        this.repository.save(transaction);
        return transaction;
    }

    private SavingsAccount calculateIncome(Integer id) {
        SavingsAccount account = savingsAccountService.getById(id);
        if (Objects.nonNull(account.getInvestmentDay())) {
            LocalDate today = LocalDate.now();
            Integer countDays = Math.toIntExact(DAYS.between(account.getInvestmentDay(), today));
            BigDecimal invested = account.getInvested();
            for (int i = countDays; i > 0; i--) {
                invested = invested.multiply(account.getSavingsRate());
            }
            account.setSavingsIncome(invested);
            account.setBalance(invested);
        }
        return account;
    }

    private CheckingAccount calculateInterest(Integer id) {
        CheckingAccount account = checkingAccountService.getById(id);
        if (Objects.nonNull(account.getInterestDay())) {
            LocalDate today = LocalDate.now();
            Integer countDays = Math.toIntExact(DAYS.between(account.getInterestDay(), today));
            BigDecimal interest = account.getOverdraftLimit().subtract(account.getOverdraftAvailable());
            for (int i = countDays; i > 0; i--) {
                interest = interest.multiply(account.getInterestRate());
            }
            account.setInterest(interest);
        }
        return account;
    }

    private Account setAccountDataForDepositOrTransfer(Account destinationAccount, Double value) throws Exception {
        BigDecimal balance = null;
        if (destinationAccount instanceof CheckingAccount) {
            CheckingAccount account = (CheckingAccount) destinationAccount;
            balance = account.getBalance();
            if (checkInterest(account, value)) {
                BigDecimal valueSubtracted = BigDecimal.valueOf(value).subtract(account.getInterest());
                balance = balance.add(valueSubtracted);
                account.setBalance(balance);
                account.setInterest(BigDecimal.ZERO);
                return account;
            } else {
                balance = balance.add(BigDecimal.valueOf(value));
                account.setBalance(balance);
                return account;
            }
        } else if (destinationAccount instanceof SavingsAccount) {
            SavingsAccount account = (SavingsAccount) destinationAccount;
            balance = account.getBalance();
            BigDecimal invested = account.getInvested();
            invested = invested.add(BigDecimal.valueOf(value));
            balance = balance.add(BigDecimal.valueOf(value));
            account.setInvested(invested);
            account.setBalance(balance);
            return account;
        } else
            throw new Exception("Erro ao identificar conta");
    }

    private boolean checkInterest(CheckingAccount checkingAccount, Double value) {
        if (checkingAccount.getInterest() == null || checkingAccount.getInterest().doubleValue() <= BigDecimal.ZERO.doubleValue())
            return false;
        return checkingAccount.getInterest().doubleValue() <= value;
    }

    private Account setAccountDataForWithdrawalOrTransfer(Account sourceAccount, Double value) throws Exception {
        if (checkBalance(sourceAccount, value)) {
            BigDecimal valueSubtracted = sourceAccount.getBalance().subtract(BigDecimal.valueOf(value));
            sourceAccount.setBalance(valueSubtracted);
        } else if (sourceAccount.getAccountType().equals(AccountType.CHECKING_ACCOUNT)) {
            if (checkOverdraftLimit(sourceAccount, value)) {
                CheckingAccount checkingAccount = (CheckingAccount) sourceAccount;
                BigDecimal valueSubtracted = BigDecimal.valueOf(value).subtract(sourceAccount.getBalance());
                //    BigDecimal availableValue = checkingAccount.getOverdraftLimit().subtract(checkingAccount.getInterest());
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
            } else throw new Exception("Operação inválida. Não há saldo ou limite disponível.");
        } else throw new Exception("Operação inválida. Não há saldo disponível.");
        return sourceAccount;
    }

    private boolean checkOverdraftLimit(Account sourceAccount, Double value) {
        CheckingAccount checkingAccount = (CheckingAccount) sourceAccount;
        return checkingAccount.getOverdraftLimit().doubleValue() > value;
    }

    private boolean checkBalance(Account sourceAccount, Double value) {
        return sourceAccount.getBalance().doubleValue() > value;
    }

    private Transaction createWithdrawalOrDeposit(TransactionType transactionType, Account sourceAccount, Double value) {
        Transaction transaction = null;
        transaction = Transaction.builder()
                .transactionType(transactionType)
                .value(value)
                .sourceAccount(sourceAccount)
                .build();
        return transaction;
    }

}
