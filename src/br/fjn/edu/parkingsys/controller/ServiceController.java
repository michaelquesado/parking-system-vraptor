package br.fjn.edu.parkingsys.controller;

import java.util.Calendar;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.dao.ServiceDAO;
import br.fjn.edu.parkingsys.dao.VehicleDAO;
import br.fjn.edu.parkingsys.model.Service;
import br.fjn.edu.parkingsys.model.User;
import br.fjn.edu.parkingsys.model.Vehicle;

@Controller
@Path("service")
public class ServiceController {

	private UserSession userSession;
	private Result result;
	private Validator validator;
	private VehicleDAO dao;

	@Inject
	public ServiceController(UserSession session, Result result,
			Validator validator, VehicleDAO dao) {
		this.userSession = session;
		this.result = result;
		this.validator = validator;
		this.dao = dao;
	}

	/**
	 * @deprecated para o CDI
	 */
	ServiceController() {
	}

	@Get("/")
	public void index() {
		if (userSession.isLogged()) {
			result.include("user", userSession.getUser());
		} else {
			validator.onErrorRedirectTo(LoginController.class).logout();
		}
	}

	public void searchVehicle(String licensePlate) {

		if (dao.vehicleExists(licensePlate)) {
			Vehicle v = dao.getVehicle(licensePlate);
			result.include(v);

		} else {
			result.include("notfound", "Ve�culo n�o encontrado");
		}
	}

	@Post("newService")
	public void newService(Service service, Vehicle vehicle) {

		ServiceDAO serviceDAO = new ServiceDAO();
		User user = userSession.getUser();

		if (dao.vehicleExists(vehicle.getLicensePlate())) {
			Vehicle v = dao.getVehicle(vehicle.getLicensePlate());
			System.out.println("recupera vehicle e seta em service");
			service.setUser(user);
			service.setVehicle(v);
			service.setDateTimeEntry(Calendar.getInstance());
			serviceDAO.insert(service);
			System.out.println("salva o service");
		} else {
			System.out.println("desabilita campos para cadastrar novo.");
			service.setVehicle(vehicle);
			service.setDateTimeEntry(Calendar.getInstance());
			serviceDAO.insert(service);
			System.out.println("cadastra novo");
		}
	}

	@Get("search")
	public void search(String licensePlate) {

		// result.use(Results.json()).from(Vehicle.class).serialize();
		System.out.println(licensePlate);

	}

}
