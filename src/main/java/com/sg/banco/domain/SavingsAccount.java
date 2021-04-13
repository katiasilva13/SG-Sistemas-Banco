package com.sg.banco.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
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
    private Double savingsRate;

    @Column(name = "savings_income")//rendimento da poupança
    private Double savingsIncome;

    @Column(name = "investment_days")//dias rendendo
    private LocalDate investmentDays;

}
