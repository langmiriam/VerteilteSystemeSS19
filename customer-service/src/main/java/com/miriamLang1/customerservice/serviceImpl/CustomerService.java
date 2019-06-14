package com.miriamLang1.customerservice.serviceImpl;

import com.miriamLang1.customerservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    //Database transactions

    @Autowired
    private CustomerRepository customerRepository;

    //Read all
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    //Read one
    public Customer getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    //Create
    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "" + customer.getForename() + " " + customer.getLastname() + " was added.";
    }

    //Update
    public String updateCustomer(Long id, Customer customer) {

        Customer savedCustomer = customerRepository.findById(id).get();
        savedCustomer.setForename(customer.getForename());
        savedCustomer.setLastname(customer.getLastname());
        savedCustomer.setUsername(customer.getUsername());
        savedCustomer.setEmail(customer.getEmail());
        customerRepository.save(savedCustomer);
        return "The customer with the id " + id + " was updated.";
    }

    //Remove
    public String removeCustomer(Long id) {
        customerRepository.deleteById(id);
        return "The customer with the id " + id + " was removed.";
    }

}
