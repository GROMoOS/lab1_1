package pl.com.bottega.ecommerce.sales.domain.product;

import pl.com.bottega.ecommerce.sales.domain.money.Money;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private String id, name, type;
    private Date snapshotDate;
    private Money price;

    public Product(String id, String name, String type, Date snapshotDate, Money price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.snapshotDate = snapshotDate;
        this.price = price;
    }

    public Product(String id, String name, String type, Date snapshotDate, BigDecimal moneyAmount) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.snapshotDate = snapshotDate;
        this.price = new Money(moneyAmount);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public Money getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public void setType(String type) {
        this.type = type;
    }
}
