package com.sg.banco.service.person;

import com.sg.banco.domain.Address;
import com.sg.banco.domain.NaturalPerson;
import com.sg.banco.domain.Person;
import com.sg.banco.repository.person.NaturalPersonRepository;
import io.gumga.application.GumgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class NaturalPersonService extends GumgaService<NaturalPerson, Long> {

    private NaturalPersonRepository naturalPersonRepository;

    @Autowired
    public NaturalPersonService(NaturalPersonRepository repository) {
        super(repository);
        this.naturalPersonRepository = repository;
    }
//    @Autowired
//    private NaturalPersonRepository repository;
//
//    public List<NaturalPerson> getAll() {
//        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
//    }
//
//    public NaturalPerson getById(Integer id) {
//        return this.repository.findById(id).get();
//    }
//
//    public List<NaturalPerson> deleteById(Integer id) {
//        this.repository.deleteById(id);
//        return getAll();
//    }
//
//    public NaturalPerson create(String name, String phoneNumber, Address address, String cpf, String rg) {
//        NaturalPerson person = NaturalPerson.builder()
//                .cpf(cpf)
//                .rg(rg)
//                .build();
//        person.setAddress(address);
//        person.setName(name);
//        person.setPhoneNumber(phoneNumber);
//        this.repository.save(person);
//        return person;
//    }

}
