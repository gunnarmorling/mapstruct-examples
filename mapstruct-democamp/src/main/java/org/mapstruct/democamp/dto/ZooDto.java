package org.mapstruct.democamp.dto;

import java.util.List;

public class ZooDto {

	private String name;
	private List<AnimalDto> animals;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AnimalDto> getAnimals() {
		return animals;
	}

	public void setAnimals(List<AnimalDto> animals) {
		this.animals = animals;
	}
}
