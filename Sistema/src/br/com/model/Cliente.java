/**
 * 
 */
package br.com.model;

import java.io.Serializable;

/**
 * @author gigomes
 *
 */
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1732551802071158079L;
	
	private String nome;
	private String cpf;
	private String telefone;
	
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	
		/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */

	public String toString()
	{
		return "CPF: " + this.cpf + "/" + "Nome:" + this.nome + "\n" + "Telefone: " + this.telefone ;
	}

}


	

