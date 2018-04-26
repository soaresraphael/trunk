/**
 * 
 */
package com.cminsurance.view;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author raphaelsoares
 *
 */
@ManagedBean (name="addEditCustomerView")
public class AddEditCustomerView {

	public AddEditCustomerView() {
	}
	
	public void teste(ActionEvent event) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit_app");
	    EntityManager em = factory.createEntityManager();
	}
}
