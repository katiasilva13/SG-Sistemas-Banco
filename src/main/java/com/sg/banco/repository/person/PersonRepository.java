package com.sg.banco.repository.person;

import com.sg.banco.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

//
//    @Query("select p from person p join account a where a.id = :account_id and a.person_id = p.id")
//    Person findPersonByAccountId(@Param("account_id") Integer account_id);
}
