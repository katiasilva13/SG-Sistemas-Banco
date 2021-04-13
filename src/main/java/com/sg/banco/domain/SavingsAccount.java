package com.sg.banco.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "savings_account_id")
@Entity
public class SavingsAccount extends Account {

    @Column(name = "savings_rate")//taxa de rendimento da poupança
    private BigDecimal savingsRate;

    @Column(name = "savings_income")//rendimento da poupança
    private BigDecimal savingsIncome;

    @Column(name = "investment_day")//dia do investimento
    private LocalDate investmentDay;

}
