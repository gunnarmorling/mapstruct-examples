package org.mapstruct.democamp.model;

public class VisitorAndFavoriteAnimalDto {

	private String name;
	private String address;
	private String animalName;

	public VisitorAndFavoriteAnimalDto() {
	}

	public VisitorAndFavoriteAnimalDto(String name, String address,
			String animalName) {
		this.name = name;
		this.address = address;
		this.animalName = animalName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
}
