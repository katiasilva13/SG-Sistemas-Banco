package com.sg.banco.service;

import com.sg.banco.domain.Account;
import com.sg.banco.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService service;

    @Autowired
    private PersonService personService;

    private Map<String, String> getStringStringMapPF() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", " Marcos Vinicius Eduardo Alexandre da Cruz");
        params.put("phoneNumber", "(66) 98272-8616");
        params.put("cpf", "472.491.213-83");
        params.put("rg", "3.898.543-11");
        params.put("street", "Rua Mônaco");
        params.put("number", "747");
        params.put("neighborhood", "Loteamento Residencial Três Américas");
        params.put("city", "Rondonópolis");
        params.put("cep", "78736-078");
        params.put("uf", "MT");
        return params;
    }

    private Map<String, String> getStringStringMapPJ() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "Carla e Bryan Contábil Ltda");
        params.put("phoneNumber", "(14) 2580-9331");
        params.put("cnpj", "61.866.032/0001-69");
        params.put("street", "Rua Três");
        params.put("number", "215");
        params.put("neighborhood", "Sítios Village Paineiras");
        params.put("city", "Bauru");
        params.put("cep", "17048-520");
        params.put("uf", "SP");
        return params;
    }

    private Map<String, String> getStringStringMapCA(Integer personId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("accountType", "1");
        params.put("branch", "317");
        params.put("personId", personId.toString());
        return params;
    }

    private Map<String, String> getStringStringMapSA(Integer personId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("accountType", "2");
        params.put("branch", "317");
        params.put("personId", personId.toString());
        return params;
    }

    @Test
    @Transactional
    void testCreateSavingsAccountPF() {
        Person person = this.personService.create(getStringStringMapPF());
        Account account = this.service.create(getStringStringMapSA(person.getId()));
        Assertions.assertEquals("317",
                service.getById(account.getId()).getBranch());
    }

//    @Test
//    @Transactional
//    void testCreateCheckingAccountPJ() {
//        Person person = this.personService.create(getStringStringMapPJ());
//    }

//    @Test
//    void getAll() {
//    }
//
//    @Test
//    void getById() {
//    }
}