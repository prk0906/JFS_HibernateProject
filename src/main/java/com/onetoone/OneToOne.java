package com.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Aadhar;
import com.entity.Citizen;
import com.util.HibernateUtil;

public class OneToOne {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Citizen citizen = session.find(Citizen.class, 1);
		System.out.println(citizen);
		System.out.println(citizen.getAadhar());
	}

	private static void extracted(Session session) {
		Aadhar aadhar = session.find(Aadhar.class, 458745);
		System.out.println(aadhar);
		System.out.println(aadhar.getCitizen());
	}

	private static void delete(Session session) {
		session.beginTransaction();
		session.remove(new Citizen(2, null, null, null));
		session.getTransaction().commit();
		insertQuery(session);
		select(session);
	}

	private static void select(Session session) {
		Citizen citizen = session.find(Citizen.class, 1);
		System.out.println(citizen);
		System.out.println(citizen.getAadhar());
	}

	private static void insertQuery(Session session) {
		Citizen citizen = new Citizen("Praveen", 25, new Aadhar(7485,"ChandraMohan"));
		session.beginTransaction();
		session.persist(citizen);
		session.getTransaction().commit();
	}
}
