package br.fjn.edu.parkingsys.test;

import br.fjn.edu.parkingsys.dao.ServiceDAO;
import br.fjn.edu.parkingsys.dao.VehicleDAO;
import br.fjn.edu.parkingsys.model.Service;
import br.fjn.edu.parkingsys.model.Vehicle;

public class Main {

	public static void main(String[] args) {

		VehicleDAO dao = new VehicleDAO();

		Vehicle vehicle = new Vehicle();
		vehicle.setLicensePlate("nrd1353");

		Service service = new Service();
		service.setVehicle(dao.getVehicle(vehicle.getLicensePlate()));
		ServiceDAO dao2 = new ServiceDAO();
		dao2.insert(service);

	}
}
