package controllers;

import play.mvc.*;
import play.mvc.Controller;
import play.mvc.Result;
import models.Agenda;
import models.Contato;
import java.util.HashMap;
import java.util.Map;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class AgendaController extends Controller {

	private Agenda agenda = new Agenda();

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result list() {
        return ok(views.html.agenda.list.render(agenda.getAgenda()));
    }

    public Result contatoForm(String nome){
    	if(nome == null){
    		nome = "";
    	}

    	String endereco = "";
    	String telefone = "";

    	Contato contato = new Contato(nome, endereco, telefone);
    	Contato tmp = agenda.find(contato, "nome");

    	if(tmp != null){
    		contato = tmp;
    	}

    	return ok(views.html.agenda.contato.render(contato));
    }

    public Result salvar(String nome){
    	Map<String, String[]> r = request().body().asFormUrlEncoded();

    	String new_nome = null;
    	String new_endereco = null;
    	String new_telefone = null;

    	try{
    		new_nome = r.get("nome")[0];
    		new_endereco = r.get("endereco")[0];
    		new_telefone = r.get("telefone")[0];
    	}catch(NullPointerException e){

    	}
    	
    	if( new_nome != null &&  new_endereco != null &&  new_telefone != null){
    		Contato contato = null;

    		if( nome ==  ""){
    			contato = new Contato(new_nome, new_endereco, new_telefone);

	    		if( agenda.find(contato, "nome") == null){
	    			agenda.add(contato);
	    		}
    		}
    		else{
    			contato = agenda.find( new Contato(nome, "", ""), "nome");
    			contato.setNome(new_nome);
    			contato.setEndereco(new_endereco);
    			contato.setTelefone(new_telefone);
    		}

    		
    		
    	}
    	
    	return redirect(routes.AgendaController.list());
    }

    public Result deletar(String nome){
    	Contato contato = agenda.find(new Contato(nome, "", ""), "nome");
    	if(contato != null){
    		agenda.remove(contato);
    	}
    	return redirect(routes.AgendaController.list());
    }

}