package br.fjn.edu.parkingsys.controller;


import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.fjn.edu.parkingsys.anotations.Public;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.model.User;

@Controller
public class IndexController {
	
	@Inject
	UserSession userSession;
	
	@Inject
	Result result;
	
	
	@Get("/")
	public void index() {
		User user = userSession.getUser();
		result.include("user", userSession.getUser().getName());
	}
}
