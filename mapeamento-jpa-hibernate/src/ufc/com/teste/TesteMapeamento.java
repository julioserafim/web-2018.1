package ufc.com.teste;



import java.util.ArrayList;
import java.util.List;

import ufc.com.dao.ProprietarioDAO;
import ufc.com.dao.VeiculoDAO;
import ufc.com.model.Proprietario;
import ufc.com.model.Veiculo;

public class TesteMapeamento {

	public static void main(String[] args) {
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
	
		
		
		Proprietario proprietario = new Proprietario();
		proprietario.setEmail("email");
		proprietario.setNome("Julio");
		proprietario.setTelefone("97756431");
		//proprietario.setVeiculos(veiculos);
		proprietarioDAO.adicionar(proprietario);
		
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("WV");
		veiculo.setModelo("Gol");
		veiculo.setValor(1200.56);
		veiculo.setProprietario(proprietario);
		veiculoDAO.adicionar(veiculo);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setFabricante("Mitsubishi");
		veiculo2.setModelo("Eclipse");
		veiculo2.setValor(1200.56);
		veiculo2.setProprietario(proprietario);
		veiculoDAO.adicionar(veiculo2);
		
		Veiculo veiculo3 = new Veiculo();
		veiculo3.setFabricante("Mitsubishi");
		veiculo3.setModelo("Miata");
		veiculo3.setValor(1200.56);
		veiculoDAO.adicionar(veiculo3);
		
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(veiculo);
		veiculos.add(veiculo2);
		veiculos.add(veiculo3);
		
		
		
		
		/*Proprietario proprietario2 = proprietarioDAO.buscarPorId(2L);
		
		System.out.println("Proprietario: " + proprietario2.getVeiculo().getValor());*/
		
		

	}

}
