package ufc.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ufc.com.model.Veiculo;



public class VeiculoDAO {
	
	
		
		//adicionar, deletar, atualizar e listar CRUD
		
		public void adicionar(Veiculo veiculo) {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
			EntityManager manager = fabrica.createEntityManager();
			
			manager.getTransaction().begin();
			manager.persist(veiculo);
			manager.getTransaction().commit();
			
			fabrica.close();
			manager.close();
		
		}
		
		public void alterar(Veiculo veiculo) {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
			EntityManager manager = fabrica.createEntityManager();
			
			manager.getTransaction().begin();
			manager.merge(veiculo);
			manager.getTransaction().commit();
			
			fabrica.close();
			manager.close();
		
		}
		
		public void remover(Long id) {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
			EntityManager manager = fabrica.createEntityManager();
			
			manager.getTransaction().begin();
			Veiculo veiculo = manager.find(Veiculo.class, id);
			manager.remove(veiculo);
			manager.getTransaction().commit();
			
			fabrica.close();
			manager.close();
		
		}
		
		public Veiculo buscarPorId(Long id) {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mapeamento-jpa-hibernate");
			EntityManager manager = fabrica.createEntityManager();
			
			Veiculo veiculo = manager.find(Veiculo.class, id);
			
			fabrica.close();
			manager.close();
			
			return veiculo;
		}
		
		

}


