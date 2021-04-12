package com.sg.banco.service;

import com.sg.banco.domain.Account;
import com.sg.banco.domain.CheckingAccount;
import com.sg.banco.domain.Person;
import com.sg.banco.domain.SavingsAccount;
import com.sg.banco.enumerator.AccountType;
import com.sg.banco.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.springframework.util.StringUtils.trimWhitespace;

@Service
public class AccountService implements Serializable {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private CheckingAccountService checkingAccountService;

    @Autowired
    private SavingsAccountService savingsAccountService;

    @Autowired
    private PersonService personService;

    public List<Account> getAll() {
        return this.repository.findAll();
    }

    public Account getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<Account> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public List<CheckingAccount> getAllCheckingAccounts() {
        return this.checkingAccountService.getAll();
    }

    public List<SavingsAccount> getAllSavingsAccounts() {
        return this.savingsAccountService.getAll();
    }

    public Account create(Map<String, String> json) {
        Integer checkType = Integer.parseInt(trimWhitespace(json.get("accountType")).toUpperCase(Locale.ROOT));
        AccountType accountType = null;
        for (AccountType type : AccountType.values()) {
            if (type.getCode().equals(checkType)) accountType = type;
        }
//todo generate account_code
        String branch = trimWhitespace(json.get("branch")).toUpperCase(Locale.ROOT);
        Double balance = Double.parseDouble(trimWhitespace(json.getOrDefault("balance", "0.0")).toUpperCase(Locale.ROOT));

        Integer personId = Integer.parseInt(trimWhitespace(json.getOrDefault("personId", "0.0")).toUpperCase(Locale.ROOT));
        Person person = personService.getById(personId);
//TODO verificar se pf ou pj
        //TODO verficar se a pessoa já tem conta desse tipo
        //TODO calcular juros
        //TODO calcular rendimentos
        Account account = null;
        if (accountType.equals(AccountType.CHECKING_ACCOUNT)) {
            Double overdraftLimit = Double.parseDouble(trimWhitespace(json.getOrDefault("overdraftLimit", "1000.00")).toUpperCase(Locale.ROOT));
            Double interestRate = Double.parseDouble(trimWhitespace(json.getOrDefault("interestRate", "1.57")).toUpperCase(Locale.ROOT));
            Double interest = Double.parseDouble(trimWhitespace(json.getOrDefault("interest", "0.0")).toUpperCase(Locale.ROOT));

            account = checkingAccountService.create(accountType, branch, balance, person,
                    overdraftLimit, interestRate, interest);

        } else if (accountType.equals(AccountType.SAVINGS_ACCOUNT)) {
            Double savingsRate = Double.parseDouble(trimWhitespace(json.getOrDefault("savingsRate", "0.87")).toUpperCase(Locale.ROOT));
            Double savingsIncome = Double.parseDouble(trimWhitespace(json.getOrDefault("savingsIncome", "0.0")).toUpperCase(Locale.ROOT));
            account = savingsAccountService.create(accountType, branch, balance, person,
                    savingsRate, savingsIncome);
        }

        this.repository.save(account);
        return account;
    }

}
