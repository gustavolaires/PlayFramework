package models;

public class Contato{

	private String nome;
	private String endereco;
	private String telefone;

	public Contato(){

	}

	public Contato(String nome, String endereco, String telefone){
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	//SETTERS
	public void setNome(String nome){
		this.nome = nome;
	}

	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}

	//GETTERS
	public String getNome(){
		return this.nome;
	}

	public String getEndereco(){
		return this.endereco;
	}

	public String getTelefone(){
		return this.telefone;
	}
}