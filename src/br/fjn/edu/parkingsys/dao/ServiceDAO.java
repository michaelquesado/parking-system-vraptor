package br.fjn.edu.parkingsys.dao;

import javax.persistence.EntityManager;

import br.fjn.edu.parkingsys.connection.Connection;
import br.fjn.edu.parkingsys.model.Service;

public class ServiceDAO {

	public void save(Service service) {
		EntityManager manager = Connection.getEntityManager();
		manager.getTransaction().begin();

		manager.persist(service);

		manager.getTransaction().commit();
		manager.clear();
		manager.close();

	}

}
