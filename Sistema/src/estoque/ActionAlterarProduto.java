package estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import estoque.TelaEstoque;

public class ActionAlterarProduto implements ActionListener {
	@SuppressWarnings("unused")
	private TelaEstoque estoque;

	public ActionAlterarProduto (TelaEstoque estoque){
		this();
		this.estoque = estoque;
	}

	private ActionAlterarProduto() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {

		try {

			BufferedWriter writer;

			writer = new BufferedWriter(new FileWriter("estoqueTmp.txt"));

			BufferedReader reader = new BufferedReader(new FileReader("estoque.txt"));

			String  nome;
			while ((nome = reader.readLine()) != null) {
				if (nome.contains(TelaEstoque.txtConsulta.getText())) {
					nome = nome.replace(TelaEstoque.txtConsulta.getText(), "TROCOU");
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


