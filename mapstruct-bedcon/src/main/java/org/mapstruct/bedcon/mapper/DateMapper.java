package org.mapstruct.bedcon.mapper;

import java.util.Date;

import org.joda.time.LocalDate;

public class DateMapper {

	public Date localDateToDate(LocalDate date) {
		if (date == null) {
			return null;
		}
		
		return date.toDate();
	}
}
