package org.mapstruct.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.example.dto.AddressDto;
import org.mapstruct.example.model.Address;

@Mapper
public interface AddressMapper {

	AddressDto addressToDto(Address address);
}
