package com.mimilang.orderservice.service;

import com.mimilang.orderservice.entities.Customer;
import com.mimilang.orderservice.entities.OrderItem;
import com.mimilang.orderservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;


    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }


    public OrderItem getOrderItem(Long id) {
        OrderItem orderItem = orderRepository.findById(id).get();
        return orderItem;
    }


    public String updateOrderItem(Long id, Product product) {
        OrderItem savedOrderItem = orderRepository.findById(id).get();
        savedOrderItem.setProduct(product.getName());
        orderRepository.save(savedOrderItem);
        return "The order with the id " + id + " was updated.";
    }


    public String removeOrderItem(Long id) {
        orderRepository.deleteById(id);
        return "The order with the id " + id + " was removed.";
    }


    public String addOrderItem(Long customerId, Long productId) {
        Customer customer = restTemplate.getForObject("http://localhost:8080/customers/" + customerId, Customer.class);
        Product product = restTemplate.getForObject("http://localhost:8081/products/" + productId, Product.class);
        orderRepository.save(new OrderItem(customer.getForename(), customer.getLastname(), product.getName()));
        return "A new order was created for " + customer.getForename() + " " + customer.getLastname() + ".";
    }

}
