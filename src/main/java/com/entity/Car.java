package com.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Car {
	@EmbeddedId
	private CarId carId;
	private String model;
	private String company;
	private int price;
	public Car(String model, String company, int price) {
		super();
		this.model = model;
		this.company = company;
		this.price = price;
	}
	
	public Car(CarId carId, String model, String company, int price) {
		super();
		this.carId = carId;
		this.model = model;
		this.company = company;
		this.price = price;
	}

	public Car() {
		super();
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", model=" + model + ", company=" + company + ", price=" + price + "]";
	}
	
}
