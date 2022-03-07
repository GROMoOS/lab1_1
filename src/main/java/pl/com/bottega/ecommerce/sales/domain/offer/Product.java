package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private String id;

    private Money money;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType) {
        this.id = productId;
        this.money = new Money(productPrice);
        this.name = productName;
        this.snapshotDate = productSnapshotDate;
        this.type = productType;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return money.getAmount();
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
