package sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import cliente.TelaCliente;
import estoque.TelaEstoque;
import vendas.TelaVendas;

public class TelaPrincipal {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 908, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setBounds(41, 11, 88, 38);
		frame.getContentPane().add(lblPrincipal);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Continua", JOptionPane.YES_NO_OPTION);

				if (i == JOptionPane.YES_OPTION) {
					System.out.println("Clicou em Sim");
					System.exit(0);
				} else if (i == JOptionPane.NO_OPTION) {
					System.out.println("Clicou em Não");
				}

			}

		});
		btnSair.setBounds(437, 18, 88, 25);
		frame.getContentPane().add(btnSair);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente window = new TelaCliente();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnClientes.setBounds(231, 16, 88, 29);
		frame.getContentPane().add(btnClientes);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEstoque window = new TelaEstoque();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnEstoque.setBounds(128, 16, 88, 29);
		frame.getContentPane().add(btnEstoque);
		
		JButton btnVendas = new JButton("Vendas");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendas window = new TelaVendas();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnVendas.setBounds(334, 16, 88, 29);
		frame.getContentPane().add(btnVendas);
	}
}
