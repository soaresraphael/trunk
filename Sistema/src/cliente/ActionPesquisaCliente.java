package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import cliente.TelaCliente;


public class ActionPesquisaCliente implements ActionListener {

	public ActionPesquisaCliente (TelaCliente cliente){
		this();
	}

	public ActionPesquisaCliente() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {

		String cpf = TelaCliente.txtCpf.getText();


		if( cpf == null || "   .   .   -  ".equals(cpf) ){
			JOptionPane.showMessageDialog(null,"Preencher o Campo CPF");
		}

		else {			
			try {  

				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader(  
						cpf+".txt"));  
				DefaultTableModel modelo = (DefaultTableModel) TelaCliente.tabCliente.getModel();  
				modelo.setNumRows(0);  
				TelaCliente.tabCliente.setModel(modelo);  
				String linha = "";  
				while ((linha = reader.readLine()) != null) {  
					modelo.addRow(linha.split("/"));  
				}  
				TelaCliente.txtCpf.requestFocus();
			} catch (IOException e1 ) {  
				JOptionPane.showMessageDialog(null, "Não Cadastrado");
				TelaCliente.txtCpf.setText("");
				TelaCliente.txtNCliente.setText("");
				TelaCliente.txtTelCliente.setText("");
				TelaCliente.txtCpf.requestFocus();

				//e.printStackTrace();  
			}


		}


	}
}



