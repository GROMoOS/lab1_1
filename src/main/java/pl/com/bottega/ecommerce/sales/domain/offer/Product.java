package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {

	private String id;
	private String type;
	private String name;
	private Date snapshotDate;

	public Product(String id, String type, String name, Date snapshotDate) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.snapshotDate = snapshotDate;
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
}
