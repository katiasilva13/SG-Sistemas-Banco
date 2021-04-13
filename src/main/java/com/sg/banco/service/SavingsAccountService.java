package com.sg.banco.service;

import com.sg.banco.domain.Person;
import com.sg.banco.domain.SavingsAccount;
import com.sg.banco.enumerator.AccountType;
import com.sg.banco.repository.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Service
public class SavingsAccountService implements Serializable {

    @Autowired
    private SavingsAccountRepository repository;

    public List<SavingsAccount> getAll() {
        return this.repository.findAll();
    }

    public SavingsAccount getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<SavingsAccount> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public SavingsAccount create(AccountType accountType, String branch, BigDecimal balance, Person person,
                                 BigDecimal savingsRate, BigDecimal savingsIncome, String accountCode) {

        SavingsAccount account = SavingsAccount.builder()
                .savingsRate(savingsRate)
                .savingsIncome(savingsIncome)
                .build();
        account.setAccountType(accountType);
        account.setPerson(person);
        account.setBalance(balance);
        account.setBranch(branch);
        account.setAccountCode(accountCode);
        this.repository.save(account);
        return account;
    }

}
