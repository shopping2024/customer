package com.ecom.repo.CustomerRepo;

import com.ecom.model.Customer;
import com.ecom.rocord.CustomerRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepo extends MongoRepository<Customer,String> {

}
