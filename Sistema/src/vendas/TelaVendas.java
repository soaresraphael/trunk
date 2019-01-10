package vendas;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistema.VoltarTelaPrincipal;

public class TelaVendas {

	protected static final String Convert = null;
	public JFrame frame;
	static JTable tabVendas;
	public static  JTextField txtConsultaVendas;
	public static JTextField txtCliente;
	public static JTextField txtProduto;
	public static JTextField txtQtdProduto;
	public static JTextField txtValorProduto;
	public static JTextField txtDataVenda;
	public static JTextField txtTotalVenda;
	public static JTextField txtCodVenda;
	public ActionListener actTelaPrincipal;
	public ActionListener actTelaVendas;
	public ActionListener actConsultarVenda;
	public static  JComboBox<String> Combo = new JComboBox<String>();

	
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
		lblNome.setBounds(34, 11, 93, 38);
		frame.getContentPane().add(lblNome);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(348, 337, 115, 29);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(218, 337, 115, 29);
		frame.getContentPane().add(btnExcluir);
	
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(34, 46, 93, 38);
		frame.getContentPane().add(lblCliente);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(34, 79, 93, 38);
		frame.getContentPane().add(lblProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 158, 696, 147);
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
		txtCliente.setBounds(174, 50, 556, 26);
		frame.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
	
		txtProduto = new JTextField();
		txtProduto.setColumns(10);
		txtProduto.setBounds(174, 83, 556, 26);
		frame.getContentPane().add(txtProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(34, 113, 93, 29);
		frame.getContentPane().add(lblQuantidade);
		
		txtQtdProduto = new JTextField();
		txtQtdProduto.setColumns(10);
		txtQtdProduto.setBounds(174, 114, 122, 26);
		frame.getContentPane().add(txtQtdProduto);
		
		txtValorProduto = new JTextField();
		txtValorProduto.setColumns(10);
		txtValorProduto.setBounds(375, 114, 122, 26);
		frame.getContentPane().add(txtValorProduto);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(311, 108, 37, 38);
		frame.getContentPane().add(lblValor);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(522, 108, 37, 38);
		frame.getContentPane().add(lblData);
		
		txtDataVenda = new JTextField();
		txtDataVenda.setColumns(10);
		txtDataVenda.setBounds(608, 114, 122, 26);
		frame.getContentPane().add(txtDataVenda);
		//Mostrando data atual
		txtDataVenda.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));

		
		txtTotalVenda = new JTextField();
		txtTotalVenda.setColumns(10);
		txtTotalVenda.setBounds(608, 338, 122, 26);
		frame.getContentPane().add(txtTotalVenda);
		
		JLabel lblTotalVenda = new JLabel("Total Venda");
		lblTotalVenda.setBounds(637, 300, 93, 38);
		frame.getContentPane().add(lblTotalVenda);
			
		txtCodVenda = new JTextField();
		txtCodVenda.setColumns(10);
		txtCodVenda.setBounds(174, 17, 115, 26);
		frame.getContentPane().add(txtCodVenda);
		

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
		Combo.setBounds(525, 16, 75, 29);
		frame.getContentPane().add(Combo);
		
		
		//botões
		JButton btnVoltar = new JButton("Voltar");
		actTelaPrincipal = new VoltarTelaPrincipal(this);
		btnVoltar.addActionListener(actTelaPrincipal);
		btnVoltar.setBounds(88, 337, 115, 29);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnGravarVenda = new JButton("Gravar");
		actTelaVendas = new ActionGravarVenda(this);
		btnGravarVenda.addActionListener(actTelaVendas);
		btnGravarVenda.setBounds(478, 337, 115, 29);
		frame.getContentPane().add(btnGravarVenda);
		
		JButton btnConsultarVendas = new JButton("Consultar");
		actConsultarVenda = new ActionConsultarVenda(this);
		btnConsultarVendas.addActionListener(actConsultarVenda);
		btnConsultarVendas.setBounds(615, 16, 115, 29);
		frame.getContentPane().add(btnConsultarVendas);
		
		Component txtConsultaVenda = new JTextField();
		((JTextField) txtConsultaVenda).setColumns(10);
		txtConsultaVenda.setBounds(397, 17, 115, 26);
		frame.getContentPane().add(txtConsultaVenda);
		
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setBounds(308, 11, 93, 38);
		frame.getContentPane().add(lblConsulta);
		
	}
}
	

	