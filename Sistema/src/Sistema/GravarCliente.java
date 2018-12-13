package Sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GravarCliente {

	public void Salvar() {
		
		try {
			FileWriter gravar = new FileWriter("Clientes.txt");
			PrintWriter linha = new PrintWriter(gravar);
			linha.println();
			linha.println();
			linha.println();
			linha.flush();
			linha.close();
			gravar.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return;
		
	}

		
			
		
}
