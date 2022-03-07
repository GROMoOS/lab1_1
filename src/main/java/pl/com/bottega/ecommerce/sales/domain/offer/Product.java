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
}
