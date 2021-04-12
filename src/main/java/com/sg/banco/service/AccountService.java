package com.sg.banco.service;

import com.sg.banco.domain.Account;
import com.sg.banco.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class AccountService  implements Serializable {

    @Autowired
    private AccountRepository repository;

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
}
