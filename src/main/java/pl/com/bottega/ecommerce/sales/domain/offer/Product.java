package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {
    private final String id;
    private final String name;
    private final BigDecimal price;
    private final Date snapshotDate;
    private final String type;


    public Product(String id, String name, BigDecimal price, Date snapshotDate, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(snapshotDate, product.snapshotDate) && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, snapshotDate, type);
    }
}
