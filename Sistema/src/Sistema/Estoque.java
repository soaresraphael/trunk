package Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	private JTextField textField_5;
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
				
				
				File estoque = new File ("estoque.txt");
			
						try{
							FileWriter estq = new FileWriter(estoque);
							BufferedWriter escrever = new BufferedWriter(estq);
							
							escrever.write(txtCodEstoque.getText() + "/n/");
							escrever.close();
							estq.close(); 
							
							FileReader ler = new FileReader(estoque);
							BufferedReader lerarq = new BufferedReader (ler);
							String linha = lerarq.readLine();
							
							
						
							while(linha !=null) {
							
							}
						}catch(IOException ioe){
							//ioe.printStackTrace();
						} 
				   
			
				
//				String linha = b.readLine();
//				
//				while(linha != null) {
//					FileWriter linha = new 
//				linha.print(txtCodEstoque.getText() + "/n/");
//				linha.print(txtProduto.getText() + "/");
//				linha.print(txtQtdProduto.getText()+"/");
//				linha.print(txtValorProduto.getText() + "/");
//				linha.print(txtDataEntradaEstoque.getText() + "/");
//				linha.print(txtDataSaidaEstoque.getText() + "/");
//				linha.print("\n");
//				b.close();
//				}			

				
				
				
			}

		
		});

		
		
		btnGravarEst.setBounds(414, 358, 115, 29);
		frame.getContentPane().add(btnGravarEst);
		
		txtCodEstoque = new JTextField();
		txtCodEstoque.setBounds(68, 57, 125, 26);
		frame.getContentPane().add(txtCodEstoque);
		txtCodEstoque.setColumns(10);
		
		JButton btnConsultarEstoque = new JButton("Consultar Estoque");
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
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(19, 17, 432, 26);
		frame.getContentPane().add(textField_5);
		
		JLabel lblDataSada = new JLabel("Data Sa\u00EDda");
		lblDataSada.setBounds(350, 131, 93, 38);
		frame.getContentPane().add(lblDataSada);
		
		txtDataSaidaEstoque = new JTextField();
		txtDataSaidaEstoque.setColumns(10);
		txtDataSaidaEstoque.setBounds(445, 137, 214, 26);
		frame.getContentPane().add(txtDataSaidaEstoque);
		
	}
}
