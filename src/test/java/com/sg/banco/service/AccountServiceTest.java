//package com.sg.banco.service;
//
//import com.sg.banco.domain.Account;
//import com.sg.banco.domain.Person;
//import com.sg.banco.enumerator.AccountType;
//import com.sg.banco.service.account.AccountService;
//import com.sg.banco.service.person.PersonService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//class AccountServiceTest {
//
//    @Autowired
//    private AccountService service;
//
//    @Autowired
//    private PersonService personService;
//
//    private Map<String, String> getStringStringMapPF() {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("name", " Marcos Vinicius Eduardo Alexandre da Cruz");
//        params.put("phoneNumber", "(66) 98272-8616");
//        params.put("cpf", "472.491.213-83");
//        params.put("rg", "3.898.543-11");
//        params.put("street", "Rua Mônaco");
//        params.put("number", "747");
//        params.put("neighborhood", "Loteamento Residencial Três Américas");
//        params.put("city", "Rondonópolis");
//        params.put("cep", "78736-078");
//        params.put("uf", "MT");
//        return params;
//    }
//
//    private Map<String, String> getStringStringMapPJ() {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("name", "Carla e Bryan Contábil Ltda");
//        params.put("phoneNumber", "(14) 2580-9331");
//        params.put("cnpj", "61.866.032/0001-69");
//        params.put("street", "Rua Três");
//        params.put("number", "215");
//        params.put("neighborhood", "Sítios Village Paineiras");
//        params.put("city", "Bauru");
//        params.put("cep", "17048-520");
//        params.put("uf", "SP");
//        return params;
//    }
//
//    private Map<String, String> getStringStringMapCA(Integer personId) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("accountType", "1");
//        params.put("branch", "317");
//        params.put("personId", personId.toString());
//        return params;
//    }
//
//    private Map<String, String> getStringStringMapSA(Integer personId) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("accountType", "2");
//        params.put("branch", "317");
//        params.put("personId", personId.toString());
//        return params;
//    }
//
////    @Test
////    @Transactional
////    void createSavingsAccountPFSuccess() throws Exception {
////        Person person = this.personService.create(getStringStringMapPF());
////        Account account = this.service.create(getStringStringMapSA(person.getId()));
////        Assertions.assertEquals(AccountType.SAVINGS_ACCOUNT,
////                service.getById(account.getId()).getAccountType());
////    }
////
////    @Test
////    @Transactional
////    void createCheckingAccountPJSuccess() throws Exception {
////        Person person = this.personService.create(getStringStringMapPJ());
////        Account account = this.service.create(getStringStringMapCA(person.getId()));
////        Assertions.assertEquals(AccountType.CHECKING_ACCOUNT,
////                service.getById(account.getId()).getAccountType());
////    }
////
////    @Test
////    @Transactional
////    void getAllSuccess() throws Exception {
////        Person pf = this.personService.create(getStringStringMapPF());
////        Account sa = this.service.create(getStringStringMapSA(pf.getId()));
////        Person pj = this.personService.create(getStringStringMapPJ());
////        Account ca = this.service.create(getStringStringMapCA(pj.getId()));
////        List<Account> accounts = new ArrayList<>();
////        accounts.add(sa);
////        accounts.add(ca);
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.getAll().containsAll(accounts);
////        });
////    }
////
////    @Test
////    @Transactional
////    void duplicatedAccountTypeTrue() throws Exception {
////        Person pf = this.personService.create(getStringStringMapPF());
////        this.service.create(getStringStringMapSA(pf.getId()));
////        Assertions.assertThrows(Exception.class, () -> {
////            this.service.create(getStringStringMapSA(pf.getId()));
////        });
////    }
////
////    @Test
////    @Transactional
////    void duplicatedAccountTypeFalse() throws Exception {
////        Person pj = this.personService.create(getStringStringMapPJ());
////        this.service.create(getStringStringMapSA(pj.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.create(getStringStringMapCA(pj.getId()));
////        });
////    }
//
//}