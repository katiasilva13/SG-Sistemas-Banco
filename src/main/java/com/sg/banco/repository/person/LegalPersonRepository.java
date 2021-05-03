package com.sg.banco.repository.person;

import com.sg.banco.domain.LegalPerson;
import com.sg.banco.domain.NaturalPerson;
import io.gumga.domain.repository.GumgaCrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface LegalPersonRepository extends JpaRepository<LegalPerson, Integer> {
//}

public interface LegalPersonRepository  extends GumgaCrudRepository<LegalPerson, Long> {}