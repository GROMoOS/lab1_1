package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {

	private String id;
	private String name;
	private String type;
	private Date snapshotDate;
	private Money money;

	public Product(String id, String name, String type, Date snapshotDate, Money money) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.snapshotDate = snapshotDate;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSnapshotDate() {
		return snapshotDate;
	}

	public void setSnapshotDate(Date snapshotDate) {
		this.snapshotDate = snapshotDate;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (type == null ? 0 : type.hashCode());
		result = prime * result + (snapshotDate == null ? 0 : snapshotDate.hashCode());
		result = prime * result + (money == null ? 0 : money.hashCode());
		return result;
	}

	@Override
	public  boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Product other = (Product) obj;


		if ( id == null) {
			if (other.id == null)
				return false;
		} else if(!id.equals(other.id))
			return false;

		if ( name == null) {
			if (other.name  == null)
				return false;
		} else if(!name.equals(other.name))
			return false;

		if ( type == null) {
			if (other.type == null)
				return false;
		} else if(!type.equals(other.type))
			return false;

		if ( snapshotDate == null) {
			if (other.snapshotDate == null)
				return false;
		} else if(!snapshotDate.equals(other.snapshotDate))
			return false;

		if ( money == null) {
			if (other.money == null)
				return false;
		} else if(!money.equals(other.money))
			return false;

		return true;
	}

	public boolean sameAs(Product other) {
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.sameAs(other.money))
			return false;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;

		return true;
	}
}
