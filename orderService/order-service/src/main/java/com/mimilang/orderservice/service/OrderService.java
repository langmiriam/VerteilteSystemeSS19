package com.mimilang.orderservice.service;

import com.mimilang.orderservice.entities.Customer;
import com.mimilang.orderservice.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    RestTemplate restTemplate;

    OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;


    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    public OrderItem getCustomer(Long id) {
        OrderItem orderItem = orderRepository.findById(id).get();
        return orderItem;
    }


    public OrderItem addOrderItem(Long id) {
        Customer customer = restTemplate.getForObject("http://localhost:8082/movies/" + id, Customer.class);
        return orderRepository.save(new OrderItem(customer.getForename(), customer.getLastname(), "spaghetti"));

    }
}
