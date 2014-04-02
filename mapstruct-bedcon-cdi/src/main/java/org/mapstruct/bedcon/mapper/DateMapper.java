package org.mapstruct.bedcon.mapper;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.joda.time.LocalDate;

@ApplicationScoped
public class DateMapper {

	public Date localDateToDate(LocalDate date) {
		if (date == null) {
			return null;
		}
		
		return date.toDate();
	}
}
