package com.cminsurance.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerVO {
	@Id
	@GeneratedValue
	private long customerId;
	private String name;
	private String address;
	private String addressComplement;
	private String zipCode;
	private String city;
	private String state;
	private String email;
	private String cpf;
	private String document;
	private String birthDate;
	//private List<String> telephones;
	@OneToMany(mappedBy="customer", targetEntity=EnsurancePolicy.class, fetch = FetchType.LAZY)
	private List<EnsurancePolicy> ensurancePolicies;
	
	public CustomerVO() {
		// TODO Auto-generated constructor stub
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressComplement() {
		return addressComplement;
	}

	public void setAddressComplement(String addressComplement) {
		this.addressComplement = addressComplement;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getBirthDate() {
		return birthDate;
	}

	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/*
	public List<String> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<String> telephones) {
		this.telephones = telephones;
	}*/

	public List<EnsurancePolicy> getEnsurancePolicies() {
		return ensurancePolicies;
	}

	public void setEnsurancePolicies(List<EnsurancePolicy> ensurancePolicies) {
		this.ensurancePolicies = ensurancePolicies;
	}
	

}
