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
@PrimaryKeyJoinColumn(name = "checking_account_id")
@Entity
public class CheckingAccount extends Account{

    @Column
    private Double overdraftLimit;

    @Column
    private Double interestRate;

    @Column
    private Double interest;


}
