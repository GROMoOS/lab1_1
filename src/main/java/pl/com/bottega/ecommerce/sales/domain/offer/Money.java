package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
    private BigDecimal totalCost;
    public BigDecimal getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    private String currency;
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {this.currency = currency;}
    
    public Money() {
    }
}