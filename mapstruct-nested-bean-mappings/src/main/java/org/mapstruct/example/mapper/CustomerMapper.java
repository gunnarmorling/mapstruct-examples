package org.mapstruct.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.example.dto.AddressDto;
import org.mapstruct.example.dto.CustomerDto;
import org.mapstruct.example.model.Address;
import org.mapstruct.example.model.Customer;
import org.mapstruct.example.model.Title;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses=AddressMapper.class)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target="customerId", source = "id")
    @Mapping(target="fullName", expression = "java(customer.getFirstName() + \" \" + customer.getLastName())")
    @Mapping(target="dateOfBirth", dateFormat = "dd.MM.yyyy")
    CustomerDto customerToDto(Customer customer);

    List<CustomerDto> customersToDtos(List<Customer> customers);

    void updateAddress(AddressDto dto, @MappingTarget Address address);
    
    default String titleToString(Title title) {
        return title.getValue();
    }
}
