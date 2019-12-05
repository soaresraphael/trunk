package cliente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CliqueDuploMouse  {
	
	private DefaultTableModel limpatabela;

	public CliqueDuploMouse (JTable tabCliente){

		TelaCliente.tabCliente.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
							
				//clique duplo
				if(e.getClickCount() == MouseEvent.BUTTON1){
								 
					int linha = TelaCliente.tabCliente.getSelectedRow();
					//JOptionPane.showMessageDialog(null, "linha = "+linha);				
					
					TelaCliente.txtCpf.setText(TelaCliente.tabCliente.getValueAt(linha,0).toString());
					TelaCliente.txtNCliente.setText(TelaCliente.tabCliente.getValueAt(linha,1).toString());
					TelaCliente.txtTelCliente.setText(TelaCliente.tabCliente.getValueAt(linha,2).toString());
					TelaCliente.tabCliente.getSelectedRow();
										
					limpatabela = (DefaultTableModel)TelaCliente.tabCliente.getModel();
					limpatabela.setNumRows(0);

					TelaCliente.txtCpf.requestFocus();	
					TelaCliente.txtNCliente.setEditable(true);

				}

			}
		});

	}


}

