package br.com.model;

import javax.swing.JInternalFrame;

public class Teste extends JInternalFrame {

	    private static final long serialVersionUID = -619850559630326110L;

	    public Teste() {
	        super("Usuários", true, true, true, true);

	        this.setSize(500, 300);

	        this.setLocation(30, 30);
	    }
	}