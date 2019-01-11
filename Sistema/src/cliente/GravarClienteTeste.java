package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import cliente.ClienteTeste;

public class GravarClienteTeste implements ActionListener {

	public GravarClienteTeste ( ClienteTeste cliTeste){
		this();
	}

	public GravarClienteTeste() {
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent e) {

		//verifica se cpf já existe
//		File file = new File(TelaCliente.txtCpf.getText()+".txt");
//		if(file.exists()){
//			JOptionPane.showMessageDialog(null,"CPF já existe!");

			//chamar a classe limpar campos
//			LimparCampos limparcampos = new LimparCampos(cliente);
//			limparcampos.getClass();
//
//		}

		// se não pode cadastrar novo 
//		else {	
//			String nome = TelaCliente.txtNCliente.getText();
//			if (("").equals(nome)) {
//				JOptionPane.showMessageDialog(null,"Digite o Nome");
//			}
//			else{
//			try {		
//				FileWriter gravar = new FileWriter(TelaCliente.txtCpf.getText()+".txt");
//				PrintWriter linha = new PrintWriter(gravar);			
//				linha.print(TelaCliente.txtCpf.getText() + "/");
//				linha.print(TelaCliente.txtNCliente.getText() + "/");
//				linha.print(TelaCliente.txtTelCliente.getText());
//				linha.flush();
//				linha.close();
//				gravar.close();
//				JOptionPane.showMessageDialog(null,"Salvo");
//				//chamar a classe limpar campos
//				LimparCampos limparcampos = new LimparCampos(cliente);
//				limparcampos.getClass();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
				
	
			//}
		//}
		//return;
	}
}
