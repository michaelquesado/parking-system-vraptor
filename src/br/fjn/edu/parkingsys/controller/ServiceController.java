package br.fjn.edu.parkingsys.controller;

import java.text.SimpleDateFormat;
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
	public ServiceController(UserSession session, Result result,
			VehicleDAO daoVehicle, ServiceDAO daoSevice) {
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

	@Post("newService")
	public void newService(Service service, Vehicle vehicle) {

		User user = userSession.getUser();

		if (daoVehicle.vehicleExists(vehicle.getLicensePlate())) {
			Vehicle v = daoVehicle.getVehicle(vehicle.getLicensePlate());
			service.setVehicle(v);
		} else {
			service.setVehicle(vehicle);
		}

		service.setUser(user);

		service.setDateTimeEntry(Calendar.getInstance());
		daoService.insert(service);
		result.redirectTo(this).list();

	}

	@Get("services")
	public void list() {
		result.include("user", userSession.getUser());
		result.include("services", daoService.ListServices());
	}

	@Get("search")
	public void search(String licensePlate) {

		if (daoVehicle.vehicleExists(licensePlate)) {

			result.use(Results.json()).withoutRoot()
					.from(daoVehicle.getVehicle(licensePlate)).serialize();

		}

	}

	@Get("checkout/{id}")
	public void checkout(int id) {
		if (daoService.serviceExist(id)) {

			Service checkOut = daoService.getService(id);
			checkOut.setDateTimeOut(Calendar.getInstance());

			String[] tempo = this.Stay(checkOut);

			int hora = Integer.parseInt(tempo[0]) * 60;
			int min = Integer.parseInt(tempo[1]);
			int tempoTotal = hora + min;
			checkOut.setStay(tempoTotal);
			if (tempoTotal > 30) {
				checkOut.setAmount(tempoTotal * 0.06);
			} else {
				checkOut.setAmount(0.0);
			}
			
			daoService.update(checkOut);
			
			result.include("user", userSession.getUser());
			result.include("services", daoService.ListServices());
			result.of(this).list();
		}
	}

	private String[] Stay(Service service) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		long start = service.getDateTimeEntry().getTimeInMillis();
		long out = service.getDateTimeOut().getTimeInMillis();

		long time = out - start;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		cal.add(Calendar.SECOND, Integer.parseInt("" + (time / 1000)));
		System.out.println(time / 1000);

		return sdf.format(cal.getTime()).split(":");

	}

}
