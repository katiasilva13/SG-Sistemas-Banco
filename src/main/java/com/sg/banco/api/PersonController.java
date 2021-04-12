package com.sg.banco.api;

import com.sg.banco.domain.LegalPerson;
import com.sg.banco.domain.NaturalPerson;
import com.sg.banco.domain.Person;
import com.sg.banco.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/usuarios")
    public List<Person> getAll() {
        return service.getAll();
    }

    @GetMapping("/usuarios/{id}")
    public Person getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/usuarios/{id}")
    public List<Person> deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PostMapping("/usuarios")
    public Person create(@RequestBody Map<String, String> json) {
        return service.create(json);
    }

    @GetMapping("/usuarios/pf")
    public List<NaturalPerson> getAllNaturalPerson() {
        return service.getAllNaturalPerson();
    }

    @GetMapping("/usuarios/pj")
    public List<LegalPerson> getAllLegalPerson() {
        return service.getAllLegalPerson();
    }


}
