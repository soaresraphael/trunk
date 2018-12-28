package vendas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class TelaVendas {

	protected static final String Convert = null;
	JFrame frame;
	private JTable tabVendas;
	private JTextField txtCliente;
	private JTextField txtProduto;
	private JTextField txtQtdProduto;
	private JTextField txtValorProduto;
	private JTextField txtDataVenda;
	private JTextField txtTotalVenda;
	private JTextField txtCodVenda;
	
	
	public ActionListener actVoltarTelaPrincipal;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVendas window = new TelaVendas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaVendas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 767, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Cod. Venda");
		lblNome.setBounds(174, 11, 93, 38);
		frame.getContentPane().add(lblNome);
		
		JButton btnIncluirVenda = new JButton("Incluir");
		btnIncluirVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BufferedWriter vp = null;

		        try {
		            vp = new BufferedWriter(new FileWriter("vendas.txt", true));
		            vp.write(txtCodVenda.getText()+";"+txtProduto.getText()+";"+
		            		txtQtdProduto.getText()+";"+txtValorProduto.getText()+";"+
		            		txtCliente.getText()+";"+txtDataVenda.getText()+";");
		
		
		            vp.newLine();
		            vp.flush();
		        	JOptionPane.showMessageDialog(null,"Salvo");
		        		            
		        } catch (IOException ioe) {
		            ioe.printStackTrace();
		        } finally { // always close the file
		            if (vp != null) {
		                try {
		                    vp.close();
		                } catch (IOException ioe2) {
		                    // just ignore it
		                }
		            }
		        }
				
		     
		        
				//adiciona dados
				String CodVenda = txtCodVenda.getText().trim();
				String Cliente = txtCliente.getText().trim();
				String Produto = txtProduto.getText().trim();
				String Quantidade = txtQtdProduto.getText().trim();
				String Valor = txtValorProduto.getText().trim();
				String DataVenda = txtDataVenda.getText().trim();
				
		
				DefaultTableModel addV = (DefaultTableModel) tabVendas.getModel();
				addV.addRow(new String[] {CodVenda, Cliente, Produto, Quantidade, Valor, DataVenda});

					
				txtCodVenda.setText("");
				txtCliente.setText("");
				txtProduto.setText("");
				txtQtdProduto.setText("");
				txtValorProduto.setText("");
				//txtDataVenda.setText("");
					
				txtCodVenda.requestFocus();
				
				
				   int count= 0;
					for (int i=0; i<=tabVendas.getRowCount()-1;i++) {
					count+=Integer.parseInt(tabVendas.getValueAt(i, 4).toString());
					}
					txtTotalVenda.setText(String.valueOf(count));
				
				
			}
		});
		btnIncluirVenda.setBounds(281, 305, 115, 29);
		frame.getContentPane().add(btnIncluirVenda);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(424, 305, 115, 29);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(554, 305, 115, 29);
		frame.getContentPane().add(btnExcluir);
		
		
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(34, 46, 93, 38);
		frame.getContentPane().add(lblCliente);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(34, 79, 93, 38);
		frame.getContentPane().add(lblProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 180, 696, 103);
		frame.getContentPane().add(scrollPane);
		
		tabVendas = new JTable();
		tabVendas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod. Venda", "Cliente", "Produto", "Quantidade", "Valor", "Data Venda"
			}
		));
		scrollPane.setViewportView(tabVendas);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(174, 50, 346, 26);
		frame.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(535, 49, 115, 29);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnGravarVenda = new JButton("Gravar");
		btnGravarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				BufferedWriter vp = null;

		        try {
		            vp = new BufferedWriter(new FileWriter("vendas.txt", true));
		            vp.write(txtCodVenda.getText()+";"+txtProduto.getText()+";"+
		            		txtQtdProduto.getText()+";"+txtValorProduto.getText()+";"+
		            		txtCliente.getText()+";"+txtDataVenda.getText()+";");
		          
		            vp.newLine();
		            vp.flush();
		        	JOptionPane.showMessageDialog(null,"Salvo");
		        	
		        	txtCodVenda.setText("");
		        	txtCliente.setText("");
		        	txtProduto.setText("");
		        	txtQtdProduto.setText("");
		        	txtValorProduto.setText("");
		        	txtTotalVenda.setText("");
		        	//txtDataVenda.setText("");
		            
		        } catch (IOException ioe) {
		            ioe.printStackTrace();
		        } finally { // always close the file
		            if (vp != null) {
		                try {
		                    vp.close();
		                } catch (IOException ioe2) {
		                    // just ignore it
		                }
		            }
		        }
	
			}
		});
		btnGravarVenda.setBounds(424, 337, 115, 29);
		frame.getContentPane().add(btnGravarVenda);
		
		JButton button = new JButton("Buscar");
		button.setBounds(536, 82, 115, 29);
		frame.getContentPane().add(button);
		
		txtProduto = new JTextField();
		txtProduto.setColumns(10);
		txtProduto.setBounds(174, 83, 346, 26);
		frame.getContentPane().add(txtProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(34, 126, 93, 38);
		frame.getContentPane().add(lblQuantidade);
		
		txtQtdProduto = new JTextField();
		txtQtdProduto.setColumns(10);
		txtQtdProduto.setBounds(142, 135, 122, 26);
		frame.getContentPane().add(txtQtdProduto);
		
		txtValorProduto = new JTextField();
		txtValorProduto.setColumns(10);
		txtValorProduto.setBounds(336, 132, 122, 26);
		frame.getContentPane().add(txtValorProduto);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(281, 126, 37, 38);
		frame.getContentPane().add(lblValor);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(473, 126, 37, 38);
		frame.getContentPane().add(lblData);
		
		txtDataVenda = new JTextField();
		txtDataVenda.setColumns(10);
		txtDataVenda.setBounds(528, 132, 122, 26);
		frame.getContentPane().add(txtDataVenda);
		//Mostrando data atual
		txtDataVenda.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));

		
		txtTotalVenda = new JTextField();
		txtTotalVenda.setColumns(10);
		txtTotalVenda.setBounds(142, 334, 122, 26);
		frame.getContentPane().add(txtTotalVenda);
		
		JLabel lblTotalVenda = new JLabel("Total Venda");
		lblTotalVenda.setBounds(34, 328, 93, 38);
		frame.getContentPane().add(lblTotalVenda);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(535, 16, 115, 29);
		frame.getContentPane().add(button_1);
		
		txtCodVenda = new JTextField();
		txtCodVenda.setColumns(10);
		txtCodVenda.setBounds(345, 17, 175, 26);
		frame.getContentPane().add(txtCodVenda);
		
		JButton btnSomar = new JButton("somar");
		btnSomar.addActionListener(new ActionListener() {
				@SuppressWarnings("unused")
				public void actionPerformed(ActionEvent e3) {
				
				int count= 0;
				for (int i=0; i<=tabVendas.getRowCount()-1;i++) {
				count+=Integer.parseInt(tabVendas.getValueAt(i, 4).toString());
				}
			
				
				  txtTotalVenda.setText(String.valueOf(count));
			
				
			}
		});
		btnSomar.setBounds(142, 299, 115, 29);
		frame.getContentPane().add(btnSomar);
		
	}

	protected int parseDouble(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	//botões
	JButton btnVoltar = new JButton("Voltar");
	actVoltarTelaPrincipal = new VoltarTelaPrincipal(this);
	btnVoltar.addActionListener(actVoltarTelaPrincipal);
	btnVoltar.setBounds(278, 356, 115, 29);
	frame.getContentPane().add(btnVoltar);
	
	
}