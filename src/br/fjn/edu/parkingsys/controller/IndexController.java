package br.fjn.edu.parkingsys.controller;

import br.com.caelum.vraptor.*;
import br.fjn.edu.parkingsys.anotations.Public;

@Controller
public class IndexController {
	
	@Public
	@Get("/")
	public void index() {

	}
}
