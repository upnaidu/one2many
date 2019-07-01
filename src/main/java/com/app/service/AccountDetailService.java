package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.AccoutDetails;
import com.app.entity.TransactionHistory;
import com.app.repo.AccountDetailsRepo;

@Service
public class AccountDetailService {

	@Autowired
	private AccountDetailsRepo accountDetailsRepo;

	public int saveAccountDetails(String custName) {

		List<TransactionHistory> transList = new ArrayList<TransactionHistory>();

		AccoutDetails accoutDetails = new AccoutDetails();
		// accoutDetails.setAcntId(2);
		accoutDetails.setAcntName("SBI");

		accoutDetails.setTransactionHistory(transList);

		TransactionHistory transactionHistory = new TransactionHistory();
		// transactionHistory.setTransId(101);
		transactionHistory.setTransName(custName);
		transactionHistory.setAccoutDetails(accoutDetails);

		transList.add(transactionHistory);

		accountDetailsRepo.save(accoutDetails);
		System.out.println("Saved Successfully");
		return 0;
	}

	public List<AccoutDetails> fetchAllAccounts() {

		return (List<AccoutDetails>) accountDetailsRepo.findAll();
	}
}
