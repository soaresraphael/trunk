package estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ActionGravarProduto implements ActionListener {
	
	private TelaEstoque estoque;

	public ActionGravarProduto (TelaEstoque estoque){
		this();
		this.estoque = estoque;
	}
	
	public ActionGravarProduto() {
		// TODO Auto-generated constructor stub
	}

	
public void actionPerformed(ActionEvent e) {
				
				BufferedWriter bw = null;

		        try {
		            bw = new BufferedWriter(new FileWriter("estoque.txt", true));
		            bw.write(estoque.txtCodEstoque.getText()+";"+estoque.txtProduto.getText()+";"+
		            		estoque.txtQtdProduto.getText()+";"+estoque.txtValorProduto.getText()+";"+
		            		estoque.txtDataEntradaEstoque.getText()+";"+estoque.txtDataSaidaEstoque.getText()+";");
		            bw.newLine();
		            bw.flush();
		        	JOptionPane.showMessageDialog(null,"Salvo");
		        	
		        	estoque.txtCodEstoque.setText("");
		        	estoque.txtProduto.setText("");
		        	estoque.txtQtdProduto.setText("");
		        	estoque.txtValorProduto.setText("");
		        	estoque.txtDataEntradaEstoque.setText("");
		        	estoque.txtDataSaidaEstoque.setText("");
		        	estoque.txtCodEstoque.requestFocus();	
		         
		            
		        } catch (IOException ioe) {
		            ioe.printStackTrace();
		        } finally { // always close the file
		            if (bw != null) {
		                try {
		                    bw.close();
		                } catch (IOException ioe2) {
		                    // just ignore it
		                }
		            }
		        }


		        
		        
			}		
}
