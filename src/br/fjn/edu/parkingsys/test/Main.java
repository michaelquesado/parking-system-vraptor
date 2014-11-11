package br.fjn.edu.parkingsys.test;

import java.util.Calendar;

import br.fjn.edu.parkingsys.connection.Connection;
import br.fjn.edu.parkingsys.dao.OperationDAO;
import br.fjn.edu.parkingsys.dao.ServiceDAO;
import br.fjn.edu.parkingsys.dao.VehicleDAO;
import br.fjn.edu.parkingsys.model.Customer;
import br.fjn.edu.parkingsys.model.Level;
import br.fjn.edu.parkingsys.model.Operation;
import br.fjn.edu.parkingsys.model.Service;
import br.fjn.edu.parkingsys.model.Type;
import br.fjn.edu.parkingsys.model.User;
import br.fjn.edu.parkingsys.model.Vehicle;

public class Main {

	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.setName("Amitay ");
		customer.setCpf("1234667");

		Vehicle vehicle = new Vehicle();
		vehicle.setCustomer(customer);
		vehicle.setLicensePlate("aaaa-1111");
		vehicle.setMark("golg6");
		vehicle.setModel("vw");
		
		
		
		User user = new User();
		user.setLevel(Level.EMPLOYEE);
		user.setUserName("francisco");
		user.setPassword("123");

		

		Service service = new Service();
		service.setVehicle(vehicle);
		service.setAmount(5.00);
		service.setEntry(Calendar.getInstance());
		service.setUser(user);
		service.setStay(null);
		

		ServiceDAO dao = new ServiceDAO();
		dao.save(service);

		
		Operation operation = new Operation();
		operation.setType(Type.ENTRY);
		operation.setDateTime(Calendar.getInstance());
		
		OperationDAO operationDAO = new OperationDAO();
		operationDAO.save(operation);
		
		Connection.close();

		System.out.println("Salvo com sucesso" + customer.getName());
		System.out
				.println("Salvo com sucesso" + vehicle.getCustomer().getCpf());

	}
}
