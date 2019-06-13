package com.mimilang.orderservice.service;

import com.mimilang.orderservice.entities.Customer;
import com.mimilang.orderservice.entities.OrderItem;
import com.mimilang.orderservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderRepository orderRepository;


    //Returns all existing orders in the repository
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }


    //Returns one specific order from the repository
    public OrderItem getOrderItem(Long id) {
        OrderItem orderItem = orderRepository.findById(id).get();
        return orderItem;
    }


    //Updates an order in the repository
    public String updateOrderItem(Long id, Product product) {
        OrderItem savedOrderItem = orderRepository.findById(id).get();
        savedOrderItem.setProduct(product.getName());
        orderRepository.save(savedOrderItem);
        return "The order with the id " + id + " was updated.";
    }


    //Removes an order from the repository
    public String removeOrderItem(Long id) {
        orderRepository.deleteById(id);
        return "The order with the id " + id + " was removed.";
    }


    //Adds an order to the repository
    public String addOrderItem(Long customerId, Long productId) {
        Customer customer = restTemplate.getForObject("http://customer-service/customers/" + customerId, Customer.class);
        Product product = restTemplate.getForObject("http://product-service/products/" + productId, Product.class);
        orderRepository.save(new OrderItem(customer.getForename(), customer.getLastname(), product.getName()));
        return "A new order was created for " + customer.getForename() + " " + customer.getLastname() + ".";
    }

}
