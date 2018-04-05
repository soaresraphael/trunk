/**
 * 
 */
package com.cminsurance.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author raphaelsoares
 *
 */
@ManagedBean (name = "defaultView")
@SessionScoped
public class DefaultView {
	
	public DefaultView() {
		// TODO Auto-generated constructor stub
	}
	
	public String backToIndex() {
		return "index";
	}

}
