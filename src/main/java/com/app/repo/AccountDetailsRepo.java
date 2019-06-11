package com.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.AccoutDetails;

public interface AccountDetailsRepo extends CrudRepository<AccoutDetails, Long> {

}
