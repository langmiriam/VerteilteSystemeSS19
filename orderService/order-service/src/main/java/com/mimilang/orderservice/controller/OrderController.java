package com.mimilang.orderservice.controller;


import com.mimilang.orderservice.entities.OrderItem;
import com.mimilang.orderservice.entities.Product;
import com.mimilang.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    //only for tests
    @RequestMapping("/hello")
    public String getHello(){
        return "The Order Service is running.";
    }


    //gets all orders
    @RequestMapping("/orders")
    public List<OrderItem> getAllOrders(){
        return orderService.getAllOrderItems();
    }


    //gets one specific order
    @RequestMapping(value="/orders/{id}", method = RequestMethod.GET)
    public OrderItem getOrderItem(@PathVariable("id") String id){
        return orderService.getOrderItem(Long.parseLong(id));
    }


    //add an new order
    @RequestMapping(value="/orders/{id}", method= RequestMethod.POST)
    public String addOrder(@RequestBody Product product, @PathVariable("id") String id){
        return orderService.addOrderItem(Long.parseLong(id), product);
    }


    //update an order
    @RequestMapping(value="/orders/{id}", method= RequestMethod.PUT)
    public String  addCustomer(@RequestBody Product product, @PathVariable String id){
        return orderService.updateOrder(Long.parseLong(id), product);
    }


    //delete an order
    @RequestMapping(value="/orders/{id}", method= RequestMethod.DELETE)
    public String removeCustomer(@PathVariable String id){
        return orderService.removeOrder(Long.parseLong(id));
    }

}
