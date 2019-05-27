package com.miriamLang1.customerservice.serviceImpl;

import com.miriamLang1.customerservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

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


    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Long id, Customer customer) {
       /* for(int i=0; i<topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }*/
        customerRepository.save(customer);
    }


    public void removeCustomer(Long id) {
        //topics.removeIf(t -> t.getId().equals(id));
        customerRepository.deleteById(id);
    }



}
