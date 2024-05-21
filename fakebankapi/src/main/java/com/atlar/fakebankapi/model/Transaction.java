package com.atlar.fakebankapi.model;


public class Transaction {
    private String bookingDate;
    private String amount;
    private String currency;
    private String remittanceInformation;
    private String uniqueIdentifier;
    private String accountName;

    public Transaction(String bookingDate, String amount, String currency, String remittanceInformation, String uniqueIdentifier, String accountName) {
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.currency = currency;
        this.remittanceInformation = remittanceInformation;
        this.uniqueIdentifier = uniqueIdentifier;
        this.accountName = accountName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRemittanceInformation() {
        return remittanceInformation;
    }

    public void setRemittanceInformation(String remittanceInformation) {
        this.remittanceInformation = remittanceInformation;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
