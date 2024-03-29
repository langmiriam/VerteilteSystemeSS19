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
        if(product.getPrice() == 0 || product.getPrice() < 0){
            return "The price must not be negativ or 0!";
        }
        else{
            productRepository.save(product);
            return "The product " + product.getName() +  " was added.";
        }

    }


    public String updateProduct(Long id, Product product) {
        Product savedProduct = productRepository.findById(id).get();
        savedProduct.setName(product.getName());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setIsVegetarian(product.getIsVegetarian());
        productRepository.save(savedProduct);
        return "The product with the id " + id + " was updated.";
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
