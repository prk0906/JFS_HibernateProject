package com.namedquery;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.entity.Product;
import com.util.HibernateUtil;

public class NamedQueries {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		updateQuery(session);
		selectQuery(session);
	}

	private static void updateQuery(Session session) {
		session.beginTransaction();
		MutationQuery query = session.createNamedMutationQuery("updateProduct");
		query.setParameter(1, "Television");
		query.setParameter(2, 1);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	private static void selectQuery(Session session) {
		Query<Product> query = session.createNamedQuery("allProducts",Product.class);
		List<Product> list = query.list();
		System.out.println(list);
	}
}
