package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="citizens")
public class Citizen {
	@Id
	@Column(name="citizen_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	@Column()
	private String name;
	private Integer age;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="aadhar_id")
	private Aadhar aadhar;

	public Citizen() {
		super();
	}

	public Citizen(String name, Integer age, Aadhar aadhar) {
		super();
		this.name = name;
		this.age = age;
		this.aadhar = aadhar;
	}

	public Citizen(Integer citizenId, String name, Integer age, Aadhar aadhar) {
		super();
		this.citizenId = citizenId;
		this.name = name;
		this.age = age;
		this.aadhar = aadhar;
	}

	public Integer getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}

	@Override
	public String toString() {
		return "Citizen [citizenId=" + citizenId + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
