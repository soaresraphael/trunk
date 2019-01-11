package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;

import cliente.TelaCliente;

public class ActionExcluirCliente implements ActionListener {
	
	@SuppressWarnings("unused")
	private TelaCliente cliente;

	public ActionExcluirCliente (TelaCliente cliente){
		this();
		this.cliente = cliente;
	}
	
	public ActionExcluirCliente() {
		// TODO Auto-generated constructor stub
	}

	
	public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Excluindo Arquivo", JOptionPane.YES_NO_OPTION);

			File del = new File(TelaCliente.txtCpf.getText()+".txt");
			if(del.exists()){
		  
				TelaCliente.txtCpf.requestFocus();
				del.delete();
				
				//remove linha tabela
				//TODO
//				((DefaultTableModel) cliente.tabCliente.getModel()).removeRow(cliente.tabCliente.getSelectedRow());
				//cursor voltar piscando cpf e limpa os campos
				TelaCliente.txtCpf.setText("");
				TelaCliente.txtNCliente.setText("");
				TelaCliente.txtTelCliente.setText("");
				TelaCliente.txtCpf.requestFocus();					
				}
		}
}
