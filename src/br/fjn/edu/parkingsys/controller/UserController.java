package br.fjn.edu.parkingsys.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
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
	private  UserDAO userDAO;
	
	@Public
	@Get("login")
	public void loginForm() {
		result.include("title", "Parking System");
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
	
	
	public void logout() {
		userSession.logout();
		result.redirectTo(this).loginForm();
	}
	
	@Get("formAdd")
	public void formAdd(){
		result.include("title", "New Users");
		result.include(userSession.getUser());
		result.include("levels",Level.values());
		
	}
	
	
	public void add(User user){
		result.include("title", "New Users");
		
		if(userSession.getUser().getLevel() == Level.MANAGER){
			userDAO.insert(user);
			result.redirectTo(IndexController.class).index();
		}else{
			result.include("alert", "alert-danger");
			result.include("flash", "You dont have permission to access this page!");
			result.redirectTo(IndexController.class).index();
		}
	}

}
