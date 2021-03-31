package com.sg.banco.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_code")
    private String accountCode;

    @Column
    private String balance;

    @Column
    private String branch;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private Person person;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<FinancialTransaction> financialTransactions;

}
