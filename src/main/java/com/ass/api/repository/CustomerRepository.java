package com.ass.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ass.api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query("select c from Customer c where c.user.username=?1")
	Customer getCustomerDetails(String username);

}
