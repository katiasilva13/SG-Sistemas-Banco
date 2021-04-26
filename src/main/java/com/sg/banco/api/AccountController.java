package com.sg.banco.api;

import com.sg.banco.domain.Account;
import com.sg.banco.domain.CheckingAccount;
import com.sg.banco.domain.SavingsAccount;
import com.sg.banco.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/contas")
    public List<Account> getAll() {
        return service.getAll();
    }

    @GetMapping("/contas/{id}")
    public Account getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/contas/{id}")
    public List<Account> deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PostMapping("/contas")
    public Account create(@RequestBody Map<String, String> json) throws Exception {
        return service.create(json);
    }

    @GetMapping("/contas/corrente")
    public List<CheckingAccount> getAllCheckingAccounts() {
        return service.getAllCheckingAccounts();
    }

    @GetMapping("/contas/poupanca")
    public List<SavingsAccount> getAllSavingsAccounts() {
        return service.getAllSavingsAccounts();
    }

    @GetMapping("/contas/usuario/{personId}")
    public List<Account> getByPersonId(@PathVariable Integer personId) {
        return service.getByPersonId(personId);
    }

}
