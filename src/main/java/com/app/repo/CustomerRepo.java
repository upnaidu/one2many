package com.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

	Customer findByCustId(int custId);

}
