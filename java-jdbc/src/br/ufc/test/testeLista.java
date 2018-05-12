package br.ufc.test;

import java.util.List;

import br.ufc.jdbc.dao.ContatoDAO;
import br.ufc.modelo.Contato;

public class testeLista {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getList(); 
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " +
			contato.getDataNascimento().getTime() + "\n");
			}
		
	}

}
