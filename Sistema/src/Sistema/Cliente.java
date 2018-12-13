package Sistema;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cliente {

	protected static final int Nome = 0;
	JFrame frame;

	private JTable tabCliente;
	private JTextField txtTelCliente;
	private JTextField txtNCliente;
	JFormattedTextField txtCpf;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Cliente window = new Cliente();
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
	public Cliente() {
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

		
		JButton btnNewButton = new JButton("----");
		btnNewButton.setBounds(278, 324, 115, 29);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				//adiciona dados
				String Cpf = txtCpf.getText().trim();
				String Nome = txtNCliente.getText().trim();
				String Telefone = txtTelCliente.getText().trim();

				try{
					DefaultTableModel add = (DefaultTableModel) tabCliente.getModel();
					add.addRow(new String[] {Cpf, Nome,Telefone});


				}catch(Exception e){

					txtCpf.setText("");
					txtNCliente.setText("");
					txtTelCliente.setText("");

					txtCpf.requestFocus();
				}

				txtCpf.setText("");
				txtNCliente.setText("");
				txtTelCliente.setText("");

				txtCpf.requestFocus();



			}
		});
		frame.getContentPane().add(btnNewButton);

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

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Excluindo Arquivo", JOptionPane.YES_NO_OPTION);

					File del = new File(txtCpf.getText()+".txt");
					if(del.exists()){
				  
		                txtCpf.requestFocus();
						del.delete();
						
						//remove linha tabela
						((DefaultTableModel) tabCliente.getModel()).removeRow(tabCliente.getSelectedRow());
						//cursor voltar piscando cpf e limpa os campos
						txtCpf.setText("");
						txtNCliente.setText("");
						txtTelCliente.setText("");
						txtCpf.requestFocus();					
					}
					
				


			}
		});

		btnExcluir.setBounds(552, 324, 115, 29);
		frame.getContentPane().add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(278, 356, 115, 29);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//voltar tela principal
				Principal window = new Principal();
				window.frame.setVisible(true);
				frame.dispose();

			}

		});
		frame.getContentPane().add(btnVoltar);
		
	
		
		//formatar campo cpf
		try{
            MaskFormatter msk = new MaskFormatter("###.###.###-##");
            txtCpf =  new JFormattedTextField(msk);
       		txtCpf.setColumns(10);
    		txtCpf.setBounds(120, 53, 390, 26);
    		frame.getContentPane().add(txtCpf);
        }catch(Exception erro){
        	
        }
		
		
		
		JButton btnGravarCli = new JButton("Gravar");
		btnGravarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				//verifica se cpf já existe
				File file = new File(txtCpf.getText()+".txt");
				if(file.exists()){
					JOptionPane.showMessageDialog(null,"CPF já existe!");
					txtCpf.setText("");
					txtNCliente.setText("");
					txtTelCliente.setText("");
					txtCpf.requestFocus();
				}
				
				// se não pode cadastrar novo 
				else {	
					try {		
						FileWriter gravar = new FileWriter(txtCpf.getText()+".txt");
						PrintWriter linha = new PrintWriter(gravar);			
						linha.print(txtCpf.getText() + "/");
						linha.print(txtNCliente.getText() + "/");
						linha.print(txtTelCliente.getText());
						linha.flush();
						linha.close();
						gravar.close();
						JOptionPane.showMessageDialog(null,"Salvo");
						txtCpf.setText("");
						txtNCliente.setText("");
						txtTelCliente.setText("");
						txtCpf.requestFocus();												
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				return;
			}
		
		});
		
		
		
		btnGravarCli.setBounds(422, 356, 115, 29);
		frame.getContentPane().add(btnGravarCli);

		JButton btnPesquisarCliente = new JButton("Pesquisar Cliente");
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
										
				String cpf = txtCpf.getText();
					
				
				if( cpf == null || "   .   .   -  ".equals(cpf) ){
					JOptionPane.showMessageDialog(null,"Preencher o Campo CPF");
				}
							
				else {			
							try {  
															
					                @SuppressWarnings("resource")
									BufferedReader reader = new BufferedReader(new FileReader(  
					                		cpf+".txt"));  
					                DefaultTableModel modelo = (DefaultTableModel) tabCliente.getModel();  
					                modelo.setNumRows(0);  
					                tabCliente.setModel(modelo);  
					                String linha = "";  
					                while ((linha = reader.readLine()) != null) {  
					                    modelo.addRow(linha.split("/"));  
					                }  
					                txtCpf.requestFocus();
					            } catch (IOException e ) {  
					            	JOptionPane.showMessageDialog(null, "Não Cadastrado");
					            	txtCpf.setText("");
									txtNCliente.setText("");
									txtTelCliente.setText("");
									txtCpf.requestFocus();
									
									//e.printStackTrace();  
					            }
							
							
					}
						
			
			
			}
				
				
			
		});
		
		
		
		
		
		btnPesquisarCliente.setBounds(120, 16, 156, 29);
		frame.getContentPane().add(btnPesquisarCliente);

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

//		txtCpf = new JFormattedTextField();
//		txtCpf.setColumns(10);
//		txtCpf.setBounds(120, 53, 390, 26);
//		frame.getContentPane().add(txtCpf);
		
		
		
		
	}
}
