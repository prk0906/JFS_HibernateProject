package com.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class CarId {
	private String modelNum;
	private String engineNum;
	public CarId() {
		super();
	}
	public CarId(String modelNum, String engineNum) {
		super();
		this.modelNum = modelNum;
		this.engineNum = engineNum;
	}
	public String getModelNum() {
		return modelNum;
	}
	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}
	public String getEngineNum() {
		return engineNum;
	}
	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}
	@Override
	public String toString() {
		return "CarId [modelNum=" + modelNum + ", engineNum=" + engineNum + "]";
	}
	
}
