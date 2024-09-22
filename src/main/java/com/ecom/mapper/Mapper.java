package com.ecom.mapper;

import com.ecom.model.Customer;
import com.ecom.rocord.CustomerRequest;
import com.ecom.rocord.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Customer toCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .address(customerRequest.address())
                .build();
    }
    public CustomerResponse fromCustomer(Customer customer){
        return new CustomerResponse(customer.getId(), customer.getFirstName(),
                customer.getLastName(), customer.getEmail(),
                customer.getAddress());
    }


}
