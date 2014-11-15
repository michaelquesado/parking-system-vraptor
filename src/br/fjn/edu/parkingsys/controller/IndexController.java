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
	
	@Public
	@Get("/")
	public void index() {
		System.out.println("Home Active!");
		User user = userSession.getUser();
		result.include(user);
	}
}
