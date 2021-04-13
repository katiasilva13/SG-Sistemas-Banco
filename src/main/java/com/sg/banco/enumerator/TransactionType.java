package com.sg.banco.enumerator;

public enum TransactionType {
    DEPOSIT(3),
    TRANSFER(4),
    WITHDRAWAL(5)
    ;

    private Integer code;

    TransactionType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
