/**
 * 
 */
package com.cminsurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author raphaelsoares
 *
 */
@Entity
@Table(name="ensurancePolicy")
public class EnsurancePolicy {
	 	
		private String name;
	 	
	 	@Id
		@GeneratedValue
		private int policyId;
	    private String size;
	    private String type;
	    
	    @ManyToOne
	    @JoinColumn(name="id")
		private Customer customer;
	     
	    public EnsurancePolicy(String name, String size, String type) {
	        this.name = name;
	        this.size = size;
	        this.type = type;
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPolicyId() {
			return policyId;
		}

		public void setPolicyId(int policyId) {
			this.policyId = policyId;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
	    
}
