package com.project.productService.serviceImpl;

import com.project.productService.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }


    public Product getProductById(Long id) {
        Product products = productRepository.findById(id).get();
        return products;
    }


    public String addProduct(Product product) {
        productRepository.save(product);
        return "" + product.getName() + " " + product.getPrice() + product.isVegetarian() + " was added.";
    }


    public String updateProduct(Long id, Product product) {
        Product savedProduct = productRepository.findById(id).get();
        savedProduct.setName(product.getName());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setVegetarian(product.isVegetarian());
        productRepository.save(savedProduct);
        return "The customer with the id " + id + " was updated.";
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
