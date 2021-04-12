package com.sg.banco.service;

import com.sg.banco.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AccountService  implements Serializable {

    @Autowired
    private AccountRepository repository;
}
