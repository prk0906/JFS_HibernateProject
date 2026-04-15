package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String name;
	private Long mobileNumber;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_courses",joinColumns = {@JoinColumn(name="studentId")}
				,inverseJoinColumns = {@JoinColumn(name="courseId")})
	private List<Course> courses;

	public Student() {
		super();
	}

	public Student(Integer studentId, String name, Long mobileNumber, List<Course> course) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.courses = course;
	}

	public Student(String name, Long mobileNumber, List<Course> course) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.courses = course;
	}
	

	public Student(String name, Long mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public List<Course> getCourse() {
		return courses;
	}

	public void setCourse(List<Course> course) {
		this.courses = course;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
