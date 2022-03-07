package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Money  {
    private BigDecimal productPrice;
    private String currency;

    public Money(BigDecimal productPrice) {
        this.productPrice = productPrice;
        this.currency="PLN";
    }

    public Money(BigDecimal productPrice, String currency) {
        this.productPrice = productPrice;
        this.currency = currency;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
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
        Money other = (Money) obj;
        if (productPrice == null) {
            if (other.productPrice != null) {
                return false;
            }
        } else if (!productPrice.equals(other.productPrice)) {
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

}
