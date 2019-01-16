package estoque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TesteMain {

	public static void main(String[] args) throws IOException {
		
		OutputStream bytes = new FileOutputStream("saida.txt", true);
		OutputStreamWriter chars = new OutputStreamWriter(bytes);
		BufferedWriter strings = new BufferedWriter(chars);
		
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(  
				"saida.txt"));
		
		
		String line = "";
		while ((line = reader.readLine())!= null) {
			
			if (line.contains("1")) {
				//chars.write("\r\n\tttttttttttttttttt");
				line = line.replace("1","888888" );
			}
			strings.write(line);

		}
		  
		reader.close();
		strings.close();
		
	}
	
}
