package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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


    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;

        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }

        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        if (snapshotDate == null) {
            if (other.snapshotDate != null) {
                return false;
            }
        } else if (!snapshotDate.equals(other.snapshotDate)) {
            return false;
        }

        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }

        if(!money.equals(other.money)){
            return false;
        }
        return true;
    }

    @Override
    public  int hashCode(){
        return Objects.hash(id, name, money, snapshotDate, type);
    }

}

