package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Money money = (Money) o;
        if (amount == null) {
            if (money.amount != null) {
                return false;
            }
        } else if (!amount.equals(money.amount)) {
            return false;
        }
        if (currency == null) {
            if (money.amount != null) {
                return false;
            }
        } else if (!currency.equals(money.currency)) {
            return false;
        }
        return true;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (amount == null ? 0 : amount.hashCode());
        result = prime * result + (currency == null ? 0 : currency.hashCode());
        return result;
    }
}
