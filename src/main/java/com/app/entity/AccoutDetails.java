package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AccoutDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private int acntId;
	private String acntName;
	private String acntType;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private Customer customer;

	@JsonBackReference//No toString() method coz JSON Reference error
	@OneToMany(mappedBy = "accoutDetails", cascade = CascadeType.ALL)
	private List<TransactionHistory> transactionHistory = new ArrayList<TransactionHistory>();

	public AccoutDetails() {
	}

	public AccoutDetails(int acntId, String acntName, List<TransactionHistory> transactionHistory) {
		this.acntId = acntId;
		this.acntName = acntName;
		this.transactionHistory = transactionHistory;
	}

	public int getAcntId() {
		return acntId;
	}

	public void setAcntId(int acntId) {
		this.acntId = acntId;
	}

	public String getAcntName() {
		return acntName;
	}

	public void setAcntName(String acntName) {
		this.acntName = acntName;
	}

	public List<TransactionHistory> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(List<TransactionHistory> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public String getAcntType() {
		return acntType;
	}

	public void setAcntType(String acntType) {
		this.acntType = acntType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "AccoutDetails [acntId=" + acntId + ", acntName=" + acntName + ", acntType=" + acntType + ", customer="
				+ customer + "]";
	}

}
