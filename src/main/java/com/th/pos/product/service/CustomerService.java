package com.th.pos.product.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.th.pos.product.model.Customer;
import com.th.pos.product.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Value("${stripe.apikey}")
    String key;

    public Customer findCustomerById(Long id) {
        return repository.findCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer addCustomer(Customer data) throws StripeException {
        Stripe.apiKey = key;
        Map<String, Object> params = new HashMap<>();
        params.put("name",data.getName());
        params.put("email",data.getEmail());

        com.stripe.model.Customer customer = com.stripe.model.Customer.create(params);
        data.setStripeId(customer.getId());
        return repository.save(data);
    }

    public Customer updateCustomer(Customer data) {
        return repository.save(data);
    }

    public void deleteCustomerById(Long id) {
        repository.deleteById(id);
    }
}
