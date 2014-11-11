package br.fjn.edu.parkingsys.dao;

import javax.persistence.EntityManager;

import br.fjn.edu.parkingsys.connection.Connection;
import br.fjn.edu.parkingsys.model.Operation;

public class OperationDAO {

	public void save(Operation operation) {
		EntityManager manager = Connection.getEntityManager();
		manager.getTransaction().begin();

		manager.persist(operation);

		manager.getTransaction().commit();
		manager.clear();
		manager.close();

	}

}
