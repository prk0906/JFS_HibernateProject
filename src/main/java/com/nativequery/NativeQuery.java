package com.nativequery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;

import com.entity.Product;
import com.util.HibernateUtil;

public class NativeQuery {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		select(session);
		selectWithWhere(session);
		session.beginTransaction();
		//insert(session);
		//update(session);
		//delete(session);
		session.getTransaction().commit();
	}

	private static void delete(Session session) {
		MutationQuery nativeMutationQuery = session.createNativeMutationQuery("Delete from Products where ProductId = :id");
		nativeMutationQuery.setParameter("id", 6);
		nativeMutationQuery.executeUpdate();
	}

	private static void update(Session session) {
		MutationQuery nativeMutationQuery = session.createNativeMutationQuery("Update products set name = ?1 where productId = ?2");
		nativeMutationQuery.setParameter(1, "ABC");
		nativeMutationQuery.setParameter(2, 6);
		nativeMutationQuery.executeUpdate();
	}

	private static void insert(Session session) {
		MutationQuery nativeMutationQuery = session.createNativeMutationQuery("insert into products(name,category)values(?1,?2)");
		nativeMutationQuery.setParameter(1, "Washing Machine");
		nativeMutationQuery.setParameter(2, "Electronics");
		nativeMutationQuery.executeUpdate();
	}

	private static void selectWithWhere(Session session) {
		org.hibernate.query.NativeQuery<Product> nativeQuery = session.createNativeQuery("Select * from products where productId = ?1",Product.class);
		nativeQuery.setParameter(1, 1);
		List<Product> list = nativeQuery.list();
		System.out.println(list);
	}

	private static void select(Session session) {
		org.hibernate.query.NativeQuery<Product> nativeQuery = session.createNativeQuery("Select * from Products ",Product.class);
		List<Product> list = nativeQuery.list();
		System.out.println(list);
	}
}
