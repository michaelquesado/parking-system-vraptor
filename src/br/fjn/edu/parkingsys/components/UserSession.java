package br.fjn.edu.parkingsys.components;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.fjn.edu.parkingsys.model.User;

@SessionScoped
@Named("sessionUser")
public class UserSession implements Serializable {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLogged() {
		System.out.println("user session -" + user);
		return user != null;
	}

	public void logout() {
		this.user = null;

	}

}
