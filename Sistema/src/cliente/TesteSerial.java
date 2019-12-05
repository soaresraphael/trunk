package cliente;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.model.Cliente;

	
	public class TesteSerial  {
	      
		public static void main(String[] args) {
       
        	try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"));
                Cliente cc = (Cliente) ois.readObject();
                ois.close();
                System.out.println("CPF: " + cc.getCpf() + " Nome: " + cc.getNome() +  " Telefone: " + cc.getTelefone());
                
        	}catch(IOException | ClassNotFoundException e1) {
        	}
        	}
	}
	
	

            
        


