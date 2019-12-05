package estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class ActionExcluirProduto implements ActionListener {
	@SuppressWarnings("unused")
	private TelaEstoque estoque;

	public ActionExcluirProduto (TelaEstoque estoque){
		this();
		this.estoque = estoque;
	}
		
		public ActionExcluirProduto() {
		// TODO Auto-generated constructor stub
	}

		
		public void actionPerformed(ActionEvent e) {
		
			try {
					OutputStream bytes = new FileOutputStream("estoque.txt", true);
					OutputStreamWriter chars = new OutputStreamWriter(bytes);
					BufferedWriter strings = new BufferedWriter(chars);
					
					BufferedReader reader = new BufferedReader(new FileReader(  
							"estoque.txt"));
					
				
					
					String line = "";
					while ((line = reader.readLine())!= null) {
						
						if (line.contains(TelaEstoque.txtCodProduto.getText())) {
							//chars.write("\r\n\tttttttttttttttttt");
							line = line.replace(TelaEstoque.txtCodProduto.getText(),"\r\n" );
						}
						strings.write(line+"\r\n");
											  
					reader.close();
					strings.close();
					}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {}
			
		}
}


		
//		OutputStream bytes = new FileOutputStream("saida.txt", true);
//		OutputStreamWriter chars = new OutputStreamWriter(bytes);
//		BufferedWriter strings = new BufferedWriter(chars);
//		
//		@SuppressWarnings("resource")
//		BufferedReader reader = new BufferedReader(new FileReader(  
//				"saida.txt"));
//		
//		
//		String line = "";
//		while ((line = reader.readLine())!= null) {
//			
//			if (line.contains("1")) {
//				//chars.write("\r\n\tttttttttttttttttt");
//				line = line.replace("1","\r\n" );
//				
//			}
//			strings.write(line);
//
//		}
//		  
//		reader.close();
//		strings.close();
		

	

