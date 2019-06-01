package com.example.ProductService.Service;

import com.example.ProductService.Entities.Product;
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
        ProductRepository.findAll().forEach(products::add);
        return products;
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }


    public String addProduct(Product product) {
        productRepository.save(product);
        return "" + product.getName() + " was added.";
    }


    public String updateCustomer(Long id, Product product) {

        product.setId(id);
        deleteProduct(id);
        productRepository.save(product);
        return "The Product with the id " + product.getId() + " was updated.";
    }


    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "The Product with the id " + id + " was removed.";
    }

}
