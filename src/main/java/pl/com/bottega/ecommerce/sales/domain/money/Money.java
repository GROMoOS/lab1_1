package pl.com.bottega.ecommerce.sales.domain.money;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount;
    private String currency;

    //defaulting amount to 0 and currency to USD
    public Money() {
        amount = new BigDecimal(0);
        currency = "USD";
    }

    //defaulting currency to USD
    public Money(BigDecimal amount) {
        this.amount = amount;
        currency = "USD";
    }

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

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
