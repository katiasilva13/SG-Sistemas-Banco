package com.sg.banco.service.person;

import com.sg.banco.domain.Address;
import com.sg.banco.enumerator.UF;
import com.sg.banco.repository.person.AddressRepository;
import io.gumga.application.GumgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.springframework.util.StringUtils.trimWhitespace;

@Service
public class AddressService extends GumgaService<Address, Long> {

//    @Lazy
//    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository repository) {
        super(repository);
        this.addressRepository = repository;
    }

//    public List<Address> getAll() {
//        return this.repository.findAll(Sort.by(Sort.Order.asc("uf")));
//    }
//
//    public Address getById(Integer id) {
//        return this.repository.findById(id).get();
//    }
//
//    public List<Address> deleteById(Integer id) {
//        this.repository.deleteById(id);
//        return getAll();
//    }

//    public Address save(Map<String, String> json) {
//public Address save(Address address) {
////        String city = trimWhitespace(json.get("city")).toUpperCase(Locale.ROOT);
////        String street = trimWhitespace(json.getOrDefault("street", "")).toUpperCase(Locale.ROOT);
////        String number = trimWhitespace(json.getOrDefault("number", "")).toUpperCase(Locale.ROOT);
////        String neighborhood = trimWhitespace(json.getOrDefault("neighborhood", "")).toUpperCase(Locale.ROOT);
////        String cep = trimWhitespace(json.getOrDefault("cep", "")).toUpperCase(Locale.ROOT);
////        UF uf = UF.valueOf(trimWhitespace(json.get("uf")).toUpperCase(Locale.ROOT));
//    String city = trimWhitespace(address.getCity()).toUpperCase(Locale.ROOT);
//    String street = trimWhitespace(address.getStreet()).toUpperCase(Locale.ROOT);
//    String number = trimWhitespace(address.getNumber()).toUpperCase(Locale.ROOT);
//    String neighborhood = trimWhitespace(address.getNeighborhood()).toUpperCase(Locale.ROOT);
//    String cep = trimWhitespace(address.getCep()).toUpperCase(Locale.ROOT);
//
//        Address addressFormatted = Address.builder()
//                .street(street)
//                .number(number)
//                .neighborhood(neighborhood)
//                .city(city)
//                .cep(cep)
//                .uf(address.getUf())
//                .build();
//        this.repository.save(addressFormatted);
//        return addressFormatted;
//    }

    public void deleteAll() {
        addressRepository.deleteAll();
    }

    public List<Address> findAll() {
        return addressRepository.findAllWithTenancy().getValues();
    }
}
