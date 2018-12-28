package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class ActionGravarCliente implements ActionListener {
	
	private TelaCliente cliente;

	public ActionGravarCliente (TelaCliente cliente){
		this();
		this.cliente = cliente;
	}
	
	public ActionGravarCliente() {
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e) {
		
		//verifica se cpf já existe
		File file = new File(cliente.txtCpf.getText()+".txt");
		if(file.exists()){
			JOptionPane.showMessageDialog(null,"CPF já existe!");
			cliente.txtCpf.setText("");
			cliente.txtNCliente.setText("");
			cliente.txtTelCliente.setText("");
			cliente.txtCpf.requestFocus();
		}
		
		// se não pode cadastrar novo 
		else {	
			try {		
				FileWriter gravar = new FileWriter(cliente.txtCpf.getText()+".txt");
				PrintWriter linha = new PrintWriter(gravar);			
				linha.print(cliente.txtCpf.getText() + "/");
				linha.print(cliente.txtNCliente.getText() + "/");
				linha.print(cliente.txtTelCliente.getText());
				linha.flush();
				linha.close();
				gravar.close();
				JOptionPane.showMessageDialog(null,"Salvo");
				cliente.txtCpf.setText("");
				cliente.txtNCliente.setText("");
				cliente.txtTelCliente.setText("");
				cliente.txtCpf.requestFocus();												
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return;
	}
}
	