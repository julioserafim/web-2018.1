package br.ufc.test;
import java.util.Calendar;

import br.ufc.jdbc.dao.ContatoDAO;
import br.ufc.modelo.Contato;

public class Test {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Júlio");
		contato.setEmail("julioserafimM@hotmail.com");
		contato.setEndereco("Rua Eudásio Barroso");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO contatoDAO  = new ContatoDAO();
		contatoDAO.adiciona(contato);
	
		

	}

}
