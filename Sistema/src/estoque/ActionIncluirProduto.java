package estoque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ActionIncluirProduto implements ActionListener {
	
	private TelaEstoque estoque;

	public ActionIncluirProduto (TelaEstoque estoque){
		this();
		this.estoque = estoque;
	}
	
	public ActionIncluirProduto() {
		// TODO Auto-generated constructor stub
	}

	
public void actionPerformed(ActionEvent e) {
				
	//adiciona dados
	String CodProduto = TelaEstoque.txtCodProduto.getText().trim();
	String Produto = TelaEstoque.txtProduto.getText().trim();
	String Quantidade = TelaEstoque.txtQtdProduto.getText().trim();
	String Valor = TelaEstoque.txtValorProduto.getText().trim();
	String DataEntrada = TelaEstoque.txtDataEntradaEstoque.getText().trim();
	String DataSaida = TelaEstoque.txtDataSaidaEstoque.getText().trim();

	DefaultTableModel add = (DefaultTableModel) estoque.tabEstoque.getModel();
	add.addRow(new String[] {CodProduto, Produto, Quantidade, Valor, DataEntrada, DataSaida});
				
	TelaEstoque.txtCodProduto.setText("");
	TelaEstoque.txtProduto.setText("");
	TelaEstoque.txtQtdProduto.setText("");
	TelaEstoque.txtValorProduto.setText("");
	TelaEstoque.txtDataEntradaEstoque.setText("");
	TelaEstoque.txtDataSaidaEstoque.setText("");
	
	TelaEstoque.txtCodProduto.requestFocus();
}
}
