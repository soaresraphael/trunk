package sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import cliente.TelaCliente;
import estoque.TelaEstoque;
import vendas.TelaVendas;

import java.awt.Button;

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
		frame.setBounds(100, 100, 628, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setBounds(37, 26, 88, 38);
		frame.getContentPane().add(lblPrincipal);

		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEstoque window = new TelaEstoque();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});

		btnEstoque.setBounds(37, 70, 172, 29);
		frame.getContentPane().add(btnEstoque);

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

		btnSair.setBounds(37, 203, 88, 25);
		frame.getContentPane().add(btnSair);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente window = new TelaCliente();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnClientes.setBounds(37, 107, 172, 29);
		frame.getContentPane().add(btnClientes);
		
		JButton btnVendas = new JButton("Vendas");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendas window = new TelaVendas();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnVendas.setBounds(37, 145, 172, 29);
		frame.getContentPane().add(btnVendas);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(37, 289, 147, 31);
		frame.getContentPane().add(mnNewMenu);

	}
}
