package br.fjn.edu.parkingsys.controller;


import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.fjn.edu.parkingsys.components.UserSession;

@Controller
public class IndexController {
	
	@Inject
	UserSession userSession;
	
	@Inject
	Result result;
	
	
	@Get("/")
	public void index() {
		
		result.include("user", userSession.getUser());
		
	}
}
