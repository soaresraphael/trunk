package vendas;

public class PedVendas {

	public String CodVenda;
	public String Cliente;
	public String Produto;
	public String Quantidade;
	public String Valor;
	public String DataVenda;

	public String getCodVenda() {
		if (!TelaVendas.txtCodVenda.getText().equals("") && TelaVendas.txtCodVenda.getText() != null)
			CodVenda = TelaVendas.txtCodVenda.getText();
		return CodVenda;
	}
	public void setCodVenda(String txtCodVenda) {
		this.CodVenda = txtCodVenda;
	}
	
	public String getCliente() {
		if (!TelaVendas.txtCliente.getText().equals("") && TelaVendas.txtCliente.getText() != null)
			Cliente = TelaVendas.txtCliente.getText();
		return Cliente;
	}

	public void setCliente(String txtCliente) {
		this.Cliente = txtCliente;
	}

	public String getProduto() {
		if (!TelaVendas.txtProduto.getText().equals("") && TelaVendas.txtProduto.getText() != null)
			Produto = TelaVendas.txtProduto.getText();
		return Produto;
	}
	
	public void setProduto(String txtProduto) {
		this.Produto = txtProduto;
	}
	
	public String getQuantidade() {
		if (!TelaVendas.txtQtdProduto.getText().equals("") && TelaVendas.txtQtdProduto.getText() != null)
			Quantidade = TelaVendas.txtQtdProduto.getText();
		return Quantidade;
	}
	public void setQuantidade(String txtQtdProduto) {
		this.Quantidade = txtQtdProduto;
	}
	
	public String getValor() {
		if (!TelaVendas.txtQtdProduto.getText().equals("") && TelaVendas.txtQtdProduto.getText() != null)
			Valor = TelaVendas.txtQtdProduto.getText();
		return Valor;
	}
	
	public void setValor(String Valor) {
		this.Valor = Valor;
	}
		
	public String getDataVenda() {
		if (!TelaVendas.txtDataVenda.getText().equals("") && TelaVendas.txtDataVenda.getText() != null)
			DataVenda = TelaVendas.txtDataVenda.getText();
		return DataVenda;
	}
	
	public void setDataVenda(String DataVenda) {
		this.DataVenda = DataVenda;
	}

//	@Override
//	public String toString() {
//		return "{ Vendas [Codigo Venda= "+CodVenda+",\r\n Cliente = " + Cliente + 
//				",\r\n Quantidade = " + Quantidade + ",\r\n Valor = " + Valor +
//				",\r\n Produto = " + Produto+ ",\r\n Data da Venda = "+ DataVenda + "]\r\n}";
//	}
	
	@Override
	public String toString() {
		return CodVenda + "," +Cliente+ "," +Quantidade+ "," +Valor+ "," +Produto+ "," +DataVenda;
	}	
	
	
}
