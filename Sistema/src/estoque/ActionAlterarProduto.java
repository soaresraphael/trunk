package estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import sistema.LimparCampos;

public class ActionAlterarProduto implements ActionListener {
	private TelaEstoque estoque;

	public ActionAlterarProduto (TelaEstoque estoque){
		this();
		this.estoque = estoque;
	}

	ActionAlterarProduto() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		
		TelaEstoque.txtCodProduto.setEditable(true);
		TelaEstoque.txtProduto.setEditable(true);

		try {

			BufferedWriter writer;

			writer = new BufferedWriter(new FileWriter("estoqueTmp.txt"));

			BufferedReader reader = new BufferedReader(new FileReader("estoque.txt"));

			String  nome;
			while ((nome = reader.readLine()) != null) {
				if (nome.contains(TelaEstoque.txtProduto.getText())) {
					String showInputDialog = JOptionPane.showInputDialog(null, "Alteração Dados" , "", 1);
					System.out.println(showInputDialog);
					nome = nome.replace(TelaEstoque.txtProduto.getText(), showInputDialog);
				}
//				else if (nome.contains(TelaEstoque.txtValorProduto.getText())){
//					String showInputDialog = JOptionPane.showInputDialog(null, "Alteração Dados" , "", 1);
//					System.out.println(showInputDialog);
//					nome = nome.replace(TelaEstoque.txtValorProduto.getText(), showInputDialog);
//				}
				
				writer.write(nome + "\n");
			}

			writer.close();     
			reader.close();
			
			LimparCampos limparcampos = new LimparCampos(estoque);
			limparcampos.getClass();
		

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		new File("estoque.txt").delete();
		new File("estoqueTmp.txt").renameTo(new File("estoque.txt"));
	}
}


