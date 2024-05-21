package com.atlar.fakebankapi.model;

import java.util.List;

public class Account {

    private String accountNumber;
    private String currency;
    private String ownerName;
    private List<Balance> balances;

    public Account(String accountNumber, String currency, String ownerName, List<Balance> balances) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.ownerName = ownerName;
        this.balances = balances;
    }

    public Account() { }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    @Override
    public String toString() {
        return "Account{" +
            "accountNumber='" + accountNumber + '\'' +
            ", currency='" + currency + '\'' +
            ", ownerName='" + ownerName + '\'' +
            ", balances=" + balances +
            '}';
    }
}
