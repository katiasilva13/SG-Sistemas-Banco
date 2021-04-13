package com.sg.banco.service;

import com.sg.banco.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class TransactionService implements Serializable {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private PersonService personService;

    @Autowired
    private AccountService accountService;

    //TODO calcular juros (quandor estrato, quando fizer deposisto ou tranferencia)
    //TODO calcular rendimentos

}
