package org.mapstruct.bedcon.model;

import java.util.List;

public class Zoo {

	private String name;
	private List<Animal> animals;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
}
