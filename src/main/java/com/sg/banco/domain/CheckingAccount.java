package com.sg.banco.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "checking_account_id")
@Entity
public class CheckingAccount extends Account {

    @Column(name = "overdraft_limit")//limite
    private BigDecimal overdraftLimit;

    @Column(name = "overdraft_available")//limite disponível
    private BigDecimal overdraftAvailable;

    @Column(name = "interest_rate")//taxa de juros
    private BigDecimal interestRate;

    @Column//juros
    private BigDecimal interest;

    @Column(name = "interest_day")//dia que ultrapassou o limite
    private LocalDate interestDay;
}
