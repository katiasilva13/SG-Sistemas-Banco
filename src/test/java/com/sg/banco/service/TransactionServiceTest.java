//package com.sg.banco.service;
//
//import com.sg.banco.domain.Account;
//import com.sg.banco.domain.CheckingAccount;
//import com.sg.banco.domain.Person;
//import com.sg.banco.service.account.AccountService;
//import com.sg.banco.service.person.PersonService;
//import com.sg.banco.service.transaction.TransactionService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
//@SpringBootTest
//class TransactionServiceTest {
//
//    @Autowired
//    private TransactionService service;
//
//    @Autowired
//    private AccountService accountService;
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
//    private Map<String, String> getStringStringMapDeposit(Integer accountId) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("transactionType", "3");
//        params.put("value", "317.00");
//        params.put("sourceAccountId", accountId.toString());
//        return params;
//    }
//
//    private Map<String, String> getStringStringMapWithdrawal(Integer accountId) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("transactionType", "5");
//        params.put("value", "109.90");
//        params.put("sourceAccountId", accountId.toString());
//        return params;
//    }
//
//    private Map<String, String> getStringStringMapTranfer(Integer accountId, Account destination) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("transactionType", "4");
//        params.put("value", "109.90");
//        params.put("sourceAccountId", accountId.toString());
//        params.put("destinationAccountType", destination.getAccountType().toString());
//        params.put("destinationAccountCode", destination.getAccountCode());
//        params.put("destinationAccountBranch", destination.getBranch());
//        return params;
//    }
//
////    @Test
////    @Transactional
////    void depositPJSavingsAccount() throws Exception {
////        Person pj = personService.create(getStringStringMapPJ());
////        Account sa = accountService.create(getStringStringMapSA(pj.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.createTransaction(getStringStringMapDeposit(sa.getId()));
////        });
////    }
////
////    @Test
////    @Transactional
////    void withdrawalPFSavingsAccount() throws Exception {
////        Person pf = personService.create(getStringStringMapPF());
////        Account sa = accountService.create(getStringStringMapSA(pf.getId()));
////        this.service.createTransaction(getStringStringMapDeposit(sa.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.createTransaction(getStringStringMapWithdrawal(sa.getId()));
////        });
////    }
////
////    @Test
////    @Transactional
////    void depositPJCheckingAccount() throws Exception {
////        Person pj = personService.create(getStringStringMapPJ());
////        Account ca = accountService.create(getStringStringMapCA(pj.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.createTransaction(getStringStringMapDeposit(ca.getId()));
////        });
////    }
////
////    @Test
////    @Transactional
////    void withdrawalPFCheckingAccount() throws Exception {
////        Person pf = personService.create(getStringStringMapPF());
////        Account ca = accountService.create(getStringStringMapCA(pf.getId()));
////        this.service.createTransaction(getStringStringMapDeposit(ca.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.createTransaction(getStringStringMapWithdrawal(ca.getId()));
////        });
////    }
////
////    @Test
////    @Transactional
////    void withdrawalLimitPFCheckingAccount() throws Exception {
////        Person pf = personService.create(getStringStringMapPF());
////        Account ca = accountService.create(getStringStringMapCA(pf.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.createTransaction(getStringStringMapWithdrawal(ca.getId()));
////        });
////    }
////
////    @Test
////    @Transactional
////    void depositPayInterestPFCheckingAccount() throws Exception {
////        Person pf = personService.create(getStringStringMapPF());
////        Account ca = accountService.create(getStringStringMapCA(pf.getId()));
////        this.service.createTransaction(getStringStringMapWithdrawal(ca.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.createTransaction(getStringStringMapDeposit(ca.getId()));
////        });
////        Assertions.assertEquals(BigDecimal.valueOf(207.1), accountService.getById(ca.getId()).getBalance());
////    }
////
////    @Test
////    @Transactional
////    void depositInvestmentPJCheckingAccount() throws Exception {
////        Person pj = personService.create(getStringStringMapPJ());
////        Account ca = accountService.create(getStringStringMapCA(pj.getId()));
////        this.service.createTransaction(getStringStringMapDeposit(ca.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.createTransaction(getStringStringMapDeposit(ca.getId()));
////        });
////        Assertions.assertEquals(BigDecimal.valueOf(634.0), accountService.getById(ca.getId()).getBalance());
////    }
////
////    @Test
////    @Transactional
////    void transferPJCAtoPFSA() throws Exception {
////        Person pj = personService.create(getStringStringMapPJ());
////        Account ca = accountService.create(getStringStringMapCA(pj.getId()));
////        Person pf = personService.create(getStringStringMapPF());
////        Account sa = accountService.create(getStringStringMapSA(pf.getId()));
////        this.service.createTransaction(getStringStringMapDeposit(ca.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.createTransaction(getStringStringMapTranfer(ca.getId(), sa));
////        });
////        Assertions.assertEquals(BigDecimal.valueOf(207.1), ca.getBalance());
////
////    }
////
////    @Test
////    @Transactional
////    void transferPJCALimitToPFSA() throws Exception {
////        Person pj = personService.create(getStringStringMapPJ());
////        Account ca = accountService.create(getStringStringMapCA(pj.getId()));
////        Person pf = personService.create(getStringStringMapPF());
////        Account sa = accountService.create(getStringStringMapSA(pf.getId()));
////        Assertions.assertDoesNotThrow(() -> {
////            this.service.createTransaction(getStringStringMapTranfer(ca.getId(), sa));
////        });
////        Assertions.assertEquals(BigDecimal.valueOf(890.1),
////                ((CheckingAccount) ca).getOverdraftAvailable());
////
////    }
//
//}