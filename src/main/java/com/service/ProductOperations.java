package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Product;
import com.util.HibernateUtil;

public class ProductOperations {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//save
		//save(session);
		session.beginTransaction();
		//Transient state
		Product product2 = new Product();
		product2.setProductId(3);
		product2.setName("Sony Tv");
		product2.setCategory("Electronics");
		
		//Persistent State
		Product product = session.find(Product.class, 2);
		
//		session.merge(product);
		product.setName("Iphone");
		session.getTransaction().commit();
		session.close();
		
		//Detached state
		product.setCategory("IOS");
	}

	private static void save(Session session) {
		session.beginTransaction();
		Product product = new Product("Sofa", "Funrtinure");
		session.persist(product);
		session.getTransaction().commit();
	}

}
