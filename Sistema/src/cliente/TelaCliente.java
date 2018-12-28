package cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import cliente.ActionExcluirCliente;
import sistema.TelaPrincipal;
import sistema.VoltarTelaPrincipal;
import cliente.ActionPesquisaCliente;


@SuppressWarnings("unused")

public class TelaCliente {

	protected static final int Nome = 0;
	public JFrame frame;

	public JTable tabCliente;
	public JTextField txtTelCliente;
	public JTextField txtNCliente;
	public JFormattedTextField txtCpf;
	public ActionListener actExcluir;
	public ActionListener actPesquisaCliente;
	public ActionListener actGravarCliente;
	public ActionListener actVoltarTelaPrincipal;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					TelaCliente cliente = new TelaCliente();
					cliente.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCliente() {
		initialize();
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Clientes");
		lblNome.setBounds(34, 11, 71, 38);
		frame.getContentPane().add(lblNome);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 185, 633, 123);
		frame.getContentPane().add(scrollPane);


		tabCliente = new JTable();
		tabCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//clique duplo
				if(e.getClickCount() == MouseEvent.BUTTON1){
			          			        
				int linha = tabCliente.getSelectedRow();
				//JOptionPane.showMessageDialog(null, "linha = "+linha);
				txtCpf.setText(tabCliente.getValueAt(linha,0).toString());
				txtNCliente.setText(tabCliente.getValueAt(linha,1).toString());
				txtTelCliente.setText(tabCliente.getValueAt(linha,2).toString());
				tabCliente.getSelectedRow();
				txtCpf.requestFocus();												

				}
				
			}
		});

		tabCliente.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Cpf", "Nome", "Telefone"
				}
				));
		scrollPane.setViewportView(tabCliente);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {		
					FileWriter gravar = new FileWriter(txtCpf.getText()+".txt");
					PrintWriter linha = new PrintWriter(gravar);			
					linha.print(txtCpf.getText() + "/");
					linha.print(txtNCliente.getText() + "/");
					linha.print(txtTelCliente.getText());
					linha.flush();
					linha.close();
					gravar.close();
					JOptionPane.showMessageDialog(null,"Alterado");
					//cursor voltar piscando cpf
					txtCpf.setText("");
					txtNCliente.setText("");
					txtTelCliente.setText("");
					txtCpf.requestFocus();												
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		btnAlterar.setBounds(422, 324, 115, 29);
		frame.getContentPane().add(btnAlterar);

		
		
		//formatar campo cpf
		try{
            MaskFormatter msk = new MaskFormatter("###.###.###-##");
            txtCpf =  new JFormattedTextField(msk);
       		txtCpf.setColumns(10);
    		txtCpf.setBounds(120, 53, 390, 26);
    		frame.getContentPane().add(txtCpf);
        }catch(Exception erro) { }

		txtTelCliente = new JTextField();
		txtTelCliente.setColumns(10);
		txtTelCliente.setBounds(120, 129, 390, 26);
		frame.getContentPane().add(txtTelCliente);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(34, 87, 71, 38);
		frame.getContentPane().add(lblNome_1);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(34, 123, 71, 38);
		frame.getContentPane().add(lblTelefone);

		txtNCliente = new JTextField();
		txtNCliente.setColumns(10);
		txtNCliente.setBounds(120, 93, 390, 26);
		frame.getContentPane().add(txtNCliente);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(34, 47, 71, 38);
		frame.getContentPane().add(lblCpf);

		//botões
		JButton btnGravarCli = new JButton("Gravar");
		actGravarCliente = new ActionGravarCliente(this);
		btnGravarCli.addActionListener(actGravarCliente);
		btnGravarCli.setBounds(422, 356, 115, 29);
		frame.getContentPane().add(btnGravarCli);
		
		JButton btnExcluir = new JButton("Excluir");
		actExcluir = new ActionExcluirCliente(this);
		btnExcluir.addActionListener(actExcluir);
		btnExcluir.setBounds(552, 324, 115, 29);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnPesquisarCliente = new JButton("Pesquisar Cliente");
		actPesquisaCliente = new ActionPesquisaCliente(this);
		btnPesquisarCliente.addActionListener(actPesquisaCliente);
		btnPesquisarCliente.setBounds(120, 16, 156, 29);
		frame.getContentPane().add(btnPesquisarCliente);
		
		JButton btnVoltar = new JButton("Voltar");
		actVoltarTelaPrincipal = new VoltarTelaPrincipal(this);
		btnVoltar.addActionListener(actVoltarTelaPrincipal);
		btnVoltar.setBounds(278, 356, 115, 29);
		frame.getContentPane().add(btnVoltar);
		
	}

}
