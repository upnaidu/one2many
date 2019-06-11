package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private int transId;
	private String transName;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private AccoutDetails accoutDetails;

	public TransactionHistory() {
	}

	public TransactionHistory(int transId, String transName, AccoutDetails accoutDetails) {
		this.transId = transId;
		this.transName = transName;
		this.accoutDetails = accoutDetails;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public String getTransName() {
		return transName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public AccoutDetails getAccoutDetails() {
		return accoutDetails;
	}

	public void setAccoutDetails(AccoutDetails accoutDetails) {
		this.accoutDetails = accoutDetails;
	}

	@Override
	public String toString() {
		return "TransactionHistory [transId=" + transId + ", transName=" + transName + ", accoutDetails="
				+ accoutDetails + "]";
	}

}
