package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	private String courseName;
	private Double price;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public Course() {
		super();
	}

	public Course(Integer courseId, String courseName, Double price, List<Student> students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.price = price;
		this.students = students;
	}

	public Course(String courseName, Double price, List<Student> students) {
		super();
		this.courseName = courseName;
		this.price = price;
		this.students = students;
	}
	

	public Course(String courseName, Double price) {
		super();
		this.courseName = courseName;
		this.price = price;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", price=" + price + "]";
	}
	
}
