package br.fjn.edu.parkingsys.dao;

import java.util.List;

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

	public User load(Integer id) {
		return (User) Connection.getSession().load(User.class, id);

	}

	public boolean UserExists(User user) {
		User find = (User) Connection.getSession().createCriteria(User.class)
				.add(Restrictions.eq("userName", user.getUserName()))
				.uniqueResult();
		return find != null;
	}

	public boolean AuthenticationUser(User user) {

		Session session = Connection.getSession();
		Criteria criteria = session.createCriteria(User.class);
		Criterion c1 = Restrictions.eq("userName", user.getUserName());
		Criterion c2 = Restrictions.eq("password", user.getPassword());
		criteria.add(Restrictions.and(c1, c2));
		return criteria.uniqueResult() != null;

	}

	public User getUser(User user) {

		return (User) Connection.getSession().createCriteria(User.class)
				.add(Restrictions.eq("userName", user.getUserName()))
				.add(Restrictions.eq("password", user.getPassword()))
				.uniqueResult();
	}

	public static List<User> listAllUsers() {

		Criteria criteria = Connection.getSession().createCriteria(User.class);

		return criteria.list();
	}

}
