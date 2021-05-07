package com.sg.banco.repository.person;

import com.sg.banco.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

//    Person findByNameAndCpfOrCnpj(String name, String doc);


    Person findByName(String name);

    List<Person> findAllByName(String name);
}
