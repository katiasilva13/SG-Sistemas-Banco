package com.sg.banco.domain.transaction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sg.banco.domain.account.Account;
import com.sg.banco.enumerator.TransactionType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "transfer_id")
@Entity(name="transfer")
public class Transfer extends Transaction {

//    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_account_id", referencedColumnName = "id", nullable = false)
    private Account destinationAccount;

    public Transfer(TransactionType transactionType, Double value, Account sourceAccount, Account destinationAccount) {
        super(transactionType, value, sourceAccount);
        this.destinationAccount = destinationAccount;

    }
}
