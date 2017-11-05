/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.example;

import org.junit.Test;
import org.mapstruct.example.dto.CustomerDto;
import org.mapstruct.example.mapper.CustomerMapper;
import org.mapstruct.example.model.Customer;
import org.mapstruct.example.model.Title;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Gunnar Morling
 */
public class CustomerMapperTest {

    @Test
    public void shouldMapCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Bob");
        customer.setLastName("Smith");
        customer.setTitle(new Title("Mr."));
        customer.setDateOfBirth(LocalDate.of(1985, Month.AUGUST, 12));
        customer.setCreditScore(new BigDecimal("9.5"));
        CustomerDto dto = CustomerMapper.INSTANCE.customerToDto(customer);

        assertThat(dto.customerId).isEqualTo(1L);
        assertThat(dto.firstName).isEqualTo("Bob");
        assertThat(dto.lastName).isEqualTo("Smith");
    }
}
