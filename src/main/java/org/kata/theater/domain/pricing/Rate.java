package org.kata.theater.domain.pricing;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Rate {

    private final BigDecimal value;

    public Rate(String value) {
        this.value = new BigDecimal(value).setScale(3, RoundingMode.HALF_DOWN);
    }

    public Rate(BigDecimal value) {
        this.value = value.setScale(3, RoundingMode.HALF_DOWN);
    }

    public Rate(Rate other) {
        this.value = BigDecimal.ZERO.add(other.value);
    }

    public static Rate fully() {
        return new Rate(BigDecimal.ONE);
    }

    public static Rate discountPercent(String discountPercent) {
        return Rate.fully().subtract(new Rate(discountPercent).multiply(new Rate("0.01")));
    }

    public Amount apply(Amount amount) {
        return new Amount(amount.asBigDecimal().multiply(this.value));
    }

    public Rate add(Rate other) {
        return new Rate(this.value.add(other.value));
    }

    public Rate multiply(Rate other) {
        return new Rate(this.value.multiply(other.value));
    }

    public Rate subtract(Rate other) {
        return new Rate(this.value.subtract(other.value));
    }

    public BigDecimal asBigDecimal() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Objects.equals(value, rate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "value=" + value +
                '}';
    }
}