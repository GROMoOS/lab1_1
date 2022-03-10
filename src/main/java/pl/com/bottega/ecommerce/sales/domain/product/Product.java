package pl.com.bottega.ecommerce.sales.domain.product;

import pl.com.bottega.ecommerce.sales.domain.money.Money;
import pl.com.bottega.ecommerce.sales.domain.offer.OfferItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Product other = (Product) obj;

        if (getName() == null) {
            if (other.getName() != null) {
                return false;
            }
        } else if (!getName().equals(other.getName())) {
            return false;
        }
        if (getPrice() == null) {
            if (other.getPrice() != null) {
                return false;
            }
        } else if (!getPrice().equals(other.getPrice())) {
            return false;
        }
        if (getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!getId().equals(other.getId())) {
            return false;
        }
        if (!getType().equals(other.getType())) {
            return false;
        }
        return true;
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
