package com.sg.banco.service;

import com.sg.banco.domain.Transaction;
import com.sg.banco.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class TransactionService implements Serializable {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private PersonService personService;

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

    //TODO calcular juros (quandor estrato, quando fizer deposisto ou tranferencia)
    //TODO calcular rendimentos

}
