package com.sg.banco.service.account;

import com.sg.banco.domain.account.Account;
import com.sg.banco.domain.account.CheckingAccount;
import com.sg.banco.domain.account.SavingsAccount;
import com.sg.banco.domain.person.Person;
import com.sg.banco.enumerator.AccountType;
import com.sg.banco.repository.account.AccountRepository;
import com.sg.banco.service.RateCalculator;
import com.sg.banco.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static org.springframework.util.StringUtils.trimWhitespace;

@Service
public class AccountService implements Serializable {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private CheckingAccountService checkingAccountService;

    @Autowired
    private SavingsAccountService savingsAccountService;

    @Autowired
    private PersonService personService;

    @Autowired
    private RateCalculator calculator;

    public List<Account> getAll() {
        return this.repository.findAll(Sort.by(Sort.Order.asc("accountCode")));
    }

    public Account getById(Integer id) {
        Optional<Account> accountOptional = this.repository.findById(id);
        if (accountOptional.isPresent()) {
            if (accountOptional.get() instanceof SavingsAccount) {
                SavingsAccount savingsAccount = calculator.calculateIncome(accountOptional.get().getId());
                this.update(savingsAccount);
                return savingsAccount;
            }
            if (accountOptional.get() instanceof CheckingAccount) {
                CheckingAccount checkingAccount = calculator.calculateInterest(accountOptional.get().getId());
                this.update(checkingAccount);
                return checkingAccount;
            }
        }
        return accountOptional.orElse(null);
    }

    public List<Account> deleteById(Integer id) {
        this.repository.deleteById(id);
        return getAll();
    }

    public List<CheckingAccount> getAllCheckingAccounts() {
        return this.checkingAccountService.getAll();
    }

    public List<SavingsAccount> getAllSavingsAccounts() {
        return this.savingsAccountService.getAll();
    }

    public Account create(Map<String, String> json) throws Exception {
        Integer checkType = Integer.parseInt(trimWhitespace(json.get("accountType")).toUpperCase(Locale.ROOT));
        AccountType accountType = null;
        for (AccountType type : AccountType.values()) {
            if (type.getCode().equals(checkType)) accountType = type;
        }

        Integer personId = Integer.parseInt(trimWhitespace(json.get("personId")).toUpperCase(Locale.ROOT));
        Person person = personService.getById(personId);
        if (duplicatedAccountType(personId, accountType)) {
            assert accountType != null;
            throw new Exception("Usuário já possui uma conta do tipo " + accountType.toString());
        }

        String branch = trimWhitespace(json.getOrDefault("branch", "317")).toUpperCase(Locale.ROOT);
        BigDecimal balance = BigDecimal.valueOf(Double.parseDouble(trimWhitespace(json.getOrDefault("balance", "0.0")).toUpperCase(Locale.ROOT)));

        String accountCode = generateCode(checkType, personId);

        Account account = null;
        assert accountType != null;
        if (accountType.equals(AccountType.CHECKING_ACCOUNT)) {
            BigDecimal overdraftLimit = BigDecimal.valueOf(Double.parseDouble(trimWhitespace(json.getOrDefault("overdraftLimit", "1000.00")).toUpperCase(Locale.ROOT)));
            BigDecimal interestRate = BigDecimal.valueOf(Double.parseDouble(trimWhitespace(json.getOrDefault("interestRate", "0.157")).toUpperCase(Locale.ROOT)));
            BigDecimal interest = BigDecimal.valueOf(Double.parseDouble(trimWhitespace(json.getOrDefault("interest", "0.0")).toUpperCase(Locale.ROOT)));
            BigDecimal overdraftAvailable = BigDecimal.valueOf(Double.parseDouble(trimWhitespace(json.getOrDefault("overdraftAvailable", overdraftLimit.toString())).toUpperCase(Locale.ROOT)));

            account = checkingAccountService.create(accountType, branch, balance, person,
                    overdraftLimit, interestRate, interest, accountCode, overdraftAvailable);

        } else if (accountType.equals(AccountType.SAVINGS_ACCOUNT)) {
            BigDecimal savingsRate = BigDecimal.valueOf(Double.parseDouble(trimWhitespace(json.getOrDefault("savingsRate", "0.087"))));
            BigDecimal savingsIncome = BigDecimal.valueOf(Double.parseDouble(trimWhitespace(json.getOrDefault("savingsIncome", "0.0"))));
            BigDecimal invested = BigDecimal.valueOf(Double.parseDouble(trimWhitespace(json.getOrDefault("invested", "0.0")).toUpperCase(Locale.ROOT)));
            account = savingsAccountService.create(accountType, branch, balance, person,
                    savingsRate, savingsIncome, accountCode, invested);
        }
        return account;
    }

    private Boolean duplicatedAccountType(Integer personId, AccountType accountType) {
        if (this.repository.existsByPersonId(personId)) {
            List<Account> accounts = this.repository.findAllByPersonId(personId);
            for (Account account : accounts
            ) {
                if (account.getAccountType().equals(accountType)) return true;
            }
        }
        return false;
    }

    private String generateCode(Integer checkType, Integer personId) {
        LocalDateTime localDate = LocalDateTime.now();
        String code = checkType.toString()
                .concat(personId.toString())
                .concat(String.valueOf(localDate.getMinute()))
                //    .concat(" ")
                .concat(String.valueOf(localDate.getSecond()))
                .concat(String.valueOf(localDate.getHour()))
                //    .concat(" ")
                .concat(String.valueOf(localDate.getDayOfYear()))
                .concat(getRandomNumberUsingInts().toString());
        return code;
    }

    public Integer getRandomNumberUsingInts() {
        int min = 0;
        int max = 9;
        Random random = new Random();
        Integer r = random.ints(min, max)
                .findFirst()
                .getAsInt();
        return r;
    }

    public List<Account> getByPersonId(Integer personId) {
        return this.repository.findAllByPersonId(personId);
    }

    public Account getByData(String destinationAccountCode, String destinationAccountBranch) {
        return this.repository.findByAccountCodeAndBranch(destinationAccountCode, destinationAccountBranch);
    }

    public void update(Account sourceAccount) {
        this.repository.save(sourceAccount);
    }

    public Account getAccountByCode(Map<String, String> json) {
        String accountCode = trimWhitespace(json.get("accountCode")).toUpperCase(Locale.ROOT);
        return this.repository.findByAccountCode(accountCode);
    }
}
