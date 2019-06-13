package com.mimilang.orderservice.entities;

//Objects of this class are used to accept the ID of a customer and a product and to be
//handed to the method that creates and saves the orders
public class CustomerOrder {

    private Long customerId;
    private Long productId;

    public CustomerOrder(Long customerId, Long productId){
        this.customerId = customerId;
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
