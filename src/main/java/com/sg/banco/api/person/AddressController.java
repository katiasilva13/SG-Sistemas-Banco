package com.sg.banco.api.person;

import com.sg.banco.domain.Address;
import com.sg.banco.service.person.AddressService;
import io.gumga.application.GumgaService;
import io.gumga.presentation.GumgaAPI;
import io.gumga.presentation.api.CSVGeneratorAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/users/address")
public class AddressController extends GumgaAPI<Address, Long> implements CSVGeneratorAPI {

    @Autowired
    public AddressController(AddressService service) {
        super(service);
    }

    @Override
    public GumgaService getGumgaService() {
        return (AddressService) service;
    }

//    @Autowired
//    private AddressService service;
//
//    @GetMapping("/enderecos")
//    public List<Address> getAll() {
//        return service.findAll();
//    }
//
//    @GetMapping("/enderecos/{id}")
//    public Address getById(@PathVariable Integer id) {
//        return service.findById();
//    }
//
//    @DeleteMapping("/enderecos/{id}")
//    public List<Address> deleteById(@PathVariable Integer id) {
//        return service.deleteById(id);
//    }


}
