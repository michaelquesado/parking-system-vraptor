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
import br.fjn.edu.parkingsys.dao.ServiceDAO;
import br.fjn.edu.parkingsys.model.Service;
import br.fjn.edu.parkingsys.model.User;
import br.fjn.edu.parkingsys.model.Vehicle;

@Controller
@Path("service")
public class ServiceController {
	
	@Inject
	UserSession userSession;

	@Inject
	Result result;

	@Inject
	Validator validator;

	@Get("/")
	public void index() {
		if (userSession.isLogged()) {
		result.include("user", userSession.getUser());
		}else{
			validator.onErrorRedirectTo(LoginController.class).logout();
		}
	}

	@Post("newService")
	public void newService(Service service, Vehicle vehicle) {

		User user = userSession.getUser();
		ServiceDAO serviceDAO = new ServiceDAO();

		if (userSession.isLogged()) {
			service.setDateTimeEntry(Calendar.getInstance());
			service.setVehicle(vehicle);
			service.setUser(user);
			validator.add(new SimpleMessage("salvo",
					"Operação salva com sucesso!"));
			serviceDAO.insert(service);
			result.redirectTo(IndexController.class).index();
		} else {
			validator.onErrorUsePageOf(LoginController.class).logout();

		}

	}
	
	

}
