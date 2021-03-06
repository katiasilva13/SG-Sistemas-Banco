package com.sg.banco.repository;

import com.sg.banco.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Boolean existsByPersonId(Integer personId);

    List<Account> findAllByPersonId(Integer personId);

    Account findByAccountCodeAndBranch(String code, String branch);

}
