package estoque;

public class Produto {
	
	public String codProduto;
	public String dataentrada;
	public String datasaida;
	public String descricao;
	public String quantidade;
	public String valor;
	
	public String getCodProduto() {
		if (!TelaEstoque.txtCodProduto.getText().equals("") && TelaEstoque.txtCodProduto.getText() != null)
			codProduto = TelaEstoque.txtCodProduto.getText();
		return codProduto;
	}
	public void setCodProduto(String txtCodProduto) {
		this.codProduto = txtCodProduto;
	}
	
	public String getDataentrada() {
		if (!TelaEstoque.txtDataEntradaEstoque.getText().equals("") && TelaEstoque.txtDataEntradaEstoque.getText() != null)
			dataentrada = TelaEstoque.txtDataEntradaEstoque.getText();
		return dataentrada;
	}
	public void setDataentrada(String dataentrada) {
		this.dataentrada = dataentrada;
	}
	
	public String getDatasaida() {
		if (!TelaEstoque.txtDataSaidaEstoque.getText().equals("") && TelaEstoque.txtDataSaidaEstoque.getText() != null)
			datasaida = TelaEstoque.txtDataSaidaEstoque.getText();
		return datasaida;
	}
	public void setDatasaida(String datasaida) {
		this.datasaida = datasaida;
	}

	public String getDescricao() {
		if (!TelaEstoque.txtProduto.getText().equals("") && TelaEstoque.txtProduto.getText() != null)
			descricao = TelaEstoque.txtProduto.getText();
		return descricao;
	}
	public void setDescricao(String txtProduto) {
		this.descricao = txtProduto;
	}
	
	public String getQuantidade() {
		if (!TelaEstoque.txtQtdProduto.getText().equals("") && TelaEstoque.txtQtdProduto.getText() != null)
			quantidade = TelaEstoque.txtQtdProduto.getText();
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getValor() {
		if (!TelaEstoque.txtValorProduto.getText().equals("") && TelaEstoque.txtValorProduto.getText() != null)
			valor = TelaEstoque.txtValorProduto.getText();
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

//	@Override
//	public String toString() {
//		return "{ Produto [Codigo Produto = "+codProduto+",\r\n descricao = " + descricao + 
//				",\r\n quantidade = " + quantidade + ",\r\n valor = " + valor +
//				",\r\n Data de entrada = " + dataentrada+ ",\r\n Data de Saída = "+ datasaida + "]\r\n}";
//	}
	
	@Override
	public String toString() {
		return codProduto+","+descricao+","+quantidade+","+valor+","+dataentrada+","+datasaida;
	}
	
	
}
