package com.sg.banco.service;

import com.sg.banco.domain.account.CheckingAccount;
import com.sg.banco.domain.account.SavingsAccount;
import com.sg.banco.service.account.CheckingAccountService;
import com.sg.banco.service.account.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class RateCalculator {

    @Autowired
    private SavingsAccountService savingsAccountService;

    @Autowired
    private CheckingAccountService checkingAccountService;

    public SavingsAccount calculateIncome(Integer id) {
        SavingsAccount account = savingsAccountService.getById(id);
        if (Objects.nonNull(account.getInvestmentDay())) {
            LocalDate today = LocalDate.now();
            int countDays = Math.toIntExact(DAYS.between(account.getInvestmentDay(), today));
            BigDecimal invested = account.getInvested();
            for (int i = countDays; i > 0; i--) {
                invested = invested.multiply(account.getSavingsRate()).divide(account.getSavingsRate(), new MathContext(3));
            }
            BigDecimal balance = account.getBalance().subtract(account.getSavingsIncome());
            account.setSavingsIncome(invested.round(new MathContext(3)));
            account.setBalance(balance.add(invested).round(new MathContext(2)));
        }
        return account;
    }

    public CheckingAccount calculateInterest(Integer id) {
        CheckingAccount account = checkingAccountService.getById(id);
        if (Objects.nonNull(account.getInterestDay())) {
            LocalDate today = LocalDate.now();
            int countDays = Math.toIntExact(DAYS.between(account.getInterestDay(), today));
            BigDecimal interest = account.getOverdraftLimit().subtract(account.getOverdraftAvailable());
            for (int i = countDays; i > 0; i--) {
                interest = interest.multiply(account.getInterestRate()).divide(account.getInterestRate(), new MathContext(3));
            }
            account.setInterest(interest.round(new MathContext(2)));
        }
        return account;
    }
}
