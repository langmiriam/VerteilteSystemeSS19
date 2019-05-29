package com.miriamLang1.customerservice.serviceImpl;


import com.miriamLang1.customerservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/hello")
    public String getHello(){
        return "Hello Mensa!";
    }

    @RequestMapping("/customers")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }


    @RequestMapping(value="/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("id") String id){
        return customerService.getCustomer(Long.parseLong(id));
    }


    @RequestMapping(value="/customers", method= RequestMethod.POST)
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }


    @RequestMapping(value="/customers/{id}", method= RequestMethod.PUT)
    public void addCustomer(@RequestBody Customer customer, @PathVariable String id){
        customerService.updateCustomer(Long.parseLong(id), customer);
    }


    @RequestMapping(value="/customers/{id}", method= RequestMethod.DELETE)
    public void removeCustomer(@PathVariable String id){
        customerService.removeCustomer(Long.parseLong(id));
    }


}
