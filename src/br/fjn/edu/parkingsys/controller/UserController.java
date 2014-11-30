package br.fjn.edu.parkingsys.controller;

import java.util.Calendar;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.UserDAO;
import br.fjn.edu.parkingsys.dao.log.LogDAO;
import br.fjn.edu.parkingsys.model.Level;
import br.fjn.edu.parkingsys.model.Operations;
import br.fjn.edu.parkingsys.model.User;
import br.fjn.edu.parkingsys.model.log.Log;

@Controller
@Path("user")
public class UserController {

	private UserSession userSession;
	private Result result;
	private Validator validator;
	private UserDAO dao;
	private Log log;
	private LogDAO logDAO;

	@Inject
	public UserController(UserSession userSession, Result result,
			Validator validator, UserDAO dao, Log log, LogDAO logDAO) {
		this.userSession = userSession;
		this.result = result;
		this.validator = validator;
		this.dao = dao;
		this.log = log;
		this.logDAO = logDAO;
	}

	/**
	 * @deprecated para o CDI
	 */
	UserController() {
	}

	@Get("userForm")
	public void userForm() {
		result.include("title", "New Users");
		result.include("user", userSession.getUser());
		result.include("levels", Level.values());

	}

	@Get("list")
	public void listUsers() {
		this.registerLog(Operations.READY);
		result.include("users", dao.listAllUsers())
				.include("levels", Level.values())
				.include("user", userSession.getUser());
		
	}

	@Get("delete/{id}")
	public void delete(int id) {
		this.registerLog(Operations.DELETE);
		dao.delete(id);
		result.redirectTo(this).listUsers();

	}

	@Post("add")
	public void add(User user) {
		System.out.println(user.getLevel());
		if (userSession.getUser().getLevel() != Level.MANAGER) {
			validator.add(new SimpleMessage("user",
					"Você não tem permisão para a ação."));
			result.redirectTo(IndexController.class).index();
		}
		if (dao.UserExists(user)) {
			validator.add(new SimpleMessage("user", "Usuário já existe!"));
			validator.onErrorRedirectTo(this).userForm();
		} else {
			this.registerLog(Operations.CREATE);
			dao.insert(user);
			result.redirectTo(this).listUsers();
		}

	}
	
	private void registerLog(Operations operations){
		
		log.setUser_id(userSession.getUser().getId());
		log.setModel("User");
		log.setOperation(operations);
		log.setCreated(Calendar.getInstance());
		
		logDAO.register(log);
	}


}
