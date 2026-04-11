package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Aadhar;
import com.entity.Car;
import com.entity.Citizen;
import com.entity.Order;
import com.entity.Product;


public class HibernateUtil {
	public static SessionFactory sessionFactory = null;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(Car.class);
			cfg.addAnnotatedClass(Order.class);
			cfg.addAnnotatedClass(Product.class);
			cfg.addAnnotatedClass(Aadhar.class);
			cfg.addAnnotatedClass(Citizen.class);
			sessionFactory = cfg.buildSessionFactory();
			return sessionFactory;
		}else {
			return sessionFactory;
		}
	}
}
