package com.entity;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	@Column(unique = true)
	private Long mobileNumber;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Order> order;


	public User(String name, Long mobileNumber, List<Order> order) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.order = order;
	}

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", mobileNumber=" + mobileNumber + "]";
	}
}
