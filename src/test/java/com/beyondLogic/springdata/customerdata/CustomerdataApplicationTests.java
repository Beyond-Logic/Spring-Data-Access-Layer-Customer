package com.beyondLogic.springdata.customerdata;

import com.beyondLogic.springdata.customerdata.model.Address;
import com.beyondLogic.springdata.customerdata.model.Customer;
import com.beyondLogic.springdata.customerdata.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
		customer.setId(1);
		customer.setName("Lucid");
		customer.setEmail("Lucid@Localhost.com");

		customerRepository.save(customer);
	}

	@Test
	public void testRead() {

		Customer customer = customerRepository.findById(1).get();
		assertNotNull(customer);
		assertNotEquals("Lucid", customer.getName());

	}

	@Test
	public void testUpdate() {

		Customer customer = customerRepository.findById(1).get();
		customer.setEmail("LucidLogic@locahost.com");
		customerRepository.save(customer);
	}

	@Test
	public void testDelete(){
		if(customerRepository.existsById(1)) {
			System.out.println("Deleting a product");
			customerRepository.deleteById(1);
		}

	}


	@Test
	public void testFindByEmailAndName() {
		List<Customer> customers = customerRepository.findByEmailAndName("BeyondLogic@Localhost.com", "BeyondLogic");
		customers.forEach(customer -> System.out.println("Customer with email : "
				+ customer.getEmail() + " name: " + customer.getName() + " is found in the database" ));
	}

	@Test
	public void testFindByIdIn() {
			Set<Customer> customers = customerRepository.findByIdIn(Set.of(1L,3L,4L));
		customers.forEach(customer -> System.out.println(customer.getName()));
	}

	@Rollback(value = false)
	@Transactional
	@Test
	public void testUpdateCustomerEmail(){

		customerRepository.updateCustomerEmail("Logic@Localhost",1L);

	}


	@Test
	public void testRegisterCustomer () {
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Anna");
		customer.setEmail("Anna@LocalHost.com");
		Address address = new Address();
		address.setStreetAddress("Phase 1");
		address.setCity("Highland");
		address.setState("Lagos");
		address.setCountry("Nigeria");
		address.setZipcode("300000");
		customer.setAddress(address);

		customerRepository.save(customer);
	}

}