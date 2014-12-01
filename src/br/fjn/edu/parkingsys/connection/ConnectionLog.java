package br.fjn.edu.parkingsys.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class ConnectionLog {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("log");

	private ConnectionLog() {

	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static Session getSession() {

		EntityManager manager = getEntityManager();
		return (Session) manager.getDelegate();
	}

	public static void close() {
		emf.close();
	}
}
