package com.atlar.fakebankapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
public class Transaction {

    @Id
    private String uniqueIdentifier;
    private LocalDate bookingDate;
    private double amount;
    private String currency;
    private String remittanceInformation;

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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
}
