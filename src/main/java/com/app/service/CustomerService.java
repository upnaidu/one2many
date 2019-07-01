package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.AccoutDetails;
import com.app.entity.Customer;
import com.app.entity.TransactionHistory;
import com.app.repo.AccountDetailsRepo;
import com.app.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private AccountDetailsRepo accountDetailsRepo;

	public int saveCustomerDetails(String custName, String transName) {

		List<AccoutDetails> acntsList = new ArrayList<AccoutDetails>();
		List<TransactionHistory> transList = new ArrayList<TransactionHistory>();

		Customer customer = new Customer();
		// customer.setCustId(100);
		customer.setCustName(custName);
		customer.setLocation("CHN");
		customer.setAccoutDetails(acntsList);

		AccoutDetails accoutDetails = new AccoutDetails();
		// accoutDetails.setAcntId(2);
		accoutDetails.setAcntName("SBI");
		accoutDetails.setAcntType("Savings");
		accoutDetails.setCustomer(customer);

		acntsList.add(accoutDetails);
		accoutDetails.setTransactionHistory(transList);

		TransactionHistory transactionHistory = new TransactionHistory();
		// transactionHistory.setTransId(101);
		transactionHistory.setTransName(transName);
		transactionHistory.setAccoutDetails(accoutDetails);

		transList.add(transactionHistory);

		customerRepo.save(customer);
		System.out.println("Saved Successfully");
		return 0;
	}

	public List<AccoutDetails> fetchAccountDetails(int custId) {

		Customer custObj = customerRepo.findByCustId(custId);
		System.out.println("custObj " + custObj);
		List<AccoutDetails> acntsList = accountDetailsRepo.findAllByCustomer(custObj);
		System.out.println("acntsList " + acntsList);
		return acntsList;
	}

}
