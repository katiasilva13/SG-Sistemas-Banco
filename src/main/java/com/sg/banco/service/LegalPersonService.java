package com.sg.banco.service;

import com.sg.banco.domain.Address;
import com.sg.banco.domain.LegalPerson;
import com.sg.banco.repository.LegalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class LegalPersonService implements Serializable {

    @Autowired
    private LegalPersonRepository repository;

    public List<LegalPerson> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public LegalPerson getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<LegalPerson> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public LegalPerson create(String name, String phoneNumber, Address address, String cnpj, String companyName) {
        LegalPerson person = LegalPerson.builder()
                .cnpj(cnpj)
                .companyName(companyName)
                .build();
        person.setAddress(address);
        person.setName(name);
        person.setPhoneNumber(phoneNumber);
        this.repository.save(person);
        return person;
    }

}
