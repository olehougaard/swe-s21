package dk.via.money.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;
    private final String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money)) {
            return false;
        }
        Money other = (Money) obj;
        return amount.equals(other.amount) && currency.equals(other.currency);
    }

    public Money plus(Money other) {
        if (!currency.equals(other.currency)) throw new IllegalArgumentException("Incompatible currencies");
        return new Money(amount.add(other.amount), currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    public Money times(BigDecimal factor) {
        return new Money(amount.multiply(factor), currency);
    }

    public Money divide(BigDecimal valueOf) {
        return new Money(amount.divide(valueOf, RoundingMode.HALF_UP), currency);
    }

    @Override
    public String toString() {
        return String.format("%s %s", amount, currency);
    }
}
