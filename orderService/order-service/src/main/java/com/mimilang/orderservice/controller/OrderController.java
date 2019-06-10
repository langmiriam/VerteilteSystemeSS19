package com.mimilang.orderservice.controller;


import com.mimilang.orderservice.entities.CustomerOrder;
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
    @RequestMapping(value="/orders", method= RequestMethod.POST)
    public String addOrder(@RequestBody CustomerOrder customerOrder){
        return orderService.addOrderItem(customerOrder.getCustomerId(), customerOrder.getProductId());
    }


    //update an order
    @RequestMapping(value="/orders/{id}", method= RequestMethod.PUT)
    public String  addCustomer(@RequestBody Product product, @PathVariable String id){
        return orderService.updateOrderItem(Long.parseLong(id), product);
    }


    //delete an order
    @RequestMapping(value="/orders/{id}", method= RequestMethod.DELETE)
    public String removeCustomer(@PathVariable String id){
        return orderService.removeOrderItem(Long.parseLong(id));
    }

}
