package br.fjn.edu.parkingsys.model;

public enum Level {
	EMPLOYEE("EMPLOYEE"),MANAGER("MANAGER");
	
	public String level;
	
	Level(String level){
		this.level = level;
	}
	
	public String getLevel(){
		return this.level;
	}
	
	
}
