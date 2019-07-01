package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private int custId;
	private String custName;
	private String location;

	@JsonBackReference//No toString() method coz JSON Reference error
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<AccoutDetails> accoutDetails = new ArrayList<AccoutDetails>();

	public Customer() {
	}

	public Customer(int custId, String custName, String location, List<AccoutDetails> accoutDetails) {
		this.custId = custId;
		this.custName = custName;
		this.location = location;
		this.accoutDetails = accoutDetails;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<AccoutDetails> getAccoutDetails() {
		return accoutDetails;
	}

	public void setAccoutDetails(List<AccoutDetails> accoutDetails) {
		this.accoutDetails = accoutDetails;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", location=" + location + "]";
	}

}
