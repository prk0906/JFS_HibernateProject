package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;

import com.entity.Product;
import com.util.HibernateUtil;

public class HQLOperations {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		selectQuery(session);
		selectQueryWithWhere(session);
		
		session.beginTransaction();
		//insertQuery(openSession);
		//updateQuery(openSession);
		//deleteQuery(session);
		session.getTransaction().commit();
	}

	private static void deleteQuery(Session session) {
		MutationQuery query = session.createMutationQuery("Delete Product where id = ?1");
		query.setParameter(1, 5);
		query.executeUpdate();
	}

	private static void updateQuery(Session openSession) {
		//		MutationQuery mutationQuery = openSession.createMutationQuery("Update Product set name = :name where id = :id");
		//		mutationQuery.setParameter("name", "ABC");
		//		mutationQuery.setParameter("id", 4);
		//		mutationQuery.executeUpdate();
				MutationQuery mutationQuery = openSession.createMutationQuery("Update Product set name = ?1 where id = ?2");
				mutationQuery.setParameter(1, "AC");
				mutationQuery.setParameter(2, 4);
				mutationQuery.executeUpdate();
	}

	private static void insertQuery(Session openSession) {
		MutationQuery mutationQuery = openSession.createMutationQuery("insert into Product(name,category)values(:name,:category)");
		mutationQuery.setParameter("name", "AC");
		mutationQuery.setParameter("category", "Electronics");
		mutationQuery.executeUpdate();
//		MutationQuery mutationQuery = openSession.createMutationQuery("insert into Product(name,category)values(?1,?2)");
//		mutationQuery.setParameter(1, "Washing Machine");
//		mutationQuery.setParameter(2, "Electronics");
//		mutationQuery.executeUpdate();
	}

	private static void selectQueryWithWhere(Session openSession) {
		SelectionQuery<Product> selectionQuery = openSession.createSelectionQuery("from Product where id = ?1 and name = ?2",Product.class);
		selectionQuery.setParameter(1, 3);
		selectionQuery.setParameter(2, "Sofa");
//		SelectionQuery<Product> selectionQuery = openSession.createSelectionQuery("from Product where id = :id and name = :name",Product.class);
//		selectionQuery.setParameter("id", 3);
//		selectionQuery.setParameter("name", "Sofa");
		List<Product> list = selectionQuery.list();
		System.out.println(list);
	}

	private static void selectQuery(Session openSession) {
		SelectionQuery<Product> query = openSession.createSelectionQuery(" from Product",Product.class);
		List<Product> products = query.list();
		System.out.println(products);
	}

}
