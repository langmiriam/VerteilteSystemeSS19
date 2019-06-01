package com.example.ProductService.Controller;

import com.example.ProductService.Entities.Product;
import com.example.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/hello")
    public String getHello(){
        return "The Product Service is running.";
    }


    @RequestMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") String id){
        return productService.getProductById(Long.parseLong(id));
    }


    @RequestMapping(value="/products", method= RequestMethod.POST)
    public String addProduct(@RequestBody Product product){
        return ProductService.addProduct(product);
    }


    @RequestMapping(value="/product/{id}", method= RequestMethod.PUT)
    public String updateProduct(@RequestBody Product product, @PathVariable String id){
        return productService.updateProduct(Long.parseLong(id), product);
    }


    @RequestMapping(value="/products/{id}", method= RequestMethod.DELETE)
    public String deleteProduct(@PathVariable String id){
        return productService.deleteProduct(Long.parseString(id));
    }


}
