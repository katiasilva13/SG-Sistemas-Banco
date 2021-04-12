package com.sg.banco.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "savings_account_id")
@Entity
public class SavingsAccount extends Account{

    @Column(name = "savings_rate")//taxa de rendimento da poupança
    private Double savingsRate;

    @Column(name = "savings_income")//rendimento da poupança
    private Double savingsIncome;
}
