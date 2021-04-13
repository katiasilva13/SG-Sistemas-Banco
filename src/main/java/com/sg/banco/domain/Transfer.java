package com.sg.banco.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sg.banco.enumerator.TransactionType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "transfer_id")
@Entity
public class Transfer extends Transaction {

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_account_id", referencedColumnName = "id", nullable = false)
    private Account destinationAccount;

    public Transfer(TransactionType transactionType, Double value, Account sourceAccount, Account destinationAccount) {
        super(transactionType, value, sourceAccount);
        this.destinationAccount = destinationAccount;

    }
}
