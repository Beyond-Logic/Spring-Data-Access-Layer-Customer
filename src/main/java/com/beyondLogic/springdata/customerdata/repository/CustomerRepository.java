package com.beyondLogic.springdata.customerdata.repository;

import com.beyondLogic.springdata.customerdata.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByEmailAndName (String email, String name);

    Set<Customer> findByIdIn (Set<Long> ids);

    @Modifying
    @Query("UPDATE Customer SET email=:email WHERE id=:id")
    void updateCustomerEmail(@Param("email") String email, @Param("id") Long id);

}
