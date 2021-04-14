package dk.via.money.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    private Money usd0;
    private Money usd100;
    private Money eur100;
    private BigDecimal dec100;
    private BigDecimal dec200;

    @BeforeEach
    public void setUp() {
        dec100 = BigDecimal.valueOf(100);
        dec200 = BigDecimal.valueOf(200);
        usd0 = new Money(BigDecimal.ZERO, "USD");
        usd100 = new Money(dec100, "USD");
        eur100 = new Money(dec100, "EUR");
    }

    @Test
    public void zeroDollarsHasAZeroAmount() {
        assertEquals(BigDecimal.ZERO, usd0.getAmount());
    }

    @Test
    public void hundredDollarsHasAnAmountOf100() {
        assertEquals(dec100, usd100.getAmount());
    }

    @Test
    public void zeroDollarsHasDollarsAsCurrency() {
        assertEquals("USD", usd0.getCurrency());
    }

    @Test
    public void zeroEuroHasDollarsAsCurrency() {
        Money eur0 = new Money(BigDecimal.ZERO, "EUR");
        assertEquals("EUR", eur0.getCurrency());
    }

    @Test
    public void zeroDollarsIsEqualToZeroDollars() {
        assertEquals(usd0, new Money(BigDecimal.ZERO, "USD"));
    }

    @Test
    public void zeroDollarsIsNotEqualTo100Dollars() {
        assertNotEquals(usd0, new Money(dec100, "USD"));
    }

    @Test
    public void hundredDollarsIsNotEqualToHundredEur() {
        assertNotEquals(new Money(dec100, "USD"), eur100);
    }

    @SuppressWarnings({"EqualsBetweenInconvertibleTypes", "SimplifiableAssertion"})
    @Test
    public void hundredDollarsIsNotEqualToAnyString() {
        assertFalse(usd100.equals( "100 USD"));
    }

    @Test
    public void hundredDollarsPlusHundredDollarsEqualsTwoHundredDollars() {
        assertEquals(new Money(dec200, "USD"), usd100.plus(usd100));
    }

    @Test
    public void hundredDollarsPlusHundredEuroIsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> usd100.plus(eur100));
    }

    @Test
    public void hundredTimesHundredDollarsIs10000Dollars() {
        assertEquals(new Money(BigDecimal.valueOf(10000), "USD"), usd100.times(dec100));
    }

    @Test
    public void halfOfHundredDollarsIsFiftyDollars() {
        assertEquals(new Money(BigDecimal.valueOf(50), "USD"), usd100.divide(BigDecimal.valueOf(2)));
    }

    @Test
    public void divisionByZeroThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> usd100.divide(BigDecimal.ZERO));
    }
}