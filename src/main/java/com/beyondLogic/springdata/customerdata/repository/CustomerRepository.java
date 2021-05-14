package com.beyondLogic.springdata.customerdata.repository;

import com.beyondLogic.springdata.customerdata.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByEmailAndName (String email, String name);

    Set<Customer> findByIdIn (Set<Long> ids);
}
