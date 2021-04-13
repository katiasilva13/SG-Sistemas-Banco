package com.sg.banco.service;

import com.sg.banco.domain.Account;
import com.sg.banco.domain.CheckingAccount;
import com.sg.banco.domain.Transaction;
import com.sg.banco.enumerator.AccountType;
import com.sg.banco.enumerator.TransactionType;
import com.sg.banco.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.springframework.util.StringUtils.trimWhitespace;

@Service
public class TransactionService implements Serializable {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private PersonService personService;

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountService accountService;

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

        Transaction transaction = null;
        switch (transactionType) {
            case WITHDRAWAL:
                sourceAccount = setDataWithdrawalOrTransfer(sourceAccount, value);
                transaction = createWithdrawalOrDeposit(transactionType, sourceAccount, value);
                break;
            case DEPOSIT:
                 transaction = createWithdrawalOrDeposit(transactionType, sourceAccount, value);
                break;
            case TRANSFER:
                sourceAccount = setDataWithdrawalOrTransfer(sourceAccount, value);
                String destinationAccountType = trimWhitespace(json.get("destinationAccountType")).toUpperCase(Locale.ROOT);
                String destinationAccountCode = trimWhitespace(json.get("destinationAccountCode")).toUpperCase(Locale.ROOT);
                String destinationAccountBranch = trimWhitespace(json.get("destinationAccountBranch")).toUpperCase(Locale.ROOT);
                Account destinationAccount = accountService.getByData(destinationAccountType,
                        destinationAccountCode, destinationAccountBranch);
                destinationAccount = setDataDepositOrTransfer(transactionType, destinationAccount, value);
                transaction = transferService.createTransfer(transactionType, sourceAccount, value, destinationAccount);
                break;
        }

        //TODO se savings_account==true then calcular rendimentos
        accountService.update(sourceAccount);
        this.repository.save(transaction);
        return transaction;
    }

    private Account setDataDepositOrTransfer(TransactionType transactionType, Account destinationAccount, Double value) {
        //TODO calcular juros
        CheckingAccount checkingAccount = (CheckingAccount) destinationAccount;
        BigDecimal balance = checkingAccount.getBalance();
        if (checkInterest(checkingAccount, value)) {
            BigDecimal valueSubtracted = BigDecimal.valueOf(value).subtract(checkingAccount.getInterest());
            checkingAccount.setBalance(balance.add(valueSubtracted));
            checkingAccount.setInterest(BigDecimal.ZERO);
        }else {
            checkingAccount.setBalance(balance.add(BigDecimal.valueOf(value)));
        }
        return checkingAccount;
    }

    private boolean checkInterest(Account destinationAccount, Double value) {
//        CheckingAccount checkingAccount = (CheckingAccount) destinationAccount;
        if (checkingAccount.getInterest() == null || checkingAccount.getInterest().doubleValue() <= 0) return true;
        return checkingAccount.getInterest().doubleValue() < value;
    }

    private Account setDataWithdrawalOrTransfer(Account sourceAccount, Double value) throws Exception {
        if (checkBalance(sourceAccount, value)) {
            BigDecimal valueSubtracted = sourceAccount.getBalance().subtract(BigDecimal.valueOf(value));
            sourceAccount.setBalance(valueSubtracted);
        } else if (sourceAccount.getAccountType().equals(AccountType.CHECKING_ACCOUNT)) {
            if (checkOverdraftLimit(sourceAccount, value)) {
                CheckingAccount checkingAccount = (CheckingAccount) sourceAccount;
                checkingAccount.setInterestDay(LocalDate.now());
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
