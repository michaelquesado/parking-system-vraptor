package br.fjn.edu.parkingsys.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.fjn.edu.parkingsys.anotations.Public;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.UserDAO;
import br.fjn.edu.parkingsys.model.Level;
import br.fjn.edu.parkingsys.model.User;

@Controller
public class UserController {

	@Inject
	private UserSession userSession;

	@Inject
	private Result result;

	@Inject
	private Validator validator;

	@Get("userForm")
	public void userForm() {

		result.include("user", userSession.getUser().getName());
		result.include("levels", Level.values());

	}

	@Get("list")
	public List<User> listUsers() {
		result.include("user", userSession.getUser().getName());
		result.include("levels", Level.values());
		UserDAO dao = new UserDAO();
		return dao.listAllUsers();

	}

	@Get("delete")
	public void deleteUser(Integer id) {
		result.include("user", userSession.getUser().getName());
		result.include("levels", Level.values());
		UserDAO dao = new UserDAO();
		User user = dao.load(id);
		dao.delete(user);
		result.redirectTo(UserController.class).listUsers();

	}

	@Post("new")
	public void newUser(User user) {

		UserDAO dao = new UserDAO();

		if (dao.UserExists(user)) {
			validator.add(new SimpleMessage("user", "Usuário já existe!"));
			validator.onErrorRedirectTo(this).userForm();
		} else {
			dao.insert(user);
			result.redirectTo(UserController.class).listUsers();
		}

	}

	public void logoutUser() {
		userSession.logout();
		result.redirectTo(LoginController.class).loginForm();
	}

}
