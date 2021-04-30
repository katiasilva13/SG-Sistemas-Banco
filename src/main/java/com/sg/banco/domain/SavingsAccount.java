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
@PrimaryKeyJoinColumn(name = "savings_account_id")
@Entity(name="savings_account")
public class SavingsAccount extends Account {

    @Column(name = "savings_rate")//taxa de rendimento da poupança
    private BigDecimal savingsRate;

    @Column(name = "savings_income")//rendimento da poupança
    private BigDecimal savingsIncome;

    @Column//dinheiro investido
    private BigDecimal invested;

    @Column(name = "investment_day")//dia do investimento
    private LocalDate investmentDay;

}
