package com.cminsurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="telephone")
public class Telephone {
	@Id
	@GeneratedValue
	private int telephoneId;
	private String telephoneType;
	private int telephoneNumber;
	private String countryCode;
	private int areaCode;
	private String type;
	private String operator;
	
	@ManyToOne
    @JoinColumn(name="id")
	private Customer customer;
	
	public Telephone() {
		// TODO Auto-generated constructor stub
	}

	public int getTelephoneId() {
		return telephoneId;
	}

	public void setTelephoneId(int telephoneId) {
		this.telephoneId = telephoneId;
	}

	public String getTelephoneType() {
		return telephoneType;
	}

	public void setTelephoneType(String telephoneType) {
		this.telephoneType = telephoneType;
	}

	public int getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
