package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
    private BigDecimal totalCost;
    private String currency;

    public Money(BigDecimal totalCost, String currency) {
        this.totalCost = totalCost;
        this.currency = currency;
    }
    public Money() {
    }
    public BigDecimal getTotalCost() {return totalCost;}
    public void setTotalCost(BigDecimal totalCost) {this.totalCost = totalCost;}

    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Money other = (Money) obj;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        if (totalCost == null) {
            if (other.totalCost != null)
                return false;
        } else if (!totalCost.equals(other.totalCost))
            return false;
        return true;
    }

}