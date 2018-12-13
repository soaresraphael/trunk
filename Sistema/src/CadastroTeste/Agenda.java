
package CadastroTeste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agenda {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtTel;
	private JTextField textValor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String teste = null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda window = new Agenda();
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
	public Agenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Cadastro ");
		lblNome.setBounds(15, 0, 88, 38);
		frame.getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(146, 55, 387, 26);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JButton btnAlt = new JButton("Alterar");
		btnAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnAlt.setBounds(133, 203, 88, 25);
		frame.getContentPane().add(btnAlt);
		
			
			btnAlt.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
//					
//					try {
//						if (txtUser.getText().equals("x") &&
//								txtSenha.getText().equals("z")) {
//								
//								fatorial window = new fatorial();
//								window.frame.setVisible(true);
//								
//								System.out.println("Entrou!");
//					}
//					//	else { 
//					//						
//					//	}
//					} catch (Exception e1) {
//					//JOptionPane.showMessageDialog(null,"Login ou Senha incorretos","tente novamente",JOptionPane.PLAIN_MESSAGE);
//					e1.printStackTrace();
//					}
						

				

				}

			});
			


		JLabel lblSenha = new JLabel("Telefone");
		lblSenha.setBounds(15, 91, 123, 38);
		frame.getContentPane().add(lblSenha);

		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(146, 97, 387, 26);
		frame.getContentPane().add(txtTel);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(15, 49, 147, 38);
		frame.getContentPane().add(lblNomeCompleto);
		
		JLabel lblValor = new JLabel("Endere\u00E7o");
		lblValor.setBounds(15, 135, 123, 38);
		frame.getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(146, 139, 387, 26);
		frame.getContentPane().add(textValor);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(331, 203, 88, 25);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(15, 203, 88, 25);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(445, 201, 88, 25);
		frame.getContentPane().add(btnSair);

	}
}
