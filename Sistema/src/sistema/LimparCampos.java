package sistema;

import javax.swing.table.DefaultTableModel;

import cliente.TelaCliente;
import estoque.TelaEstoque;
import vendas.TelaVendas;

public class LimparCampos  {
	
	private DefaultTableModel limpatabela;
	
	public LimparCampos (TelaVendas vendas){
		//limpar os campos vendas e colocar cursor na codVenda
		TelaVendas.txtCodVenda.setText("");
		TelaVendas.txtCliente.setText("");
		TelaVendas.txtProduto.setText("");
		TelaVendas.txtQtdProduto.setText("");
		TelaVendas.txtValorProduto.setText("");
		TelaVendas.txtCodVenda.requestFocus();
	}

	public LimparCampos (TelaCliente Cliente){
		//limpar os campos cliente e colocar cursor na codcpf
		TelaCliente.txtCpf.setText("");
		TelaCliente.txtNCliente.setText("");
		TelaCliente.txtTelCliente.setText("");
		//limpa tabela
		limpatabela = (DefaultTableModel)TelaCliente.tabCliente.getModel();
		limpatabela.setNumRows(0);
		TelaCliente.txtCpf.requestFocus();
		}

	public  LimparCampos (TelaEstoque estoque) {
		//limpar os campos estoque e colocar cursor na codproduto
		TelaEstoque.txtConsulta.setText("");
		TelaEstoque.txtCodProduto.setText("");
		TelaEstoque.txtProduto.setText("");
		TelaEstoque.txtQtdProduto.setText("");
		TelaEstoque.txtValorProduto.setText("");
		TelaEstoque.txtDataEntradaEstoque.setText("");
		TelaEstoque.txtDataSaidaEstoque.setText("");
		TelaEstoque.txtCodProduto.requestFocus();	
	}
	

}

