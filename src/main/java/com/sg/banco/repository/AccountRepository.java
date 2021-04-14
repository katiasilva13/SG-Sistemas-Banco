package com.sg.banco.repository;

import com.sg.banco.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
     Boolean existsByPersonId(Integer personId);

    List<Account> findAllByPersonId(Integer personId);

    @Query(nativeQuery = true, value = "SELECT a FROM account a " +
            "WHERE a.account_type = :type AND a.account_code = :code AND a.branch = :branch")
    Account findWhereAccountTypeAndAccountCodeAndBranch(@Param("type")String type,
                                                        @Param("code") String code,
                                                        @Param("branch")String branch);
}
