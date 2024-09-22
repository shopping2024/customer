package com.ecom.service.impl;

import com.ecom.exception.CustomerNotFoundException;
import com.ecom.mapper.Mapper;
import com.ecom.model.Customer;
import com.ecom.repo.CustomerRepo.CustomerRepo;
import com.ecom.rocord.CustomerRequest;
import com.ecom.rocord.CustomerResponse;
import com.ecom.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private Mapper mapper;
    @Override
    public String createCustomer(CustomerRequest request) {
        Customer customer= mapper.toCustomer(request);
        customerRepo.save(customer);
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest customerRequest) {
        Customer customer= customerRepo.findById(customerRequest.id()).orElseThrow(()->
                new CustomerNotFoundException("Customer not found with the provided id:"+customerRequest.id()));
        mergeCustomer(customer,customerRequest);
        customerRepo.save(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {

        return customerRepo.findAll().stream().map(mapper::fromCustomer).collect(Collectors.toList());
    }

    @Override
    public Boolean existById(String id) {
        return customerRepo.findById(id).isPresent();
    }

    @Override
    public CustomerResponse findCustomer(String id) {
        return customerRepo.findById(id)
                .map(mapper::fromCustomer)
                .orElseThrow(()->new CustomerNotFoundException("Customer not found with the provided id:"+id));
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepo.deleteById(id);
    }

    public void mergeCustomer(Customer customer,CustomerRequest request){
        if(StringUtils.isNotBlank(request.firstName())){
            customer.setFirstName(request.firstName());
        }
        if(StringUtils.isNotBlank(request.lastName())){
            customer.setLastName(request.lastName());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }
        if(request.address()!=null){
            customer.setAddress(request.address() );
        }
    }


}
