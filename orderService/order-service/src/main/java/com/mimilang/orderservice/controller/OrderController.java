package com.mimilang.orderservice.controller;


import com.mimilang.orderservice.entities.OrderItem;
import com.mimilang.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/orders")
public class OrderController {

    OrderService orderService;

    //only for tests
    @RequestMapping("/hello")
    public String getHelloOrder(){
        return "Hello Order!";
    }

    //gets all orders
    @RequestMapping("/")
    public List<OrderItem> getAllOrders(){
        return orderService.getAllOrderItems();
    }


    //gets one specific orders
    @RequestMapping(value=("/customers/{id}"))
    public OrderItem addOrderItem(@PathVariable("id") Long id){
        return orderService.addOrderItem(id);
    }











}
