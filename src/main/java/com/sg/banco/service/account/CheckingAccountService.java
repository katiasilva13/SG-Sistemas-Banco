package com.sg.banco.service.account;

import com.sg.banco.domain.CheckingAccount;
import com.sg.banco.domain.Person;
import com.sg.banco.enumerator.AccountType;
import com.sg.banco.repository.account.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CheckingAccountService implements Serializable {

    @Autowired
    private CheckingAccountRepository repository;

    public List<CheckingAccount> getAll() {
        return this.repository.findAll();
    }

    public CheckingAccount getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<CheckingAccount> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public CheckingAccount create(AccountType accountType, String branch, BigDecimal balance, Person person,
                                  BigDecimal overdraftLimit, BigDecimal interestRate, BigDecimal interest,
                                  String accountCode, BigDecimal overdraftAvailable) {
        CheckingAccount account = CheckingAccount.builder()
                .overdraftLimit(overdraftLimit)
                .interestRate(interestRate)
                .interest(interest)
                .overdraftAvailable(overdraftAvailable)
                .build();
        account.setAccountType(accountType);
        account.setPerson(person);
        account.setBalance(balance);
        account.setBranch(branch);
        account.setAccountCode(accountCode);
        this.repository.save(account);
        return account;
    }

    public void update(CheckingAccount sourceAccount) {
        this.repository.save(sourceAccount);
    }

}
