package com.cminsurance.view;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean(name="headerView")
public class HeaderView {
	
	public String getLink() {
		return "/atividade.xhtml";
	}

}
