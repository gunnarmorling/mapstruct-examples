package org.mapstruct.example.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ValueMapping;
import org.mapstruct.example.dto.AddressDto;
import org.mapstruct.example.dto.CustomerDto;
import org.mapstruct.example.dto.ExternalCustomerType;
import org.mapstruct.example.model.Address;
import org.mapstruct.example.model.Customer;
import org.mapstruct.factory.Mappers;

@Mapper(uses= {AddressMapper.class, TitleMapper.class })
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target="customerId", source = "id")
    @Mapping(target="fullName", expression = "java(customer.getFirstName() + \" \" + customer.getLastName())")
    @Mapping(target="dateOfBirth", dateFormat = "dd.MM.yyyy")
    CustomerDto customerToDto(Customer customer);

	@ValueMapping(source="B2C", target="RETAIL")
	ExternalCustomerType customerTypeToExternal(CustomerType type);
	
    List<CustomerDto> customersToDtos(List<Customer> customers);

    void updateAddress(AddressDto dto, @MappingTarget Address address);
}
