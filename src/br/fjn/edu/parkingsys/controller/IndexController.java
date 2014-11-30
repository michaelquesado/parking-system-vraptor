package br.fjn.edu.parkingsys.controller;


import java.util.Calendar;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.ServiceDAO;
import br.fjn.edu.parkingsys.dao.log.LogDAO;
import br.fjn.edu.parkingsys.model.Operations;
import br.fjn.edu.parkingsys.model.log.Log;

@Controller
public class IndexController {
	
	@Inject
	private UserSession userSession;
	
	@Inject
	private ServiceDAO daoService;
	@Inject
	private Result result;
	@Inject
	private Log log;
	@Inject
	private LogDAO logDAO;
	
	
	@Get("/")
	public void index() {
		
		this.registerLog(Operations.READY);
		result.include("user", userSession.getUser());
		result.include("services", daoService.ListServices());
		result.of(ServiceController.class).list();
	}
	
	private void registerLog(Operations operations){
		
		log.setUser_id(userSession.getUser().getId());
		log.setModel("Index");
		log.setOperation(operations);
		log.setCreated(Calendar.getInstance());
		
		logDAO.register(log);
	}
}
