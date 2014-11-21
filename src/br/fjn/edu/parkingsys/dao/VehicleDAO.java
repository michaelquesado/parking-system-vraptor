package br.fjn.edu.parkingsys.dao;

import javax.persistence.EntityManager;

import org.hibernate.criterion.Restrictions;

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

	public boolean vehicleExists(String licensePlate) {
		Vehicle vehiclefind = (Vehicle) Connection.getSession()
				.createCriteria(Vehicle.class)
				.add(Restrictions.eq("licensePlate", licensePlate))
				.uniqueResult();
		return vehiclefind != null;
	}

	public Vehicle getVehicle(String licensePlate) {

		return (Vehicle) Connection.getSession().createCriteria(Vehicle.class)
				.add(Restrictions.eq("licensePlate", licensePlate))
				.uniqueResult();

	}
}
