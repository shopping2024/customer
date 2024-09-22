package com.ecom.service;

import com.ecom.rocord.CustomerRequest;
import com.ecom.rocord.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    public String createCustomer(CustomerRequest request);
    public void updateCustomer(CustomerRequest customerRequest);
    public List<CustomerResponse> getAllCustomer();
    public Boolean existById(String id);
    public CustomerResponse findCustomer(String id);

    void deleteCustomer(String id);
}
