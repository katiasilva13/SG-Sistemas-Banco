package com.sg.banco.service.person;

import com.sg.banco.domain.person.Address;
import com.sg.banco.domain.person.LegalPerson;
import com.sg.banco.domain.person.NaturalPerson;
import com.sg.banco.domain.person.Person;
import com.sg.banco.repository.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.springframework.util.StringUtils.trimWhitespace;

@Service
public class PersonService implements Serializable {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private NaturalPersonService naturalPersonService;

    @Autowired
    private LegalPersonService legalPersonService;

    @Autowired
    private AddressService addressService;

    public List<Person> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Person getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<Person> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public Person create(Map<String, String> json) {
        String name = trimWhitespace(json.get("name")).toUpperCase(Locale.ROOT);
        String phoneNumber = trimWhitespace(json.getOrDefault("phoneNumber", ""));
        Address address = addressService.create(json);

        Person person = null;
        if (json.containsKey("cpf")) {
            String cpf = trimWhitespace(json.get("cpf")).toUpperCase(Locale.ROOT);
            String rg = trimWhitespace(json.get("rg")).toUpperCase(Locale.ROOT);
            person = naturalPersonService.create(name, phoneNumber, address, cpf, rg);

        } else if (json.containsKey("cnpj")) {
            String cnpj = trimWhitespace(json.get("cnpj")).toUpperCase(Locale.ROOT);
            String companyName = trimWhitespace(json.getOrDefault("companyName", name));
            person = legalPersonService.create(name, phoneNumber, address, cnpj, companyName);
        }

        this.repository.save(person);
        return person;
    }

    public List<NaturalPerson> getAllNaturalPerson() {
        return naturalPersonService.getAll();
    }

    public List<LegalPerson> getAllLegalPerson() {
        return legalPersonService.getAll();
    }

    public void update(Person person) {
        this.repository.save(person);
    }

}
