package com.project.productService.serviceImpl;

import com.project.productService.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
