package br.fjn.edu.parkingsys.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.fjn.edu.parkingsys.anotations.Public;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.UserDAO;
import br.fjn.edu.parkingsys.model.User;

@Controller
@Path("user")
public class UserController {

	@Inject
	private UserSession userSession;
	
	@Inject
	Result result;
	UserDAO userDAO;

	public void newUser(User user) {
		userDAO = new UserDAO();
		if (userDAO.UserExists(user)) {
			// caso já exista o usuário.
		} else {
			userDAO.insert(user);
		}
	}

	public void loginUser(User user) {
		
		User loadUser = userDAO.loadUser(user);

		if (loadUser == null) {
			System.out.println("Usuário ou Senha inválidos.");

		} else {
			System.out.println("Bem vindo ao ParkingSys " + user.getUserName()
					+ " !");
			userSession.setUser(loadUser);
		}

	}

	public void logoutUser() {
		
		userSession.logout();
	}
	
	@Public
	@Get("/login")
	public void loginForm() {}
	
	@Public
	@Get("/index")
	public void index(){
		result.of(this).loginForm();
	}
}
