package com.sg.banco.api.person;

import com.sg.banco.domain.Person;
import com.sg.banco.service.person.LegalPersonService;
import com.sg.banco.service.person.NaturalPersonService;
import com.sg.banco.service.person.PersonService;
import io.gumga.annotations.GumgaSwagger;
import io.gumga.application.GumgaService;
import io.gumga.presentation.GumgaAPI;
import io.gumga.presentation.api.CSVGeneratorAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class PersonController extends GumgaAPI<Person, Long> implements CSVGeneratorAPI {

    @Autowired
    public PersonController(PersonService service) {
        super(service);
    }
//    private final NaturalPersonService naturalPersonService;
//    private final LegalPersonService legalPersonService;
//
//    @Autowired
//    public PersonController(PersonService service, NaturalPersonService naturalPersonService, LegalPersonService legalPersonService) {
//        super(service);
//        this.naturalPersonService = naturalPersonService;
//        this.legalPersonService = legalPersonService;
//    }

    @Override
    public GumgaService getGumgaService() {
        return (PersonService) service;
    }

//    @Autowired
//    private PersonService service;
//
//    @GetMapping("/usuarios")
//    public List<Person> getAll() {
//        return service.getAll();
//    }
//
//    @GetMapping("/usuarios/{id}")
//    public Person getById(@PathVariable Integer id) {
//        return service.getById(id);
//    }
//
//    @DeleteMapping("/usuarios/{id}")
//    public List<Person> deleteById(@PathVariable Integer id) {
//        return service.deleteById(id);
//    }
//
//    @PostMapping("/usuarios")
//    public Person create(@RequestBody Map<String, String> json) {
//        return service.create(json);
//    }

//    @GetMapping("/users/pf")
//    public List<NaturalPerson> getAllNaturalPerson() {
//        return this.service.getAllNaturalPerson();
//    }
//
//    @GetMapping("/users/pj")
//    public List<LegalPerson> getAllLegalPerson() {
//        return service.getAllLegalPerson();
//    }

//    @GumgaSwagger
//    @Transactional
//    @RequestMapping(
//            value = "/pf", method = GET
//    )
//    public ResponseEntity getAllNaturalPerson() {
//        try {
//            return ResponseEntity.ok(naturalPersonService.);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new Exception(e));
//        }
//    }
//
//    @GumgaSwagger
//    @Transactional
//    @RequestMapping(
//            value = "/pj", method = GET
//    )
//    public ResponseEntity getAllLegalPerson() {
//        try {
//            return ResponseEntity.ok(this.legalPersonService.pesquisa());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new Exception(e));
//        }
//    }


}
