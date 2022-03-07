package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {// product
    private String productId;
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    private Money productPrice;
    public Money getProductPrice() {return productPrice;}
    public void setProductPrice(Money price) {this.productPrice = price;}

    private String productName;
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    private Date productSnapshotDate;
    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }
    public void setProductSnapshotDate(Date productSnapshotDate) {
        this.productSnapshotDate = productSnapshotDate;
    }

    private String productType;
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Product() {
    }
}