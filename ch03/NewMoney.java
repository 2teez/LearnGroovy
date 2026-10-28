package com.practice.newmoney;

public record NewMoney(int amount, String currency) {
    public NewMoney plus(NewMoney other) {
        if (other == null) return this;
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException(
                "can't add diffent type of Object"
            );
        }
        return new NewMoney(amount + other.amount, currency);
    }

    public NewMoney plus(int amt) {
        return new NewMoney(amount + amt, currency);
    }
}
