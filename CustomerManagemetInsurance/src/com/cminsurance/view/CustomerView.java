/**
 * 
 */
package com.cminsurance.view;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.TreeNode;

import com.cminsurance.model.CustomerVO;
import com.cminsurance.services.EnsurancePoliciesService;

/**
 * @author raphaelsoares
 *
 */
@ManagedBean (name= "customerBean")
@SessionScoped
public class CustomerView {
	
	private CustomerVO customer;
	private TreeNode policiesTree;
	@ManagedProperty("#{ensurancePoliciesService}")
	private EnsurancePoliciesService service;
	
	public CustomerView() {
		customer = new CustomerVO();
		customer.setEnsurancePolicies(new ArrayList<Object>());
		service = new EnsurancePoliciesService();
		policiesTree = service.createDocuments();		
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public TreeNode getPoliciesTree() {
		return policiesTree;
	}

	public void setPoliciesTree(TreeNode policiesTree) {
		this.policiesTree = policiesTree;
	}

	public EnsurancePoliciesService getService() {
		return service;
	}

	public void setService(EnsurancePoliciesService service) {
		this.service = service;
	}
	
	
}
