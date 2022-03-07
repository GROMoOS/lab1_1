package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {// product
    private final String id;
    private final Money price;
    private final String name;
    private final Date snapshotDate;
    private final String type;

    public Product(String id, Money price, String name, Date snapshotDate,
                   String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }
}