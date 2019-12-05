package estoque;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import sistema.LimparCampos;

public class CliqueAlterar  {

	
	private TelaEstoque estoque;


	public CliqueAlterar (TelaEstoque estoque){
		this();
		this.estoque = estoque;
	}

	@SuppressWarnings("unlikely-arg-type")
	public CliqueAlterar (){

		String branco = null;
		
		if( !TelaEstoque.txtProduto.equals(branco)) {
			TelaEstoque.txtProduto.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
	
					//clique duplo
					if(e.getClickCount() == MouseEvent.BUTTON1){
	
						TelaEstoque.txtProduto.getText();
						System.out.println("teste");
						metodoAbrirCxDialogo();
						LimparCampos limparcampos = new LimparCampos(estoque);
						limparcampos.getClass();
					}
					
					}
				});
		}
		else  {
			System.out.println("teste");
		}
		
	}


	public   void metodoAbrirCxDialogo() {
		
			TelaEstoque.txtCodProduto.setEditable(true);
			TelaEstoque.txtProduto.setEditable(true);

			try {

				BufferedWriter writer;

				writer = new BufferedWriter(new FileWriter("estoqueTmp.txt"));

				BufferedReader reader = new BufferedReader(new FileReader("estoque.txt"));

				String  nome;
				while ((nome = reader.readLine()) != null) {
					if (nome.contains(TelaEstoque.txtProduto.getText())) {
						String showInputDialog = JOptionPane.showInputDialog(null, "Alterar Descrição do Produto" , "", 1);
						System.out.println(showInputDialog);
						nome = nome.replace(TelaEstoque.txtProduto.getText(), showInputDialog);
					}

					writer.write(nome + "\n");
				}

				writer.close();     
				reader.close();

		
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			new File("estoque.txt").delete();
			new File("estoqueTmp.txt").renameTo(new File("estoque.txt"));
		
	}
}






