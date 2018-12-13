package Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Vendas {

	JFrame frame;
	private JTable tabVendas;
	private JTextField txtCliente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtDataVenda;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendas window = new Vendas();
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
	public Vendas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 712, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Cod. Venda");
		lblNome.setBounds(174, 11, 93, 38);
		frame.getContentPane().add(lblNome);
		
		JButton btnNewButton = new JButton("Nova");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnNewButton.setBounds(281, 305, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(424, 305, 115, 29);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(554, 305, 115, 29);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal window = new Principal();
				window.frame.setVisible(true);
				frame.dispose();
			}
		
		});
		btnVoltar.setBounds(281, 337, 115, 29);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(34, 46, 93, 38);
		frame.getContentPane().add(lblCliente);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(34, 79, 93, 38);
		frame.getContentPane().add(lblProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 180, 635, 103);
		frame.getContentPane().add(scrollPane);
		
		tabVendas = new JTable();
		tabVendas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Cod. Venda", "Produto", "Quantidade", "Valor", "Data Venda"
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
		btnGravarVenda.setBounds(424, 337, 115, 29);
		frame.getContentPane().add(btnGravarVenda);
		
		JButton button = new JButton("Buscar");
		button.setBounds(536, 82, 115, 29);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(174, 83, 346, 26);
		frame.getContentPane().add(textField);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(34, 126, 93, 38);
		frame.getContentPane().add(lblQuantidade);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 135, 122, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(336, 132, 122, 26);
		frame.getContentPane().add(textField_2);
		
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

		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(142, 334, 122, 26);
		frame.getContentPane().add(textField_4);
		
		JLabel lblTotalVenda = new JLabel("Total Venda");
		lblTotalVenda.setBounds(34, 328, 93, 38);
		frame.getContentPane().add(lblTotalVenda);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(535, 16, 115, 29);
		frame.getContentPane().add(button_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(345, 17, 175, 26);
		frame.getContentPane().add(textField_5);
		
	}
}