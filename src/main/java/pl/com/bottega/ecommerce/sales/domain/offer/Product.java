package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {// product

    private final String productId;
    private final Money money;

    private final String productName;

    private final Date productSnapshotDate;
    private final String productType;
    public Product(String productId, BigDecimal productPrice, String currency, String productName, Date productSnapshotDate, String productType) {
        this.productId = productId;
        this.money = new Money(productPrice, currency);
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public Money getMoney() {
        return money;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }
}