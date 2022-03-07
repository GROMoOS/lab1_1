package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Money  {
    protected BigDecimal productPrice;
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

    public String getTotalCostCurrency() {
        return currency;
    }
}
