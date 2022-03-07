package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {

    private BigDecimal amount;

    private String currency;

    public Money(BigDecimal amount) {
        this.amount = amount;
        this.currency = "PLN";
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
