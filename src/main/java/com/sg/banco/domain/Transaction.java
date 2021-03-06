package com.sg.banco.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sg.banco.enumerator.TransactionType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "value")
    private Double value;

    @CreationTimestamp
    @Column(name = "timestamp",  insertable = false, updatable = false)
    private Timestamp timestamp;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "source_account_id", referencedColumnName = "id", nullable = false)
    private Account sourceAccount;

    public Transaction(TransactionType transactionType, Double value, Account sourceAccount) {
        this.transactionType = transactionType;
        this.value = value;
        this.sourceAccount = sourceAccount;
    }
}
