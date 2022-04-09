package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {

    public static final String DEFAULT_CURRENCY = "EUR";
    private BigDecimal amount;
    private String currency;

    public Money(BigDecimal amount) {
        this(amount, DEFAULT_CURRENCY);
    }

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money(double amount) {
        this(new BigDecimal(amount), DEFAULT_CURRENCY);
    }

    public Money(double amount, String currency) {
        this(new BigDecimal(amount), currency);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

}
