package com.ecom.controller;

import com.ecom.model.Customer;
import com.ecom.rocord.CustomerRequest;
import com.ecom.rocord.CustomerResponse;
import com.ecom.service.CustomerService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest customerRequest){
return new ResponseEntity<>(customerService.createCustomer(customerRequest), HttpStatus.OK);
    }
    @PutMapping
public ResponseEntity<Void> updateCustomer(@RequestBody CustomerRequest customerRequest){
    customerService.updateCustomer(customerRequest);
       return new ResponseEntity<>(HttpStatus.OK);
}
@GetMapping
@PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
}
@GetMapping("/exist/{id}")
public ResponseEntity<Boolean> existById(@PathVariable String id){
return new ResponseEntity<>(customerService.existById(id),HttpStatus.OK);
}
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<CustomerResponse> findCustomer(@PathVariable String id){
        return new ResponseEntity<>(customerService.findCustomer(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
}

}
