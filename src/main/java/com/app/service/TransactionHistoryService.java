package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.AccoutDetails;
import com.app.entity.TransactionHistory;
import com.app.repo.TransactionHistoryRepo;

@Service
public class TransactionHistoryService {

	@Autowired
	private TransactionHistoryRepo transactionHistoryRepo;

	public TransactionHistory fetchTransactionDetails(AccoutDetails accoutDetails) {

		return transactionHistoryRepo.findByAccoutDetails(accoutDetails);
	}

}
