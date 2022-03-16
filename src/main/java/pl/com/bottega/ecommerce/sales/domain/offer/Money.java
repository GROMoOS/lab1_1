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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Money m = (Money) obj;
        if (!m.amount.equals(this.amount))
            return false;
        if (!m.currency.equals(this.currency))
            return false;
        return true;
    }
}
