package com.cminsurance.view;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "layoutViewBean")
@SessionScoped
public class LayoutView {
	private String content = "/customers.xhtml";

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
