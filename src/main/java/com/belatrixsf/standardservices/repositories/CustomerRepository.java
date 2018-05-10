package com.belatrixsf.standardservices.repositories;

import com.belatrixsf.standardservices.model.Customer;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  @Override
  Optional<Customer> findById(Integer id);

}
