package org.mapstruct.bedcon.model;

import org.joda.time.LocalDate;

public class Director {

	private String name;
	private LocalDate dateOfEntry;
	private String address;

	public Director() {
	}

	public Director(String name, LocalDate dateOfEntry, String address) {
		super();
		this.name = name;
		this.dateOfEntry = dateOfEntry;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfEntry() {
		return dateOfEntry;
	}
	
	public void setDateOfEntry(LocalDate dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
