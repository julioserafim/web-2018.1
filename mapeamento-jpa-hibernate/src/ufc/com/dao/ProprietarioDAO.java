package ufc.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ufc.com.model.Proprietario;

public class ProprietarioDAO {
	

	
	public void adicionar(Proprietario proprietario) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(proprietario);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	
	}
	
	public void alterar(Proprietario proprietario) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(proprietario);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	
	}
	
	public void remover(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		Proprietario proprietario = manager.find(Proprietario.class, id);
		manager.remove(proprietario);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
	
	}
	
	public Proprietario buscarPorId(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Proprietario proprietario = manager.find(Proprietario.class, id);
		
		fabrica.close();
		manager.close();
		
		return proprietario;
	}
	

}
