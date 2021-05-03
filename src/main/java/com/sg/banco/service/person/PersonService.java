package com.sg.banco.service.person;

import com.sg.banco.domain.Address;
import com.sg.banco.domain.LegalPerson;
import com.sg.banco.domain.NaturalPerson;
import com.sg.banco.domain.Person;
import com.sg.banco.repository.person.PersonRepository;
import io.gumga.application.GumgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.springframework.util.StringUtils.trimWhitespace;

@Service
public class PersonService extends GumgaService<Person, Long> {

    @Lazy
    @Autowired
    private AddressService addressService;

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository repository) {
        super(repository);
        this.personRepository = repository;
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }


//    @Autowired
//    private PersonRepository repository;
//

    @Lazy
    @Autowired
    private NaturalPersonService naturalPersonService;


    @Lazy
    @Autowired
    private LegalPersonService legalPersonService;

//    @Autowired
//    private AddressService addressService;
//
//    public List<Person> getAll() {
//        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
//    }
//
//    public Person getById(Integer id) {
//        return this.repository.findById(id).get();
//    }
//
//    public List<Person> deleteById(Integer id) {
//        this.repository.deleteById(id);
//        return getAll();
//    }
//
//    public Person create(Map<String, String> json) {
//        String name = trimWhitespace(json.get("name")).toUpperCase(Locale.ROOT);
//        String phoneNumber = trimWhitespace(json.getOrDefault("phoneNumber", ""));
//        Address address = addressService.save(json);
//
//        Person person = null;
//        if (json.containsKey("cpf")) {
//            String cpf = trimWhitespace(json.get("cpf")).toUpperCase(Locale.ROOT);
//            String rg = trimWhitespace(json.get("rg")).toUpperCase(Locale.ROOT);
//            person = naturalPersonService.create(name, phoneNumber, address, cpf, rg);
//
//        } else if (json.containsKey("cnpj")) {
//            String cnpj = trimWhitespace(json.get("cnpj")).toUpperCase(Locale.ROOT);
//            String companyName = trimWhitespace(json.getOrDefault("companyName", name));
//            person = legalPersonService.create(name, phoneNumber, address, cnpj, companyName);
//        }
//
//        this.repository.save(person);
//        return person;
//    }

    @PersistenceContext
    private EntityManager entityManager;


//    public List<NaturalPerson> getAllNaturalPerson() {
//
//        return this.naturalPersonService.getAll();
//    }
//
//    public List<LegalPerson> getAllLegalPerson() {
//        return this.legalPersonService.getAll();
//    }

    public void update(Person person) {
        this.save(person);
    }

}
