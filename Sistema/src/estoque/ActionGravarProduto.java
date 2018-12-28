package estoque;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

import sistema.LimparCampos;

public class ActionGravarProduto implements ActionListener {

	
	@SuppressWarnings("unused")
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

			Produto produto = new Produto();
			produto.setCodProduto(TelaEstoque.txtCodProduto.getText());
			produto.setDescricao(TelaEstoque.txtProduto.getText());
			produto.setQuantidade(TelaEstoque.txtQtdProduto.getText());
			produto.setValor(TelaEstoque.txtValorProduto.getText());
			produto.setDataentrada(TelaEstoque.txtDataEntradaEstoque.getText());
			produto.setDatasaida(TelaEstoque.txtDataSaidaEstoque.getText());

			bw.write(produto.toString());
			bw.newLine();
			bw.flush();
			JOptionPane.showMessageDialog(null,"Salvo");
			
			//chamar a classe limpar campos
			LimparCampos limparcampos = new LimparCampos(estoque);
			limparcampos.getClass();

			
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


