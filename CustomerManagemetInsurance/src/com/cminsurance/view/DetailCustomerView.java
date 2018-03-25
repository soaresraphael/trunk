package com.cminsurance.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.TreeNode;

import com.cminsurance.model.CustomerVO;
import com.cminsurance.services.EnsurancePoliciesService;

@ManagedBean (name="detailCustomerView")
@SessionScoped
public class DetailCustomerView {
	
	CustomerVO customer;
	private TreeNode policiesTree;
	@ManagedProperty("#{ensurancePoliciesService}")
	private EnsurancePoliciesService service;
	
	public DetailCustomerView() {
		customer = new CustomerVO();
		service = new EnsurancePoliciesService();
		customer.setAddress("Rua Werner Goldberg, 157");
		customer.setAddressComplement("Apto 216A");
		customer.setBirthDate("23/03/1985");
		customer.setCity("Barueri");
		customer.setCpf("012.345.678-90");
		customer.setDocument("12.345.567-8");
		customer.setEmail("raphael.antenorsoares@gmail.com");
		customer.setEnsurancePolicies(getPoliciesList());
		customer.setId(1l);
		customer.setName("Raphael Antenor Soares");
		customer.setState("SP");
		customer.setTelephones(getTelephoneList());//TODO
		customer.setZipCode("06414025");
		policiesTree = service.createDocuments();
	}

	private List<String> getTelephoneList() {
		List <String> telephones = new ArrayList<String>();
		telephones.add("11 - 97103-2255");
		return telephones;
	}

	private List<Object> getPoliciesList() {
		// TODO Auto-generated method stub
		return null;
	}

	public TreeNode getPoliciesTree() {
		return policiesTree;
	}

	public void setPoliciesTree(TreeNode policiesTree) {
		this.policiesTree = policiesTree;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public EnsurancePoliciesService getService() {
		return service;
	}

	public void setService(EnsurancePoliciesService service) {
		this.service = service;
	}
	
}
