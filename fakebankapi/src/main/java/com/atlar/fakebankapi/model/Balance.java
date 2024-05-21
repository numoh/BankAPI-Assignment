package com.atlar.fakebankapi.model;

public class Balance {

    private String amount;
    private String creditLineAmount;
    private String type;
    private String creditDebitIndicator;
    private String date;

    public Balance() {}

    public Balance(String amount, String creditLineAmount, String type, String creditDebitIndicator, String date) {
        this.amount = amount;
        this.creditLineAmount = creditLineAmount;
        this.type = type;
        this.creditDebitIndicator = creditDebitIndicator;
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public String getCreditLineAmount() {
        return creditLineAmount;
    }

    public String getType() {
        return type;
    }

    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Balance{" +
            "amount='" + amount + '\'' +
            ", creditLineAmount='" + creditLineAmount + '\'' +
            ", type='" + type + '\'' +
            ", creditDebitIndicator='" + creditDebitIndicator + '\'' +
            ", date=" + date +
            '}';
    }
}
