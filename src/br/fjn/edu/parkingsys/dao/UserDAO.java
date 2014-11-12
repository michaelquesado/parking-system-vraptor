package br.fjn.edu.parkingsys.dao;

import javax.persistence.EntityManager;

import org.hibernate.criterion.Restrictions;

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

	public boolean UserExists(User user) {
		User find = (User) Connection.getSession().createCriteria(User.class)
				.add(Restrictions.eq("userName", user.getUserName()))
				.uniqueResult();
		return find != null;
	}

	public User loadUser(User user) {
		return (User) Connection.getSession().createCriteria(User.class)
				.add(Restrictions.eq("userName", user.getUserName()))
				.add(Restrictions.eq("password", user.getPassword()))
				.uniqueResult();
	}

}
