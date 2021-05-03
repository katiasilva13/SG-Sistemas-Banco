package com.sg.banco.repository.person;

import com.sg.banco.domain.Address;
import io.gumga.domain.repository.GumgaCrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface AddressRepository extends JpaRepository<Address, Integer> {
//}

public interface AddressRepository extends GumgaCrudRepository<Address, Long> {
}