package com.belatrixsf.standardservices.services;

import com.belatrixsf.standardservices.model.Customer;
import java.util.Optional;

public interface CustomerService {

  Optional<Customer> getCustomer(Integer id);

}
