package com.sg.banco.repository;

import com.sg.banco.domain.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Integer> {
}
