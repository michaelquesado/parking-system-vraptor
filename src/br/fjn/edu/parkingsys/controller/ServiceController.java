package br.fjn.edu.parkingsys.controller;

import java.util.Calendar;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
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
	private VehicleDAO daoVehicle;
	private ServiceDAO daoService;

	@Inject
	public ServiceController(UserSession session, Result result, VehicleDAO daoVehicle, ServiceDAO daoSevice) {
		this.userSession = session;
		this.result = result;
		this.daoVehicle = daoVehicle;
		this.daoService = daoSevice;
	}

	/**
	 * @deprecated para o CDI
	 */
	ServiceController() {
	}

	@Get("/")
	public void index() {

		result.include("user", userSession.getUser());
	}

	public void searchVehicle(String licensePlate) {

		if (daoVehicle.vehicleExists(licensePlate)) {
			Vehicle v = daoVehicle.getVehicle(licensePlate);
			// result.include(v);

		} else {
			// result.include("notfound", "Veiculo não encontrado");
		}
	}

	@Post("newService")
	public void newService(Service service, Vehicle vehicle) {

		User user = userSession.getUser();

		if (daoVehicle.vehicleExists(vehicle.getLicensePlate())) {

			Vehicle v = daoVehicle.getVehicle(vehicle.getLicensePlate());

			System.out.println("recupera vehicle e seta em service");

			// service.setUser(user);
			service.setVehicle(v);
			service.setDateTimeEntry(Calendar.getInstance());
			daoService.insert(service);

			System.out.println("salva o service");

		} else {

			System.out.println("desabilita campos para cadastrar novo.");

			service.setVehicle(vehicle);
			service.setDateTimeEntry(Calendar.getInstance());

			daoService.insert(service);

			System.out.println("cadastra novo");
		}
	}

	@Get("search")
	public void search(String licensePlate) {

		if (daoVehicle.vehicleExists(licensePlate)) {
			
			result.use(Results.json()).from(daoVehicle.getVehicle(licensePlate), "vehicle").serialize();
			
		}

	}

}
