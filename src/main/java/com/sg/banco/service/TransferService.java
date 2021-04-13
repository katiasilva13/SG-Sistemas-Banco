package com.sg.banco.service;

import com.sg.banco.domain.Account;
import com.sg.banco.domain.Transaction;
import com.sg.banco.domain.Transfer;
import com.sg.banco.enumerator.TransactionType;
import com.sg.banco.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class TransferService implements Serializable {

    @Autowired
    private TransferRepository repository;

    public List<Transfer> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.desc(("timestamp"))));
    }

    public Transfer getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<Transfer> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public Transfer createTransfer(TransactionType transactionType, Account sourceAccount, Double value, Account destinationAccount) {
        Transfer transfer = null;
        transfer = new Transfer(transactionType,value, sourceAccount, destinationAccount );
        this.repository.save(transfer);
        return transfer;
    }
}
