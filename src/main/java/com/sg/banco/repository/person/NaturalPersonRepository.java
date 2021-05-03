package com.sg.banco.repository.person;

import com.sg.banco.domain.person.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Integer> {
}
