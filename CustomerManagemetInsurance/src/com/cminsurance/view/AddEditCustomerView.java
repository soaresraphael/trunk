/**
 * 
 */
package com.cminsurance.view;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cminsurance.controller.DBController;
import com.cminsurance.model.Customer;

/**
 * @author raphaelsoares
 *
 */
@ManagedBean (name="addEditCustomerView")
public class AddEditCustomerView {
	
	Customer customer;
	DBController controller = null;

	public AddEditCustomerView() {
		this.customer = new Customer();
		this.controller = new DBController();
	}
	
	
	public void teste(ActionEvent event) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit_app");
	    EntityManager em = factory.createEntityManager();
	}
	
	public void insertCustomer(ActionEvent event) {
		if (customer.getName() != null && !customer.getName().isEmpty()) {
			controller.saveCustomer(customer);
		} else {
			//TODO add modal message.
		}
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
