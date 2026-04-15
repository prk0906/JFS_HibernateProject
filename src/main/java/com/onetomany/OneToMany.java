package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Order;
import com.entity.User;
import com.util.HibernateUtil;

public class OneToMany {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		User user = session.find(User.class, 2);
		System.out.println(user);
		System.out.println(user.getOrder());
	}

	private static void insert(Session session) {
		Order order1 = new Order(20000, 10);
		Order order2 = new Order(10000, 5);
		Order order3 = new Order(75000, 8);
		
		List<Order> orders1 = new ArrayList<Order>();
		orders1.add(order1);
		orders1.add(order2);
		
		List<Order> orders2 = new ArrayList<Order>();
		orders2.add(order3);
		
		User user1 = new User("Ajay", 8574589658L, orders1);
		order1.setUser(user1);
		order2.setUser(user1);
		User user2 = new User("Salma", 8574589675L, orders2);
		order3.setUser(user2);
		
		session.beginTransaction();
		session.persist(user1);
		
		session.persist(user2);
		session.getTransaction().commit();
	}

}
