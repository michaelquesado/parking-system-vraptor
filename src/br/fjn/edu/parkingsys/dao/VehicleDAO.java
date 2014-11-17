package br.fjn.edu.parkingsys.dao;

import javax.persistence.EntityManager;

import br.fjn.edu.parkingsys.connection.Connection;
import br.fjn.edu.parkingsys.model.Vehicle;

public class VehicleDAO {
	public void insert(Vehicle vehicle) {
		EntityManager manager = Connection.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(vehicle);
		manager.getTransaction().commit();
		manager.clear();
		manager.close();
	}
}
