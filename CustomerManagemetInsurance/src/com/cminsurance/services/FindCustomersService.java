/**
 * 
 */
package com.cminsurance.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.cminsurance.model.CustomerVO;

/**
 * @author raphaelsoares
 *
 */
@ManagedBean (name = "customerService")
@ApplicationScoped
public class FindCustomersService {

	public List<CustomerVO> createCustomers() {
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		long id = 1l;
		
		for (int i=0; i<50; i++) {
			CustomerVO customer = new CustomerVO();
			customer.setAddress("Rua Werner Goldberg, 157");
			customer.setAddressComplement("Apto 216A");
			customer.setBirthDate("23/03/1985");
			customer.setCity("Barueri");
			customer.setCpf("012.345.678-90");
			customer.setDocument("12.345.567-8");
			customer.setEmail("raphael.antenorsoares@gmail.com");
			customer.setId(id);
			customer.setName("Raphael Antenor Soares");
			customer.setState("SP");
			customer.setZipCode("06414025");
			list.add(customer);
		}
		
		return list;
	}

	public List<CustomerVO> createCustomers(String name, String cpfCnpj) {
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		long id = 3l;
		String customerName = "Raphael Antenor Soares";
		String cpf = "012.345.678-90";
		if(name != null && !name.isEmpty()) {
			customerName = name;
		}
		
		if(cpfCnpj != null && !cpfCnpj.isEmpty()) {
			cpf = cpfCnpj;
		}
		
		CustomerVO customer = new CustomerVO();
		customer.setAddress("Rua Werner Goldberg, 157");
		customer.setAddressComplement("Apto 216A");
		customer.setBirthDate("23/03/1985");
		customer.setCity("Barueri");
		customer.setCpf(cpf);
		customer.setDocument("12.345.567-8");
		customer.setEmail("raphael.antenorsoares@gmail.com");
		customer.setId(id);
		customer.setName(customerName);
		customer.setState("SP");
		customer.setZipCode("06414025");
		list.add(customer);
		return list;
	}

	
}
