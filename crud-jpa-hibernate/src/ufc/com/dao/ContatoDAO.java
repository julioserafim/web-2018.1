package ufc.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ufc.com.model.Contato;

public class ContatoDAO {
	
	public void inserirContato(Contato contato) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
	public void alterarContato(Contato contato) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	}
	
	public List<Contato> listar(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		List<Contato> contatos = manager.createQuery("select c from Contato as c", Contato.class).getResultList();
		manager.close();
		fabrica.close();
		
		return contatos;
		
	}
	
	public Contato recuperar(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Contato contato = manager.find(Contato.class, id);
		
		manager.close();
		fabrica.close();
		
		return contato;
	}
	
	public void remove(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Contato contato = manager.find(Contato.class, id);
		
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();
		
	}
	

}
