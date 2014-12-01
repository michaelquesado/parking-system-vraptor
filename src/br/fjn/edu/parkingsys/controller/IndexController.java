package br.fjn.edu.parkingsys.controller;


import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.fjn.edu.parkingsys.components.RegisterLog;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.ServiceDAO;
import br.fjn.edu.parkingsys.model.Operations;

@Controller
public class IndexController {
	
	@Inject
	private UserSession userSession;
	@Inject
	private ServiceDAO daoService;
	@Inject
	private Result result;
	@Inject
	private RegisterLog log;
	private static final String MODEL = "Index";
	
	@Get("/")
	public void index() {
		
		log.registrationLog(Operations.READ, MODEL);
		result.include("user", userSession.getUser());
		result.include("services", daoService.ListServices());
		result.of(ServiceController.class).list();
	}
	
}
