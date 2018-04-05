/**
 * 
 */
package com.cminsurance.view;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.cminsurance.model.CustomerVO;
import com.cminsurance.services.FindCustomersService;


/**
 * @author raphaelsoares
 *
 */
@ManagedBean (name = "findCustomerView")
@SessionScoped
public class FindCustomersView extends DefaultView{
	
	List<CustomerVO> customers;
	List<CustomerVO> filteredCustomers;
	@ManagedProperty("#{customerService}")
	FindCustomersService service;
	String name;
	String cpfCnpj;
	private boolean renderTable;
	
	public FindCustomersView() {
		renderTable = false;
	}
	
	@PostConstruct
	public void init() {
		customers = service.createCustomers();
	}
	
	public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }
	
	public void findCustomers(ActionEvent event) {
		renderTable = true;
		if(name.isEmpty() && cpfCnpj.isEmpty()) {
			customers = service.createCustomers();
		} else {
			customers = service.createCustomers(name, cpfCnpj);
		}
	}
	
	public String detailCustomer() {
		return "detailCustomer";
	}

	public List<CustomerVO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerVO> customers) {
		this.customers = customers;
	}

	public List<CustomerVO> getFilteredCustomers() {
		return filteredCustomers;
	}

	public void setFilteredCustomers(List<CustomerVO> filteredCustomers) {
		this.filteredCustomers = filteredCustomers;
	}

	public FindCustomersService getService() {
		return service;
	}

	public void setService(FindCustomersService service) {
		this.service = service;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public boolean isRenderTable() {
		return renderTable;
	}

	public void setRenderTable(boolean renderTable) {
		this.renderTable = renderTable;
	}
	
}
