package br.fjn.edu.parkingsys.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.fjn.edu.parkingsys.components.RegisterLog;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.UserDAO;
import br.fjn.edu.parkingsys.model.Level;
import br.fjn.edu.parkingsys.model.Operations;
import br.fjn.edu.parkingsys.model.User;

@Controller
@Path("user")
public class UserController {

	private UserSession userSession;
	private Result result;
	private Validator validator;
	private UserDAO dao;
	private RegisterLog log;
	private final String MODEL = "User";
	
	@Inject
	public UserController(UserSession userSession, Result result,
			Validator validator, UserDAO dao, RegisterLog log) {
		this.userSession = userSession;
		this.result = result;
		this.validator = validator;
		this.dao = dao;
		this.log = log;
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
		log.registrationLog(Operations.READ, MODEL);
		result.include("users", dao.listAllUsers())
				.include("levels", Level.values())
				.include("user", userSession.getUser());
		
	}

	@Get("delete/{id}")
	public void delete(int id) {
		log.registrationLog(Operations.DELETE, MODEL);
		dao.delete(id);
		validator.add(new SimpleMessage("warning", "User delete with sucess"));
		validator.onErrorRedirectTo(this).listUsers();
		

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
			log.registrationLog(Operations.CREATE, MODEL);
			dao.insert(user);
			validator.add(new SimpleMessage("success", "New User add with success!"));
			validator.onErrorRedirectTo(this).listUsers();
		}

	}
	
	


}
