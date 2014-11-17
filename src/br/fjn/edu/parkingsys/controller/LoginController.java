package br.fjn.edu.parkingsys.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.fjn.edu.parkingsys.anotations.Public;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.UserDAO;
import br.fjn.edu.parkingsys.model.User;

public class LoginController {
	@Inject
	private UserSession userSession;

	@Inject
	private Result result;

	@Inject
	private Validator validator;

	@Public
	@Get("login")
	public void loginForm() {

	}

	@Post("loginUser")
	@Public
	public void loginUser(User user) {

		UserDAO dao = new UserDAO();

		if (dao.loadUser(user)) {

			userSession.setUser(dao.getUser(user));
			result.redirectTo(IndexController.class).index();

		} else {
			validator.add(new SimpleMessage("login",
					"Usuário ou Senha inválidos!"));
			validator.onErrorRedirectTo(this).loginForm();
		}

	}
}
