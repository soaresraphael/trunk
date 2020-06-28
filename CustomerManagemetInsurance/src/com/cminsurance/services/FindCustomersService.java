/**
 * 
 */
package com.cminsurance.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.cminsurance.model.Customer;

/**
 * @author raphaelsoares
 *
 */
@ManagedBean (name = "customerService")
@ApplicationScoped
public class FindCustomersService {

	public List<Customer> createCustomers() {
		List<Customer> list = new ArrayList<Customer>();
		long id = 1l;
		
		for (int i=0; i<50; i++) {
			Customer customer = new Customer();
			customer.setAddress("Rua Werner Goldberg, 157");
			customer.setAddressComplement("Apto 216A");
			customer.setBirthDate("23/03/1985");
			customer.setCity("Barueri");
			customer.setCpf("012.345.678-90");
			customer.setDocument("12.345.567-8");
			customer.setEmail("raphael.antenorsoares@gmail.com");
			customer.setCustomerId(id);
			customer.setName("Raphael Antenor Soares");
			customer.setState("SP");
			customer.setZipCode("06414025");
			list.add(customer);
		}
		
		return list;
	}

	public List<Customer> createCustomers(String name, String cpfCnpj) {
		List<Customer> list = new ArrayList<Customer>();
		long id = 3l;
		String customerName = "Raphael Antenor Soares";
		String cpf = "012.345.678-90";
		if(name != null && !name.isEmpty()) {
			customerName = name;
		}
		
		if(cpfCnpj != null && !cpfCnpj.isEmpty()) {
			cpf = cpfCnpj;
		}
		
		Customer customer = new Customer();
		customer.setAddress("Rua Werner Goldberg, 157");
		customer.setAddressComplement("Apto 216A");
		customer.setBirthDate("23/03/1985");
		customer.setCity("Barueri");
		customer.setCpf(cpf);
		customer.setDocument("12.345.567-8");
		customer.setEmail("raphael.antenorsoares@gmail.com");
		customer.setCustomerId(id);
		customer.setName(customerName);
		customer.setState("SP");
		customer.setZipCode("06414025");
		list.add(customer);
		return list;
	}

	
}
