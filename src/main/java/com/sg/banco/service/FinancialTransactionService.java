package com.sg.banco.service;

import com.sg.banco.repository.FinancialTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class FinancialTransactionService implements Serializable {

    @Autowired
    private FinancialTransactionRepository repository;

}
