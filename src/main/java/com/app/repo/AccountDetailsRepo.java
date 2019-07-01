package com.app.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.AccoutDetails;
import com.app.entity.Customer;

public interface AccountDetailsRepo extends CrudRepository<AccoutDetails, Long> {

	List<AccoutDetails> findAllByCustomer(Customer customer);
}
