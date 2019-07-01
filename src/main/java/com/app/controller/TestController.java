/**
 * 
 */
package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.AccoutDetails;
import com.app.entity.TransactionHistory;
import com.app.service.AccountDetailService;
import com.app.service.CustomerService;
import com.app.service.TransactionHistoryService;

/**
 * @author pentayya.u
 *
 */
@RestController
public class TestController {

	@Autowired
	private AccountDetailService accountDetailService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TransactionHistoryService transactionHistoryService;
	
	@PostMapping("/saveAccount/{name}")
	public int saveAccount(@PathVariable(value = "name") String name) {
		System.out.println("name ::" + name);
		return accountDetailService.saveAccountDetails(name);
	}

	@PostMapping("/saveCustomer/{custName}/{acntName}")
	public int saveCustomer(@PathVariable(value = "custName") String custName,
			@PathVariable(value = "acntName") String acntName) {
		System.out.println("custName ::" + custName + " acntName ::" + acntName);
		return customerService.saveCustomerDetails(custName, acntName);
	}

	@GetMapping("/findAll/{custId}")
	public List<AccoutDetails> fetchAllAccounts(@PathVariable(value = "custId") int custId) {

		List<AccoutDetails> accountsList = customerService.fetchAccountDetails(custId);
		System.out.println("accountsList size::" + accountsList.size());
		System.out.println("custId :"+custId);
		System.out.println("accntId :"+accountsList.get(0).getAcntId());
		System.out.println("accountsListObj :"+accountsList.get(0));
		
		
		TransactionHistory transhist = transactionHistoryService.fetchTransactionDetails(accountsList.get(0));
		System.out.println("transhist :"+transhist);
		System.out.println("transId :"+transhist.getTransId());

		for (AccoutDetails details : accountsList) {

			List<TransactionHistory> transhistdetails = details.getTransactionHistory();

			System.out.println("transhistdetails " + transhistdetails);
			System.out.println("transhistdetails getTransId " + transhistdetails.get(0).getTransId());

			for (TransactionHistory hist : transhistdetails) {
				System.out.println("transList:" + hist);
				System.out.println("transId ::" + hist.getTransId());

			}

		}


		return accountsList;
	}

}
