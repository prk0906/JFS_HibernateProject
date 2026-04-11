package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name="count_of_items")
	private Integer countOfItems;
	@Column(name="price")
	private Integer price;
	public Order(Integer orderId, Integer countOfItems, Integer price) {
		super();
		this.orderId = orderId;
		this.countOfItems = countOfItems;
		this.price = price;
	}
	public Order() {
		super();
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getCountOfItems() {
		return countOfItems;
	}
	public void setCountOfItems(Integer countOfItems) {
		this.countOfItems = countOfItems;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", countOfItems=" + countOfItems + ", price=" + price + "]";
	}
	
	
	
}
