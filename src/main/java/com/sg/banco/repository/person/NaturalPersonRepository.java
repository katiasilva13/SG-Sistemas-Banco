package com.sg.banco.repository.person;

import com.sg.banco.domain.NaturalPerson;
import io.gumga.domain.repository.GumgaCrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Integer> {
//}

public interface NaturalPersonRepository  extends GumgaCrudRepository<NaturalPerson, Long> {}