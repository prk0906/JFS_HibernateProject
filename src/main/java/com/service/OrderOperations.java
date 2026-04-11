package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Order;
import com.util.HibernateUtil;

public class OrderOperations {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		Order order = new Order(4, 12, 21000);
		
		session.persist(order);
		session.getTransaction().commit();
		session.close();
	}

}
