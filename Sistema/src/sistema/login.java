package sistema;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class login {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("User");
		lblNome.setBounds(37, 84, 159, 38);
		frame.getContentPane().add(lblNome);

		txtUser = new JTextField();
		txtUser.setBounds(37, 126, 172, 26);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnEntrar.setBounds(176, 168, 88, 25);
		frame.getContentPane().add(btnEntrar);
		
			
			btnEntrar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						if (txtUser.getText().equals("x") &&
								txtSenha.getText().equals("z")) {
								
								TelaPrincipal window = new TelaPrincipal();
								window.frame.setVisible(true);
								frame.dispose();
								
							System.out.println("Entrou!");
					}
					else { 
						JOptionPane.showMessageDialog(null,"Login ou Senha incorretos","tente novamente",JOptionPane.PLAIN_MESSAGE);
						}
					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}

			});
			


		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(224, 84, 159, 38);
		frame.getContentPane().add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(224, 126, 172, 26);
		frame.getContentPane().add(txtSenha);

	}
}
