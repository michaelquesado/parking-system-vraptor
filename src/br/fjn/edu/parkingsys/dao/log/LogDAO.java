package br.fjn.edu.parkingsys.dao.log;

import javax.persistence.EntityManager;

import br.fjn.edu.parkingsys.connection.Connection;
import br.fjn.edu.parkingsys.model.log.Log;

public class LogDAO {
	
	
	public void register(Log log){
		
		EntityManager manager = Connection.getEntityManager();

		manager.getTransaction().begin();

		try {
			manager.persist(log);
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
}
