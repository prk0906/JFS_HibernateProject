package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Course;
import com.entity.Student;
import com.util.HibernateUtil;

public class ManyToMany {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Student s1 = new Student("Teja",7589658458L);
		Student s2 = new Student("Vijju",7589657485L);
		Student s3 = new Student("Abhi",7589654588L);
		
		Course course1 = new Course("JFS",20000.0);
		Course course2 = new Course("Deveops",14000.0);
		Course course3 = new Course("Python",19000.0);
		Course course4 = new Course("DSA",350000.0);
		
		List<Student> std1 = new ArrayList<Student>();
		std1.add(s1);
		std1.add(s2);
		
		List<Student> std2 = new ArrayList<Student>();
		std2.add(s3);
		
		List<Course> c1 = new ArrayList<Course>();
		c1.add(course1);
		c1.add(course2);
		
		List<Course> c2 = new ArrayList<Course>();
		c2.add(course3);
		c2.add(course4);
		
		s1.setCourse(c1);
		s2.setCourse(c2);
		s3.setCourse(c2);
		
//		extracted(session, s1, s2, s3);
		
//		extracted(session);
		Course course5 = session.find(Course.class, 1);
		System.out.println(course5.getStudents());
	}

	private static void extracted(Session session) {
		session.beginTransaction();
		Student student = session.find(Student.class, 2);
		Course course = session.find(Course.class, 1);
		student.getCourse().add(course);
		course.getStudents().add(student);
		session.getTransaction().commit();
	}

	private static void extracted(Session session, Student s1, Student s2, Student s3) {
		session.beginTransaction();
		session.persist(s1);
		session.persist(s2);
		session.persist(s3);
		session.getTransaction().commit();
	}
}
