package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@Column(nullable = false)
	private double price;
	private Integer numberOfIteams;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Order(double price, Integer numberOfIteams, User user) {
		super();
		this.price = price;
		this.numberOfIteams = numberOfIteams;
		this.user = user;
	}
	

	public Order(double price, Integer numberOfIteams) {
		super();
		this.price = price;
		this.numberOfIteams = numberOfIteams;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getNumberOfIteams() {
		return numberOfIteams;
	}

	public void setNumberOfIteams(Integer numberOfIteams) {
		this.numberOfIteams = numberOfIteams;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", price=" + price + ", numberOfIteams=" + numberOfIteams  + "]";
	}
	
	
}
