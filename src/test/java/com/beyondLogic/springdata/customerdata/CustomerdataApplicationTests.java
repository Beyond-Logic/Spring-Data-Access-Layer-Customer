package com.beyondLogic.springdata.customerdata;

import com.beyondLogic.springdata.customerdata.model.Customer;
import com.beyondLogic.springdata.customerdata.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerdataApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setName("BeyondLogic");
		customer.setEmail("BeyondLogic@Localhost.com");

		customerRepository.save(customer);
	}

	@Test
	public void testRead() {

		Customer customer = customerRepository.findById(1L).get();
		assertNotNull(customer);
		assertNotEquals("Lucid", customer.getName());

	}

	@Test
	public void testUpdate() {

		Customer customer = customerRepository.findById(1L).get();
		customer.setEmail("LucidLogic@locahost.com");
		customerRepository.save(customer);
	}

	@Test
	public void testDelete(){
		if(customerRepository.existsById(1L)) {
			System.out.println("Deleting a product");
			customerRepository.deleteById(1L);
		}

	}

}
