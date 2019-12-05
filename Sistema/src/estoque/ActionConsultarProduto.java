package estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sistema.LimparCampos;

public class ActionConsultarProduto implements ActionListener, KeyListener{
	
	
	

	private TelaEstoque estoque;

	public ActionConsultarProduto (TelaEstoque estoque){
		this();
		this.estoque = estoque;
	}

	public ActionConsultarProduto() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {

		metodoPesquisa();

	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){ 
			metodoPesquisa();
			}
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void metodoPesquisa() {
		String con = TelaEstoque.txtConsulta.getText();
		if( con == null || "".equals(con) ){
			JOptionPane.showMessageDialog(null,"Preencher o Campo Consulta");
		}
		else {			
			try {  				
				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader(  
						"estoque.txt")); 

				DefaultTableModel modelo = (DefaultTableModel)TelaEstoque.tabEstoque.getModel();

				modelo.setNumRows(0);

				String linha = ""; 

				while ((linha = reader.readLine()) != null) { 

					if (estoque.Combo.getSelectedIndex() == 0) {
						if(linha.contains(TelaEstoque.txtConsulta.getText())) {
							modelo.addRow(linha.split(","));
							System.out.println(linha);
						}
					}
					else if (estoque.Combo.getSelectedIndex() == 1){
						if (linha.equals(TelaEstoque.txtConsulta.getText())) {
							modelo.addRow(linha.split(","));
							System.out.println(linha);				
						}				
					}
				}
				//chamar a classe limpar campos
				new LimparCampos(estoque);

			} catch (IOException e1 ) {  
				JOptionPane.showMessageDialog(null, "Não Cadastrado");
				e1.printStackTrace();  
			}

		}
	}

}
