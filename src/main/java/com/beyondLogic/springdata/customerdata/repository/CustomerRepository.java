package com.beyondLogic.springdata.customerdata.repository;

import com.beyondLogic.springdata.customerdata.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
