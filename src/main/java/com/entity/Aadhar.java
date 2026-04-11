package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Aadhar {
	@Id
	private Integer aadharNumber;
	private String fatherName;
	
	@OneToOne(mappedBy = "aadhar")
	private Citizen citizen;
	public Aadhar(Integer aadharNumber, String fatherName) {
		super();
		this.aadharNumber = aadharNumber;
		this.fatherName = fatherName;
	}
	public Aadhar() {
		super();
	}
	public Integer getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(Integer aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	@Override
	public String toString() {
		return "Aadhar [aadharNumber=" + aadharNumber + ", fatherName=" + fatherName + "]";
	}
	
	
}
