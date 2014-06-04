package org.mapstruct.democamp.mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class DateMapper {

	public Date localDateToDate(LocalDate date) {
		if (date == null) {
			return null;
		}
		
		return Date.from( Instant.from( date ) );
	}
}
