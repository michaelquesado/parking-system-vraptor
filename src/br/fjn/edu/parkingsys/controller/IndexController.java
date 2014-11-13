package br.fjn.edu.parkingsys.controller;


import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.fjn.edu.parkingsys.anotations.Public;

@Controller
public class IndexController {
	
	@Get("/")
	public void index() {
		System.out.println("Home Active!");
	}
}
