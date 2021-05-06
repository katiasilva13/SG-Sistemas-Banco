package com.sg.banco.domain.account.dto;

import com.google.common.base.MoreObjects;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Integer id;
    private Integer personId;
    private String accountType;
    private String accountCode;
    private BigDecimal balance;
    private String branch;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("personId", personId)
                .add("accountType", accountType)
                .add("accountCode", accountCode)
                .add("branch", branch)
                .add("balance", balance)
                .toString();
    }

}
