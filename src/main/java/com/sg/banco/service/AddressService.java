package com.sg.banco.service;

import com.sg.banco.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AddressService  implements Serializable {

    @Autowired
    private AddressRepository repository;
}
