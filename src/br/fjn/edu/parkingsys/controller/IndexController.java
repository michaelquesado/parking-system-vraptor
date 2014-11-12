package br.fjn.edu.parkingsys.controller;

<<<<<<< HEAD
import br.com.caelum.vraptor.*;
import br.fjn.edu.parkingsys.anotations.Public;

@Controller
public class IndexController {
	
	@Public
	@Get("/")
	public void index() {
=======
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class IndexController {

	@Get("/")
	public void index() {
		System.out.println("Home Active!");
>>>>>>> f8dea5f998e0ff3e2f182f6ba317d8ab3e92595c

	}
}
