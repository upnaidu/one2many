package com.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.TransactionHistory;

@Repository
public interface TransactionHistoryRepo extends CrudRepository<TransactionHistory, Long> {

}
