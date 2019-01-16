package vendas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sistema.LimparCampos;
import vendas.TelaVendas;

public class ActionGravarVenda implements ActionListener {

	private TelaVendas vendas;

	public ActionGravarVenda (TelaVendas vendas){
		this();
		this.vendas = vendas;
	}

	public ActionGravarVenda() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {

		BufferedWriter pv = null;

		try {
			pv = new BufferedWriter(new FileWriter("vendas.txt", true));
			PedVendas pdv = new PedVendas();
			pdv.setCodVenda(TelaVendas.txtCodVenda.getText());
			pdv.setCliente(TelaVendas.txtCliente.getText());
			pdv.setProduto(TelaVendas.txtProduto.getText());
			pdv.setQuantidade(TelaVendas.txtQtdProduto.getText());
			pdv.setValor(TelaVendas.txtValorProduto.getText());
			pdv.setDataVenda(TelaVendas.txtDataVenda.getText());

			pv.write(pdv.toString());
			pv.newLine();
			pv.flush();
			JOptionPane.showMessageDialog(null,"Salvo");


		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally { // always close the file
			if (pv != null) {
				try {
					pv.close();
				} catch (IOException ioe2) {
					// just ignore it
				}

				//adiciona dados
				String CodVenda = TelaVendas.txtCodVenda.getText().trim();
				String Cliente = TelaVendas.txtCliente.getText().trim();
				String Produto = TelaVendas.txtProduto.getText().trim();
				String Quantidade = TelaVendas.txtQtdProduto.getText().trim();
				String Valor = TelaVendas.txtValorProduto.getText().trim();
				String DataVenda = TelaVendas.txtDataVenda.getText().trim();

				DefaultTableModel addV = (DefaultTableModel) TelaVendas.tabVendas.getModel();
				addV.addRow(new String[] {CodVenda, Cliente, Produto, Quantidade, Valor, DataVenda});

				//chamar a classe limpar campos
				LimparCampos limparcampos = new LimparCampos(vendas);
				limparcampos.getClass();

				//somar total da venda conforme for add produtos
				int count= 0;
				for (int i=0; i<=TelaVendas.tabVendas.getRowCount()-1;i++) {
					count+=Integer.parseInt(TelaVendas.tabVendas.getValueAt(i, 4).toString());
				}
				TelaVendas.txtTotalVenda.setText(String.valueOf(count));
			}
		}

	}

}


