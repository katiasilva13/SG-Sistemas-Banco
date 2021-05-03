package com.sg.banco.service;

import com.sg.banco.domain.person.Person;
import com.sg.banco.service.person.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService service;

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

    @Test
    @Transactional
    void testGetById() {
        Person person = this.service.create(getStringStringMapPF());
        Assertions.assertDoesNotThrow(() -> {
            this.service.getById(person.getId());
        });
    }

    @Test
    @Transactional
    void testCreatePF() {
        Person person = this.service.create(getStringStringMapPF());
        Assertions.assertEquals("MARCOS VINICIUS EDUARDO ALEXANDRE DA CRUZ",
                service.getById(person.getId()).getName());
    }

    @Test
    @Transactional
    void testCreatePJ() {
        Person person = this.service.create(getStringStringMapPJ());
        Assertions.assertEquals("CARLA E BRYAN CONTÁBIL LTDA",
                service.getById(person.getId()).getName());
    }

    @Test
    @Transactional
    void testGetAll(){
        Person pf = this.service.create(getStringStringMapPF());
        Person pj = this.service.create(getStringStringMapPJ());
        List<Person> people = new ArrayList<>();
        people.add(pf);
        people.add(pj);
        Assertions.assertDoesNotThrow(() -> {
            this.service.getAll().containsAll(people);
        });
    }

    @Test
    @Transactional
    void deletePF() {
        Person person = this.service.create(getStringStringMapPF());
        Assertions.assertDoesNotThrow(() -> {
            this.service.deleteById(person.getId());
        });
    }
}