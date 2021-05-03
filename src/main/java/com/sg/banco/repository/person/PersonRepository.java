package com.sg.banco.repository.person;

import com.sg.banco.domain.Person;
import io.gumga.domain.repository.GumgaCrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface PersonRepository extends JpaRepository<Person, Integer> {
//}

public interface PersonRepository  extends GumgaCrudRepository<Person, Long> {

}