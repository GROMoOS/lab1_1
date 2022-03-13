package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal amount;
    private String currency;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj){

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Money other = (Money) obj;

        if (amount == null) {
            if (other.amount != null) {
                return false;
            }
        } else if (!amount.equals(other.amount)) {
            return false;
        }

        if (currency == null) {
            if (other.currency != null) {
                return false;
            }
        } else if (!currency.equals(other.currency)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(amount,currency);
    }
}
