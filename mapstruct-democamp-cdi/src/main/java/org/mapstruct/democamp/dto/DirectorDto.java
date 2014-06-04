package org.mapstruct.democamp.dto;

import java.util.Date;

public class DirectorDto {

	private String name;
	private Date dateOfEntry;
	private String address;

	public DirectorDto() {
	}

	public DirectorDto(String name, Date dateOfEntry, String address) {
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

	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
