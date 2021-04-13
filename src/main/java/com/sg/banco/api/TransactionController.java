package com.sg.banco.api;

import com.sg.banco.domain.Transaction;
import com.sg.banco.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping("/transacoes")
    public List<Transaction> getAll() {
        return service.getAll();
    }

    @GetMapping("/transacoes/{id}")
    public Transaction getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/transacoes/{id}")
    public List<Transaction> deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }

//    @PostMapping("/transacoes")
//    public Transaction create(@RequestBody Map<String, String> json) throws Exception {
//        return service.create(json);
//    }
    
}
