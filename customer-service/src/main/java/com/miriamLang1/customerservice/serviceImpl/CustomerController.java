package com.miriamLang1.customerservice.serviceImpl;


import com.miriamLang1.customerservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //Greetings page
    @RequestMapping("/hello")
    public String getHello(){
        return "The Customer Service is running.";
    }

    //List all customers
    @RequestMapping("/customers")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    //List one customer
    @RequestMapping(value="/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("id") String id){
        return customerService.getCustomer(Long.parseLong(id));
    }

    //Add customer
    @RequestMapping(value="/customers", method= RequestMethod.POST)
    public String addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    //Update Customer
    @RequestMapping(value="/customers/{id}", method= RequestMethod.PUT)
    public String updateCustomer(@RequestBody Customer customer, @PathVariable String id){
        return customerService.updateCustomer(Long.parseLong(id), customer);
    }

    //Remove Customer
    @RequestMapping(value="/customers/{id}", method= RequestMethod.DELETE)
    public String removeCustomer(@PathVariable String id){
        return customerService.removeCustomer(Long.parseLong(id));
    }

}
