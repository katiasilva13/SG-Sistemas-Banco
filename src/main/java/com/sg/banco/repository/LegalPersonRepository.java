package com.sg.banco.repository;

import com.sg.banco.domain.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalPersonRepository extends JpaRepository<LegalPerson, Integer> {
}
