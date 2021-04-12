package com.sg.banco.enumerator;

public enum AccountType {
    CHECKING_ACCOUNT(1),
    SAVINGS_ACCOUNT(2)
    ;

    private Integer code;

    AccountType(Integer code) {
        this.code = code;
    }
}
