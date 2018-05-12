package br.ufc.test;

import java.util.Calendar;

import br.ufc.jdbc.dao.ContatoDAO;
import br.ufc.modelo.Contato;

public class TestAlterar {
	public static void main(String[] args) {
		Contato contato = new Contato();
		
		contato.setNome("Julio Martins");
		contato.setEmail("julioserafimM@hotmail.com");
		contato.setEndereco("Rua Joaquim Custodio");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId(3L);
		
		ContatoDAO contatoDAO  = new ContatoDAO();
		contatoDAO.alterar(contato);
		
		contatoDAO.remove(contato);
	
	}
}