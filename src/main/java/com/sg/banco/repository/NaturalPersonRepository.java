package com.sg.banco.repository;

import com.sg.banco.domain.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Integer> {
}
