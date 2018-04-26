import java.util.ArrayList;

public class PessoaDAO {
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public void cadastrarPessoas() {
		pessoas.add(new Pessoa("julio","123"));
		pessoas.add(new Pessoa("jonas", "1234"));
	}
	
	public Pessoa buscarPessoa(String login, String senha) {
		for (Pessoa pessoa : pessoas) {
			if(pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
				return pessoa;
			}
		}
		
		
		return null;
	}

}
