package com.sg.banco.api.person;

import com.sg.banco.domain.person.Address;
import com.sg.banco.service.person.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping("/enderecos")
    public List<Address> getAll() {
        return service.getAll();
    }

    @GetMapping("/enderecos/{id}")
    public Address getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/enderecos/{id}")
    public List<Address> deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }

}
