package com.sg.banco.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "checking_account_id")
@Entity
public class CheckingAccount extends Account {

    @Column(name = "overdraft_limit")//limite
    private Double overdraftLimit;

    @Column(name = "interest_rate")//taxa de juros
    private Double interestRate;

    @Column//juros
    private Double interest;

    @Column(name = "interest_days")//dias de juros
    private Double interestDays;
}
