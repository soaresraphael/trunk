package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import sistema.LimparCampos;

public class ActionAlterarCliente implements ActionListener {
	
	
	public void LimparCampos() {
		//chamar a classe limpar campos e cursor voltar piscando cpf
		LimparCampos limparcampos = new LimparCampos(cliente);
		limparcampos.getClass();			
	}

	@SuppressWarnings("unused")
	private TelaCliente cliente;

	public ActionAlterarCliente (TelaCliente cliente){
		this();
		this.cliente = cliente;
	}

	public ActionAlterarCliente() {
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e) {
		
		
		File file = new File(TelaCliente.txtCpf.getText()+".txt");
		if(!file.exists()){
		JOptionPane.showMessageDialog(null,"CPF: "+TelaCliente.txtCpf.getText()+"\r\n Não existe e não pode ser Alterado");
		//chamar a classe limpar campos e cursor voltar piscando cpf
		LimparCampos();

		}
		else{
		
		String nome = TelaCliente.txtNCliente.getText();
		if (("").equals(nome)) {
			JOptionPane.showMessageDialog(null,"Clique em pesquisar");
		}
		
		else{
			try {		
			FileWriter gravar = new FileWriter(TelaCliente.txtCpf.getText()+".txt");
			PrintWriter linha = new PrintWriter(gravar);			
			linha.print(TelaCliente.txtCpf.getText() + "/");
			linha.print(TelaCliente.txtNCliente.getText() + "/");
			linha.print(TelaCliente.txtTelCliente.getText());
			linha.flush();
			linha.close();
			gravar.close();
			JOptionPane.showMessageDialog(null,"Alterado");
			
			LimparCampos();
			TelaCliente.txtNCliente.setEditable(false);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
	}
}
