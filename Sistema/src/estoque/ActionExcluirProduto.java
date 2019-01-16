package estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ActionExcluirProduto implements ActionListener {
	
	private TelaEstoque estoque;

	public ActionExcluirProduto (TelaEstoque estoque){
		this();
		this.estoque = estoque;
	}
	
	public ActionExcluirProduto() {
		// TODO Auto-generated constructor stub
	}

	
	public void actionPerformed(ActionEvent arg0) {
		
			//var SL: TStringList;
			//begin
			//SL := TStringList.Create;
	
			try{

				
				int linha = TelaEstoque.tabEstoque.getSelectedRow();
				
				TelaEstoque.txtCodProduto.setText(TelaEstoque.tabEstoque.(linha,0).toString());

				
//				FileReader fr = new FileReader("estoque.txt");
//				fr.
//			    fr.Delete(0); // deleta a primeira linha
//			    fr.SaveTofile("estoque.txt");
//			  
				
				
				
				
				
//	            FileReader fr = new FileReader("cliente.txt");
//	            @SuppressWarnings("resource")
//				BufferedReader br = new BufferedReader(fr);
//	            
//	            String str;
//	            ArrayList<String> a = new ArrayList<>();
//	            
//	    		BufferedWriter al = null;
//
//	            while((str = br.readLine()) != null){
//	            	    
//	            		a.add(str);
//	            	    al = new BufferedWriter(new FileWriter("saida.txt", true));
//			 
//			            if(!str.equals(estoque.txtConsulta.getText())) {
//			            	al.write(str);
//				            al.newLine();
//				            al.flush();
//				        	}
//	            	} 
	        }
	        catch(IOException e){
	        System.out.println("não encontrado!");
			}
		}
	}

