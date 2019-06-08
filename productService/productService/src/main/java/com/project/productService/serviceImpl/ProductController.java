package com.project.productService.serviceImpl;

import com.project.productService.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/products/hello")
    public String getHello(){
        return "The Product Service is running.";
    }


    @RequestMapping("/products")
    public List<Product> getAllCustomer(){
        return productService.getAllProducts();
    }


    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public Product getCustomer(@PathVariable("id") String id){
        return productService.getProductById(Long.parseLong(id));
    }


    @RequestMapping(value="/products", method= RequestMethod.POST)
    public String addCustomer(@RequestBody Product product){
        return productService.addProduct(product);
    }


    @RequestMapping(value="/products/{id}", method= RequestMethod.PUT)
    public String updateCustomer(@RequestBody Product product, @PathVariable String id){
        return productService.updateProduct(Long.parseLong(id), product);
    }


    @RequestMapping(value="/products/{id}", method= RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(Long.parseLong(id));
    }

}
