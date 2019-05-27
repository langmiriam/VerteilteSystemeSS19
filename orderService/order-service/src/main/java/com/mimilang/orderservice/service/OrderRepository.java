package com.mimilang.orderservice.service;

import com.mimilang.orderservice.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderItem, Long> {


}
