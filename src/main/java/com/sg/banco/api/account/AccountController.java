package com.sg.banco.api.account;

import com.sg.banco.domain.account.Account;
import com.sg.banco.domain.account.CheckingAccount;
import com.sg.banco.domain.account.SavingsAccount;
import com.sg.banco.domain.account.dto.AccountDto;
import com.sg.banco.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/contas/{id}/usuario")
//    public ResponseEntity<AccountDto> getAccountWithPerson(@PathVariable Integer id) {
//        return service.getAccountWithPerson(id);
//    }

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
