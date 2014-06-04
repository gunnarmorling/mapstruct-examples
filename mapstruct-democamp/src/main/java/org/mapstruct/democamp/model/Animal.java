package org.mapstruct.democamp.model;

import java.util.Date;

public class Animal {

	private String name;
	private Date dateOfBirth;
	private long weightInPounds;

	public Animal() {
	}
	
	public Animal(String name, Date dateOfBirth, long weightInPounds) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.weightInPounds = weightInPounds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getWeightInPounds() {
		return weightInPounds;
	}
	
	public void setWeightInPounds(long weightInPounds) {
		this.weightInPounds = weightInPounds;
	}
}
