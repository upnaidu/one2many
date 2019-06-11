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
import com.app.service.AccountDetailService;

/**
 * @author pentayya.u
 *
 */
@RestController
public class TestController {

	@Autowired
	private AccountDetailService accountDetailService;

	@PostMapping("/saveAccount/{name}")
	public int saveAccounts(@PathVariable(value = "name") String name) {
		System.out.println("name ::" + name);
		return accountDetailService.saveAccountDetails(name);
	}

	@GetMapping("/findAll")
	public List<AccoutDetails> fetchAllAccounts() {
		return accountDetailService.fetchAllAccounts();
	}

}
