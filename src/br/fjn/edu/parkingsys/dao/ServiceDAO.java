package br.fjn.edu.parkingsys.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
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
		Session session = Connection.getSession();
		Criteria criteria = session.createCriteria(Service.class);
		
		Date data = new Date();  
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		
		Criterion c1 = Restrictions.eq("created", formatador.format(data) );
		criteria.add(c1);

		criteria.addOrder(Order.desc("id"));
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

	public void update(Service checkOut) {

		EntityManager manager = Connection.getEntityManager();
		manager.getTransaction().begin();

		manager.merge(checkOut);

		manager.getTransaction().commit();
		manager.clear();
		manager.close();

	}
	
}

