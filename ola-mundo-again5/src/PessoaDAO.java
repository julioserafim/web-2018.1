import java.util.ArrayList;

public class PessoaDAO {
	ArrayList<Pessoa> pessoasDao = new ArrayList<Pessoa>();
	
	
	ArrayList<Pessoa> adicionarPessoa(){
		pessoasDao.add(new Pessoa("Julio","Corinthians"));
		pessoasDao.add(new Pessoa("Matheus", "Volta Redonda"));
		pessoasDao.add(new Pessoa("Jonas", "Corinthians"));
		
	           return pessoasDao;                                                 	
	           
	}

}
