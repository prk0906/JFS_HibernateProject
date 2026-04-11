package com.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Car;
import com.entity.CarId;
import com.util.HibernateUtil;

public class Application {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		CarId carId = new CarId("123","456");
//		Car car = new Car(carId, "Altroz", "Tata", 150000);
//		session.persist(car);
//		session.getTransaction().commit();
		Car car2 = session.find(Car.class, carId);
		System.out.println(car2);
	}
}
