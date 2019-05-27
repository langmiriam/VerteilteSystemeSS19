package com.miriamLang1.customerservice.serviceImpl;

import com.miriamLang1.customerservice.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
