package com.fastcampuspay.banking.adapter.out.external.bank;

import lombok.Data;
import lombok.Getter;

@Data
public class BankAccount {

    private String bankAccountNumber;
    private String bankName;
    private boolean isValid;

    public BankAccount(String bankAccountNumber, String bankName, boolean isValid) {
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.isValid = isValid;
    }
}
