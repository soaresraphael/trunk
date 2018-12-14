package Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Estoque {

	JFrame frame;
	private JTable tabEstoque;
	private JTextField txtCodEstoque;
	private JTextField txtProduto;
	private JTextField txtQtdProduto;
	private JTextField txtValorProduto;
	private JTextField txtDataEntradaEstoque;
	private JTextField txtConsulta;
	private JTextField txtDataSaidaEstoque;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque window = new Estoque();
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
	public Estoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 696, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Cod");
		lblNome.setBounds(19, 51, 47, 38);
		frame.getContentPane().add(lblNome);
		
		JButton btnNewButton = new JButton("Incluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//adiciona dados
				String CodEstoque = txtCodEstoque.getText().trim();
				String Produto = txtProduto.getText().trim();
				String Quantidade = txtQtdProduto.getText().trim();
				String Valor = txtValorProduto.getText().trim();
				String DataEntrada = txtDataEntradaEstoque.getText().trim();
				String DataSaida = txtDataSaidaEstoque.getText().trim();

				DefaultTableModel add = (DefaultTableModel) tabEstoque.getModel();
				add.addRow(new String[] {CodEstoque, Produto, Quantidade, Valor, DataEntrada, DataSaida});
			
								
				txtCodEstoque.setText("");
				txtProduto.setText("");
				txtQtdProduto.setText("");
				txtValorProduto.setText("");
				txtDataEntradaEstoque.setText("");
				txtDataSaidaEstoque.setText("");
				
				txtCodEstoque.requestFocus();
				
			}
		});
		btnNewButton.setBounds(270, 326, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 180, 640, 130);
		frame.getContentPane().add(scrollPane);
		
		tabEstoque = new JTable();
		tabEstoque.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"cod", "produto", "quantidade", "valor", "Data Entrada", "Data Saida"
			}
		));
		scrollPane.setViewportView(tabEstoque);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(414, 326, 115, 29);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(544, 326, 115, 29);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal window = new Principal();
				window.frame.setVisible(true);
				frame.dispose();
			}
		
		});
		btnVoltar.setBounds(270, 358, 115, 29);
		frame.getContentPane().add(btnVoltar);
						
		JButton btnGravarEst = new JButton("Gravar");
		btnGravarEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
//				verifica se código já existe
//				JOptionPane.showMessageDialog(null,"Cód. já existe!");
//					txtCodEstoque.setText("");
//		        	txtProduto.setText("");
//		        	txtQtdProduto.setText("");
//		        	txtValorProduto.setText("");
//		        	txtDataEntradaEstoque.setText("");
//		        	txtDataSaidaEstoque.setText("");
//					txtCodEstoque.requestFocus();
								
				BufferedWriter bw = null;

		        try {
		            bw = new BufferedWriter(new FileWriter("estoque.txt", true));
		            bw.write(txtCodEstoque.getText()+";"+txtProduto.getText()+";"+
		            		txtQtdProduto.getText()+";"+txtValorProduto.getText()+";"+
		            		txtDataEntradaEstoque.getText()+";"+txtDataSaidaEstoque.getText()+";");
		            bw.newLine();
		            bw.flush();
		        	JOptionPane.showMessageDialog(null,"Salvo");
		        	
		        	txtCodEstoque.setText("");
		        	txtProduto.setText("");
		        	txtQtdProduto.setText("");
		        	txtValorProduto.setText("");
		        	txtDataEntradaEstoque.setText("");
		        	txtDataSaidaEstoque.setText("");
					txtCodEstoque.requestFocus();	
		         
		            
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
		});

		
		
		btnGravarEst.setBounds(414, 358, 115, 29);
		frame.getContentPane().add(btnGravarEst);
		
		txtCodEstoque = new JTextField();
		txtCodEstoque.setBounds(68, 57, 125, 26);
		frame.getContentPane().add(txtCodEstoque);
		txtCodEstoque.setColumns(10);
		
		JButton btnConsultarEstoque = new JButton("Consultar Estoque");
		btnConsultarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			        
				String con = txtConsulta.getText();


				if( con == null || "".equals(con) ){
					JOptionPane.showMessageDialog(null,"Preencher o Campo Consulta");
				}

				else {			
					try {  
													
			                @SuppressWarnings("resource")
							BufferedReader reader = new BufferedReader(new FileReader(  
			                		"estoque.txt"));  
			                DefaultTableModel modelo = (DefaultTableModel) tabEstoque.getModel();  
			                modelo.setNumRows(0);  
			                tabEstoque.setModel(modelo);  
			                String linha = "";  
			                while ((linha = reader.readLine()) != null) {  
			                    modelo.addRow(linha.split(";"));  
			                }  
			                txtConsulta.requestFocus();
			            } catch (IOException e ) {  
			            	JOptionPane.showMessageDialog(null, "Não Cadastrado");
			            	txtCodEstoque.setText("");
				        	txtProduto.setText("");
				        	txtQtdProduto.setText("");
				        	txtValorProduto.setText("");
				        	txtDataEntradaEstoque.setText("");
				        	txtDataSaidaEstoque.setText("");
							txtCodEstoque.requestFocus();	
							
							//e.printStackTrace();  
			            }
				
				
		    
				
				
				}
				
			}
		});
		
		btnConsultarEstoque.setBounds(466, 16, 193, 29);
		frame.getContentPane().add(btnConsultarEstoque);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(206, 51, 93, 38);
		frame.getContentPane().add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setColumns(10);
		txtProduto.setBounds(281, 57, 378, 26);
		frame.getContentPane().add(txtProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(19, 89, 93, 38);
		frame.getContentPane().add(lblQuantidade);
		
		txtQtdProduto = new JTextField();
		txtQtdProduto.setColumns(10);
		txtQtdProduto.setBounds(105, 95, 154, 26);
		frame.getContentPane().add(txtQtdProduto);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(285, 89, 93, 38);
		frame.getContentPane().add(lblValor);
		
		txtValorProduto = new JTextField();
		txtValorProduto.setColumns(10);
		txtValorProduto.setBounds(379, 95, 280, 26);
		frame.getContentPane().add(txtValorProduto);
		
		JLabel lblDataEntrada = new JLabel("Data Entrada");
		lblDataEntrada.setBounds(19, 131, 93, 38);
		frame.getContentPane().add(lblDataEntrada);
		
		txtDataEntradaEstoque = new JTextField();
		txtDataEntradaEstoque.setColumns(10);
		txtDataEntradaEstoque.setBounds(127, 137, 208, 26);
		frame.getContentPane().add(txtDataEntradaEstoque);
		
		txtConsulta = new JTextField();
		txtConsulta.setColumns(10);
		txtConsulta.setBounds(19, 17, 432, 26);
		frame.getContentPane().add(txtConsulta);
		
		JLabel lblDataSada = new JLabel("Data Sa\u00EDda");
		lblDataSada.setBounds(350, 131, 93, 38);
		frame.getContentPane().add(lblDataSada);
		
		txtDataSaidaEstoque = new JTextField();
		txtDataSaidaEstoque.setColumns(10);
		txtDataSaidaEstoque.setBounds(445, 137, 214, 26);
		frame.getContentPane().add(txtDataSaidaEstoque);
		
	}
}
