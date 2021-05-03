package com.sg.banco.repository.person;

import com.sg.banco.domain.person.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalPersonRepository extends JpaRepository<LegalPerson, Integer> {
}
