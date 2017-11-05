package org.mapstruct.example.mapper;

import org.mapstruct.example.model.Title;

public class TitleMapper {

	 public String titleToString(Title title) {
	        return title != null ? title.getValue() : null;
	 }
}
