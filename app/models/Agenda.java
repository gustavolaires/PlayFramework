package models;

import java.util.List;
import java.util.ArrayList;

public class Agenda {

	private List<Contato> contatos;
	
	public Agenda() {
		this.contatos = new ArrayList<Contato>();
	}
	
	public boolean add(Contato contato) {
		if(!contatos.contains(contato)) {
			contatos.add(contato);
			return true;
		}
		return false;
		
	}
	
	public boolean remove(Contato contato) {
		return contatos.remove(contato);
	}
	
	public Contato find(Contato contato, String tipo) {
		int size = contatos.size();
		Contato tmp = null;
		
		switch (tipo){
			case "Nome":
			case "nome":
				for(int i=0; i<size; i++) {
					tmp = contatos.get(i);
					
					if(tmp.getNome().contentEquals(contato.getNome())) {
						return tmp;
					}
				}
				break;
				
			case "Endereco":
			case "endereco":
				for(int i=0; i<size; i++) {
					tmp = contatos.get(i);
					
					if(tmp.getEndereco().contentEquals(contato.getEndereco())) {
						return tmp;
					}
				}
				break;
				
			case "Telefone":
			case "telefone":
				for(int i=0; i<size; i++) {
					tmp = contatos.get(i);
					
					if(tmp.getTelefone().contentEquals(contato.getTelefone())) {
						return tmp;
					}
				}	
				break;
		}
		return null;
	}
	
	public List<Contato> getAgenda(){
		return contatos;
	}
	
}
