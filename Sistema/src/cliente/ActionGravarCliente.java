package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import br.com.model.Cliente;
import sistema.LimparCampos;

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
		File file = new File(TelaCliente.txtCpf.getText()+".txt");
		if(file.exists()){
			JOptionPane.showMessageDialog(null,"CPF já existe!");

			//chamar a classe limpar campos
			new LimparCampos(cliente);
			
			TelaCliente.txtNCliente.setEditable(false);

		}

		// se não pode cadastrar novo 
		else {	
			String nome = TelaCliente.txtNCliente.getText();
			if (("").equals(nome)) {
				JOptionPane.showMessageDialog(null,"Preencha todos os Campos");
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
				JOptionPane.showMessageDialog(null,"Salvo");

				
				serializarCliente();

				//chamar a classe limpar campos
				new LimparCampos(cliente);
			
				TelaCliente.txtNCliente.setEditable(false);
				
			 

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
		return;
	}

	private void serializarCliente() throws FileNotFoundException, IOException {
		
		Cliente cliente = new Cliente();
				
		FileOutputStream fluxo;
		try {
			fluxo = new FileOutputStream("clientes.dat");
			ObjectOutputStream objarq = new ObjectOutputStream(fluxo);
			objarq.writeObject(cliente);
			objarq.close();
			System.out.println("Arquivo gravado");
		}catch (FileNotFoundException e ) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

