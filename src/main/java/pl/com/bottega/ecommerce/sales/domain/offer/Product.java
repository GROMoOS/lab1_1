package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;
import java.util.Objects;

public class Product {
    private String id;

    private String type;

    private String name;

    private Date snapshotDate;

    private Money price;

    public Product(String id, String type, String name, Date snapshotDate, Money price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id)
                && Objects.equals(type, product.type)
                && Objects.equals(name, product.name)
                && Objects.equals(snapshotDate, product.snapshotDate)
                && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, snapshotDate, price);
    }

    /**
     *
     * @param otherProduct
     * @param delta
     *            acceptable percentage difference
     * @return
     */
    public boolean sameAs(Product otherProduct, double delta) {
        if (name == null) {
            if (otherProduct.getName() != null) {
                return false;
            }
        } else if (!name.equals(otherProduct.getName())) {
            return false;
        }
        if (price == null) {
            if (otherProduct.getPrice() != null) {
                return false;
            }
        } else if (!price.equals(otherProduct.getPrice())) {
            return false;
        }
        if (id == null) {
            if (otherProduct.getId() != null) {
                return false;
            }
        } else if (!id.equals(otherProduct.getId())) {
            return false;
        }
        if (!Objects.equals(type, otherProduct.getType())) {
            return false;
        }

        return true;
    }
}
