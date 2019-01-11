package vendas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import vendas.TelaVendas;
import sistema.LimparCampos;


public class ActionConsultarVenda implements ActionListener {

	private TelaVendas vendas;

	public ActionConsultarVenda (TelaVendas vendas){
		this();
		this.vendas = vendas;
	}

	public ActionConsultarVenda() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		
		String con = TelaVendas.txtConsultaVendas.getText();
		if( con == null || "".equals(con)){
			JOptionPane.showMessageDialog(null,"Preencher o Campo Consulta");
		}
		else {			
			try {  				
						@SuppressWarnings("resource")
						BufferedReader reader = new BufferedReader(new FileReader(  
								"venda.txt")); 


						DefaultTableModel addV = (DefaultTableModel) TelaVendas.tabVendas.getModel();


						String linha = ""; 

								while ((linha = reader.readLine()) != null) { 
																													
									if (TelaVendas.Combo.getSelectedIndex() == 0) {
										if(linha.contains(TelaVendas.txtConsultaVendas.getText())) {
											addV.addRow(linha.split(","));
										System.out.println(linha);
										}
									}
									else if (TelaVendas.Combo.getSelectedIndex() == 1){
										if (linha.equals(TelaVendas.txtConsultaVendas.getText())) {
											addV.addRow(linha.split(","));
											System.out.println(linha);				
										}				
									}
								}
								TelaVendas.txtConsultaVendas.requestFocus();
																

				} catch (IOException e1 ) {  
					JOptionPane.showMessageDialog(null, "Não Cadastrado");
				
					//chamar a classe limpar campos
					LimparCampos limparcampos = new LimparCampos(vendas);
					limparcampos.getClass();
	

				}

		}
	
}
}
		