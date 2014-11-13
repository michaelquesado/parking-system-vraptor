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
	private UserDAO userDAO;

	@Public
	@Get("loginForm")
	public void loginForm() {

	}

	@Post("loginUser")
	@Public
	public void loginUser(User user) {

		User userLoad = userDAO.loadUser(user);

		if (userLoad == null) {
			System.out.println("Usuário ou Senha inválidos.");
			result.redirectTo(UserController.class).loginForm();

		} else {
			System.out.println("Bem vindo ao ParkingSys "
					+ userLoad.getUserName() + " !");
			userSession.setUser(userLoad);
			result.redirectTo(IndexController.class).index();
		}

	}

	public void logoutUser() {
		userSession.logout();
	}

}
