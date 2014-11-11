package br.fjn.edu.parkingsys.dao;

import javax.persistence.EntityManager;

import br.fjn.edu.parkingsys.connection.Connection;
import br.fjn.edu.parkingsys.model.Customer;

public class CustomerDAO {

	public void save(Customer customer) {
		EntityManager manager = Connection.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(customer);
		manager.getTransaction().commit();
		manager.clear();
		manager.close();
	}

	public void update(Customer customer) {
		EntityManager manager = Connection.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(customer);
		manager.getTransaction().commit();
		manager.clear();
		manager.close();

	}

}
