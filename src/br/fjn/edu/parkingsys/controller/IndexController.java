package br.fjn.edu.parkingsys.controller;


import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.ServiceDAO;

@Controller
public class IndexController {
	
	@Inject
	private UserSession userSession;
	
	@Inject
	private ServiceDAO daoService;
	@Inject
	Result result;
	
	
	@Get("/")
	public void index() {
		
		
		result.include("user", userSession.getUser());
		result.include("services", daoService.ListServices());
		result.of(ServiceController.class).list();
	}
}
