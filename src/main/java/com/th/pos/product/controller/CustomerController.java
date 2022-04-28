package com.th.pos.product.controller;

import com.stripe.exception.StripeException;
import com.th.pos.product.model.Customer;
import com.th.pos.product.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/find/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findCustomerById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer data) throws StripeException {
        return new ResponseEntity<>(service.addCustomer(data), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer data) {
        return new ResponseEntity<>(service.updateCustomer(data), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable("id") Long id) {
        service.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}