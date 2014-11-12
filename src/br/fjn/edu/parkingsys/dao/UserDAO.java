package br.fjn.edu.parkingsys.dao;

import javax.persistence.EntityManager;

import br.fjn.edu.parkingsys.connection.Connection;
import br.fjn.edu.parkingsys.model.User;

public class UserDAO {

	public void insert(User user) {

		EntityManager manager = Connection.getEntityManager();

		manager.getTransaction().begin();

		try {
			manager.persist(user);
			manager.getTransaction().commit();
		} catch (NullPointerException nullPointerException) {
			manager.getTransaction().rollback();
		} catch (Exception exception) {
			manager.getTransaction().rollback();
		} finally {
			manager.clear();
			manager.close();
		}
	}

	public void update(User user) {

		EntityManager manager = Connection.getEntityManager();

		manager.getTransaction().begin();
		try {
			manager.merge(user);
			manager.getTransaction().commit();
		} catch (NullPointerException nullPointerException) {
			manager.getTransaction().rollback();
		} catch (Exception exception) {
			manager.getTransaction().rollback();
		} finally {
			manager.clear();
			manager.close();
		}
	}

	public void delete(User user) {

		EntityManager manager = Connection.getEntityManager();

		manager.getTransaction().begin();
		try {
			manager.remove(user);
			manager.getTransaction().commit();
		} catch (NullPointerException nullPointerException) {
			manager.getTransaction().rollback();
		} catch (Exception exception) {
			manager.getTransaction().rollback();
		} finally {
			manager.clear();
			manager.close();
		}

	}

}
