package com.sg.banco.domain.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sg.banco.domain.person.Person;
import com.sg.banco.enumerator.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "account_type")// corrente=1 ; poupança=2
    private AccountType accountType;

    @Column(name = "account_code")//numero da conta
    private String accountCode;

    @Column(name = "branch")//agencia
    private String branch;

    @Column//extrato
    private BigDecimal balance;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private Person person;
//
//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
//    private List<Transaction> transactions;

}
