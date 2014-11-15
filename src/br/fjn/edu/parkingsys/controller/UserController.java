package br.fjn.edu.parkingsys.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.fjn.edu.parkingsys.anotations.Public;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.UserDAO;
import br.fjn.edu.parkingsys.model.User;

@Controller
public class UserController {

	@Inject
	private UserSession userSession;

	@Inject
	private Result result;
	
	@Inject
	private  UserDAO userDAO;
	
	@Public
	@Get("loginForm")
	public void loginForm() {

	}

	@Post("loginUser")
	@Public
	public void loginUser(User user) {

		if (userDAO.verificaLogin(user)) {
			
			userSession.setUser(userDAO.getUser(user));
			result.redirectTo(IndexController.class).index();
			
		} else {
			
			result.redirectTo(UserController.class).loginForm();
			
		}
	}

	public void logoutUser() {
		userSession.logout();
	}

}
