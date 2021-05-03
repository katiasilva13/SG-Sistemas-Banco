package com.sg.banco.service.person;

import com.sg.banco.domain.person.Address;
import com.sg.banco.enumerator.UF;
import com.sg.banco.repository.person.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.springframework.util.StringUtils.trimWhitespace;

@Service
public class AddressService implements Serializable {

    @Autowired
    private AddressRepository repository;

    public List<Address> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("uf")));
    }

    public Address getById(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<Address> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public Address create(Map<String, String> json) {
        String city = trimWhitespace(json.get("city")).toUpperCase(Locale.ROOT);
        String street = trimWhitespace(json.getOrDefault("street", "")).toUpperCase(Locale.ROOT);
        String number = trimWhitespace(json.getOrDefault("number", "")).toUpperCase(Locale.ROOT);
        String neighborhood = trimWhitespace(json.getOrDefault("neighborhood", "")).toUpperCase(Locale.ROOT);
        String cep = trimWhitespace(json.getOrDefault("cep", "")).toUpperCase(Locale.ROOT);
        UF uf = UF.valueOf(trimWhitespace(json.get("uf")).toUpperCase(Locale.ROOT));

        Address address = Address.builder()
                .street(street)
                .number(number)
                .neighborhood(neighborhood)
                .city(city)
                .cep(cep)
                .uf(uf)
                .build();
        this.repository.save(address);
        return address;
    }

}
