package br.fjn.edu.parkingsys.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.fjn.edu.parkingsys.connection.Connection;
import br.fjn.edu.parkingsys.model.Service;

public class ServiceDAO {

	public void insert(Service service) {
		EntityManager manager = Connection.getEntityManager();
		manager.getTransaction().begin();

		manager.merge(service);

		manager.getTransaction().commit();
		manager.clear();
		manager.close();

	}

	public List<Service> ListServices() {
		Criteria criteria = Connection.getSession().createCriteria(
				Service.class);
		return criteria.list();
	}

	public boolean serviceExist(int id) {
		Session session = Connection.getSession();

		Criteria criteria = session.createCriteria(Service.class);

		return criteria.add(Restrictions.eq("id", id)).uniqueResult() != null;

	}

	public Service getService(int id) {
		
		return (Service) Connection.getEntityManager().find(Service.class, id);
		
	}

}
