package br.fjn.edu.parkingsys.dao;

import javax.persistence.EntityManager;

import br.fjn.edu.parkingsys.connection.Connection;
import br.fjn.edu.parkingsys.model.User;

public class UserDAO {

	public void save(User user) {
		EntityManager manager = Connection.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		manager.clear();
		manager.close();

	}

}
