package sistema;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import cliente.TelaCliente;
import estoque.TelaEstoque;
import vendas.TelaVendas;


@SuppressWarnings("unused")
public class VoltarTelaPrincipal implements ActionListener {

	private TelaCliente cliente;
	private TelaEstoque estoque;
	private TelaVendas vendas;

	private boolean telaEstoque = false;
	private boolean telaCliente = false;
	private boolean telaVendas = false;


	public VoltarTelaPrincipal (TelaEstoque estoque){
		this();
		this.estoque = estoque;
		telaEstoque = true;
	}

	public VoltarTelaPrincipal (TelaCliente cliente){
		this();
		this.cliente = cliente;
		telaCliente = true;
	}

	public VoltarTelaPrincipal (TelaVendas vendas){
		this();
		this.vendas = vendas;
		telaVendas = true;

	}


	public VoltarTelaPrincipal() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("null")
	public void actionPerformed(ActionEvent e) {


		//voltar tela principal
		sistema.TelaPrincipal telaprincipal = new TelaPrincipal();
		telaprincipal.frame.setVisible(true);

		if (estoque == null) {
			estoque = new TelaEstoque();
		}
		if (telaEstoque) {
			this.estoque.frame.dispose();
			telaEstoque = false;
		}
		else if (telaCliente) {
			this.cliente.frame.dispose();
			telaCliente = false;
		}
		else if (telaVendas) {
			this.vendas.frame.dispose();
			telaVendas = false;
		}
	}

}
