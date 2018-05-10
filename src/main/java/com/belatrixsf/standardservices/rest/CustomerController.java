package com.belatrixsf.standardservices.rest;

import com.belatrixsf.standardservices.model.Customer;
import com.belatrixsf.standardservices.services.CustomerService;
import java.util.Optional;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  private CustomerService service;


  @Autowired
  public CustomerController(CustomerService service) {
    Validate.notNull(service);
    this.service = service;
  }


  @GetMapping("/customers/{id}")
  public HttpEntity<Customer> getCustomerInfo(@PathVariable Integer id) {
    Optional<Customer> c = service.getCustomer(id);
    if (c.isPresent()) {
      return ok(c.get());
    } else {
      return notFound();
    }
  }


  private ResponseEntity<Customer> ok(Customer c) {
    return new ResponseEntity<Customer>(c, HttpStatus.OK);
  }

  private ResponseEntity<Customer> notFound() {
    return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
  }

}
