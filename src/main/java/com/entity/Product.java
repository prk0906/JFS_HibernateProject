package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
//@NamedQuery(name = "allProducts",query = "from Product")
@NamedQueries({@NamedQuery(name="allProducts",query = "from Product"),
			@NamedQuery(query="update Product set name = ?1 Where id =?2",name="updateProduct")})
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	private String name;
	
	private String category;

	public Product(Integer productId, String name, String category) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
	}
	
	public Product(String name, String category) {
		super();
		this.name = name;
		this.category = category;
	}

	public Product() {
		super();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + "]";
	}
	
	
}
