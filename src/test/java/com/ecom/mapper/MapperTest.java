package com.ecom.mapper;

import com.ecom.model.Address;
import com.ecom.model.Customer;
import com.ecom.rocord.CustomerRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {

    private Mapper  mapper;

    @BeforeEach
    void setUp() {
        mapper=new Mapper();
    }
@Test
public void toCustomerTest(){

    CustomerRequest cr=new CustomerRequest(
            "215cbo29",
            "Saraswati",
            "Satapathy",
            "satapathy@gmail.com",
           new Address("fsf","sfsf","af")
    );

  var customer=mapper.toCustomer(cr);
    System.out.println(customer.hashCode());
  assertEquals(cr.hashCode(),customer.hashCode());

}

}