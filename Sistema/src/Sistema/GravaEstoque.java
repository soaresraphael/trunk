package Sistema;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class GravaEstoque {

	public static void main(String[] args) throws Throwable {

		FileInputStream f = new FileInputStream("estoque.txt");
		InputStreamReader l = new InputStreamReader(f);
		BufferedReader b = new BufferedReader(l);
		
		String linha = b.readLine();
		System.out.println(linha);
		b.close();
		
	}


}
