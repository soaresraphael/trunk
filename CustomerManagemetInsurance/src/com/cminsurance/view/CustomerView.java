/**
 * 
 */
package com.cminsurance.view;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.TreeNode;

import com.cminsurance.model.Customer;
import com.cminsurance.model.EnsurancePolicy;
import com.cminsurance.services.EnsurancePoliciesService;

/**
 * @author raphaelsoares
 *
 */
@ManagedBean (name= "customerBean")
@SessionScoped
public class CustomerView extends DefaultView{
	
	private Customer customer;
	private TreeNode policiesTree;
	@ManagedProperty("#{ensurancePoliciesService}")
	private EnsurancePoliciesService service;
	
	public CustomerView() {
		customer = new Customer();
		customer.setEnsurancePolicies(new ArrayList<EnsurancePolicy>());
		service = new EnsurancePoliciesService();
		policiesTree = service.createDocuments();		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
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
