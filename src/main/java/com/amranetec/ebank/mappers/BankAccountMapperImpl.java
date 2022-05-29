package com.amranetec.ebank.mappers;

import com.amranetec.ebank.dtos.CustomerDto;
import com.amranetec.ebank.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {
    public CustomerDto fromCustomer(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        //customerDto.setId(customer.getId());
        //customerDto.setName(  customer.getName());
        //customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

    public Customer fromCustomerDto(CustomerDto customerDto){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
}
