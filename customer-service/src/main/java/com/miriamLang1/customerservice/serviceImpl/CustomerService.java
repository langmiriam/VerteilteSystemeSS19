package com.miriamLang1.customerservice.serviceImpl;

import com.miriamLang1.customerservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }


    public Customer getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }


    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "" + customer.getForename() + " " + customer.getLastname() + " was added.";
    }


    public String updateCustomer(Long id, Customer customer) {
       /* for(int i=0; i<topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }*/
        Customer savedCustomer = customerRepository.findById(id).get();
        savedCustomer.setForename(customer.getForename());
        savedCustomer.setLastname(customer.getLastname());
        savedCustomer.setUsername(customer.getUsername());
        savedCustomer.setEmail(customer.getEmail());
        customerRepository.save(savedCustomer);
        return "The customer with the id " + id + " was updated.";
    }


    public String removeCustomer(Long id) {
        //topics.removeIf(t -> t.getId().equals(id));
        customerRepository.deleteById(id);
        return "The customer with the id " + id + " was removed.";
    }

}
