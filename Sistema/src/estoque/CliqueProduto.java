package estoque;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import estoque.TelaEstoque;

public class CliqueProduto  {
	
	public DefaultTableModel limpatabela;

	public CliqueProduto (JTable tabEstoque){

		TelaEstoque.tabEstoque.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
							
				//clique duplo
				if(e.getClickCount() == MouseEvent.BUTTON1){
								 
					int linha = TelaEstoque.tabEstoque.getSelectedRow();
					//JOptionPane.showMessageDialog(null, "linha = "+linha);				
	
					TelaEstoque.txtCodProduto.setText(TelaEstoque.tabEstoque.getValueAt(linha,0).toString());
					TelaEstoque.txtProduto.setText(TelaEstoque.tabEstoque.getValueAt(linha,1).toString());
					TelaEstoque.txtQtdProduto.setText(TelaEstoque.tabEstoque.getValueAt(linha,2).toString());
					TelaEstoque.txtValorProduto.setText(TelaEstoque.tabEstoque.getValueAt(linha,3).toString());
					TelaEstoque.txtDataEntradaEstoque.setText(TelaEstoque.tabEstoque.getValueAt(linha,4).toString());
					TelaEstoque.txtDataSaidaEstoque.setText(TelaEstoque.tabEstoque.getValueAt(linha,5).toString());

					TelaEstoque.tabEstoque.getSelectedRow();
					
					limpatabela = (DefaultTableModel)TelaEstoque.tabEstoque.getModel();
					limpatabela.setNumRows(0);
					
					TelaEstoque.txtConsulta.requestFocus();	
					TelaEstoque.txtCodProduto.setEditable(false);
					//TelaEstoque.txtProduto.setEditable(false);

				}

			}
		});

	}
}