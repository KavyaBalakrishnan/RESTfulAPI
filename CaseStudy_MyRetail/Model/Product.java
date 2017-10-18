package org.kavya.restapi.casestudy.myretailmodel;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Product model
 *
 */

@XmlRootElement

public class Product {

	private long id;
	private String name;
	private String currentPrice;

	public Product(long id, String name, String currentPrice) {

		this.id = id;
		this.name = name;
		this.currentPrice = currentPrice;
	}

	public Product() {

	}

	public Product(long id) {
		this.id = id;
		// this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() throws Exception {
		return currentPrice;
	}

	public void setPrice(String currentPrice) {
		this.currentPrice = currentPrice;

	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name='" + name + '\'' + ", current_price=" + currentPrice + '}';
	}

}
