package br.fjn.edu.parkingsys.components;

import java.util.Calendar;

import javax.inject.Inject;

import br.fjn.edu.parkingsys.dao.log.LogDAO;
import br.fjn.edu.parkingsys.model.Operations;
import br.fjn.edu.parkingsys.model.log.Log;

public class RegisterLog {

	
	private Log log;
	private LogDAO logDAO;
	private UserSession userSession;
	
	@Inject
	public RegisterLog(Log log, LogDAO logDAO, UserSession userSession) {
		this.log = log;
		this.logDAO = logDAO;
		this.userSession = userSession;
	}

	public void registrationLog(Operations operations, String model) {

		log.setUser_id(userSession.getUser().getId());
		log.setModel(model);
		log.setOperation(operations);
		log.setCreated(Calendar.getInstance());

		logDAO.register(log);
	}
}
