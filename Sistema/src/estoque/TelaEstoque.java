package estoque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistema.VoltarTelaPrincipal;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TelaEstoque {

	public JFrame frame;
	public  JTable tabEstoque;
	public  JTextField txtCodEstoque;
	public  JTextField txtProduto;
	public  JTextField txtQtdProduto;
	public  JTextField txtValorProduto;
	public  JTextField txtDataEntradaEstoque;
	public  JTextField txtConsulta;
	public  JTextField txtDataSaidaEstoque;
	public  JComboBox<String> Combo = new JComboBox<String>();
	public JButton btnExcluir ;
	JButton btnAlterar = new JButton("Alterar");
	public ActionListener actExcluirProduto;
	public ActionListener actGravarProduto;
	public ActionListener actVoltarTelaPrincipal;
	public ActionListener actConsultarProduto;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstoque window = new TelaEstoque();
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
	public TelaEstoque() {
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
		
		
//		btnAlterar.setBounds(414, 326, 115, 29);
//		frame.getContentPane().add(btnAlterar);
//		btnExcluir.addActionListener(new ActionListener() {
//		btnExcluir.setBounds(544, 326, 115, 29);
//		frame.getContentPane().add(btnExcluir);
				
		txtCodEstoque = new JTextField();
		txtCodEstoque.setBounds(68, 57, 125, 26);
		frame.getContentPane().add(txtCodEstoque);
		txtCodEstoque.setColumns(10);
	
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
		
		
		Combo.addItem("contains");
		Combo.addItem("equals");
		Combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Combo.getSelectedIndex() == 0) {
					System.out.println("contains");
				}else {
					System.out.println("aaaa");
				}
				
			}
		});
		Combo.setBounds(68, 327, 145, 38);
		frame.getContentPane().add(Combo);
		

		
		
		
		
		//botões
		JButton btnExcluir = new JButton("Excluir");
		actExcluirProduto = new ActionExcluirProduto(this);
		btnExcluir.addActionListener(actExcluirProduto);
		btnExcluir.setBounds(552, 324, 115, 29);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnGravarEst = new JButton("Gravar");
		actGravarProduto = new ActionGravarProduto(this);
		btnGravarEst.addActionListener(actGravarProduto);
		btnGravarEst.setBounds(414, 358, 115, 29);
		frame.getContentPane().add(btnGravarEst);
				
		JButton btnVoltar = new JButton("Voltar");
		actVoltarTelaPrincipal = new VoltarTelaPrincipal(this);
		btnVoltar.addActionListener(actVoltarTelaPrincipal);
		btnVoltar.setBounds(278, 356, 115, 29);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnConsultarEstoque = new JButton("Consultar Estoque");
		actConsultarProduto = new ActionConsultarProduto(this);
		btnConsultarEstoque.addActionListener(actConsultarProduto);
		btnConsultarEstoque.setBounds(466, 16, 193, 29);
		frame.getContentPane().add(btnConsultarEstoque);
		

	}
}
