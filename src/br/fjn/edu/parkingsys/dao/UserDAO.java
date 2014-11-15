package br.fjn.edu.parkingsys.dao;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
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

	public boolean verificaLogin(User user) {

		Session session = Connection.getSession();
		Criteria criteria = session.createCriteria(User.class);
		Criterion c1 = Restrictions.eq("userName", user.getUserName());
		Criterion c2 = Restrictions.eq("password", user.getPassword());
		criteria.add(Restrictions.and(c1, c2));

		return criteria.uniqueResult() != null;
	}

	public User getUser(User user) {

		Session session = Connection.getSession();
		Criteria criteria = session.createCriteria(User.class);
		Criterion c1 = Restrictions.eq("userName", user.getUserName());
		Criterion c2 = Restrictions.eq("password", user.getPassword());
		criteria.add(Restrictions.and(c1, c2));

		return (User) criteria.uniqueResult();
	}

}
