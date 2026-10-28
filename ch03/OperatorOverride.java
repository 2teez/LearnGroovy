package com.practice.operatoroverride;

import com.practice.newmoney.NewMoney;

class OperatorOverride {

    public static void main(String[] args) {
        final var buck = new Money(1, "Naira");
        System.out.println(buck);
        assert buck.equals(new Money(1, "Naira"));
        assert buck.plus(buck).equals(new Money(2, "Naira"));
        assert buck.plus(3).equals(new Money(4, "Naira"));
        //
        final var buckVal = MoneyValue.getMoneyInstance(1, "Naira");
        final var buckVal2 = MoneyValue.getMoneyInstance(1, "Naira");
        System.out.println(buckVal == buckVal2); // false why?

        //
        final var buckVal4 = new NewMoney(1, "Naira");
        final var buckVal5 = new NewMoney(1, "Naira");
        System.out.println(buckVal4.equals(buckVal5)); // false why?
    }
}

// using records in Java is better than the boiler-code here
// close to what groovy makes avaliable.

final class MoneyValue {

    private final int amount;
    private final String currency;

    private MoneyValue(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static MoneyValue getMoneyInstance(int amount, String currency) {
        return new MoneyValue(amount, currency);
    }

    public MoneyValue plus(Money other) {
        if (other == null) return this;
        if (other.currency != currency) throw new IllegalArgumentException(
            "Can't add different type of Money"
        );
        return new MoneyValue(amount + other.amount, currency);
    }

    public MoneyValue plus(int other) {
        return new MoneyValue(amount + other, currency);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        MoneyValue another = (MoneyValue) other;
        return (
            this.amount == another.amount &&
            this.currency.equals(another.currency)
        );
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.amount, this.currency);
    }

    @Override
    public String toString() {
        return String.format("%d %s", this.amount, this.currency);
    }
}

final class Money {

    int amount;
    String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money plus(Money other) {
        if (other == null) return this;
        if (other.currency != currency) throw new IllegalArgumentException(
            "Can't add different type of Money"
        );
        return new Money(amount + other.amount, currency);
    }

    public Money plus(int other) {
        return new Money(amount + other, currency);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        Money another = (Money) other;
        return (
            this.amount == another.amount &&
            this.currency.equals(another.currency)
        );
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.amount, this.currency);
    }

    @Override
    public String toString() {
        return String.format("%d %s", this.amount, this.currency);
    }
}
