

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class EfetuarLogin
 */
@WebServlet("/efetuarLogin")
public class EfetuarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EfetuarLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.cadastrarPessoas();
		
		Pessoa pessoa = pessoaDAO.buscarPessoa(login, senha);
		
		if(pessoa!=null) {
			sessao.setAttribute("usuarioLogado", login);
			response.sendRedirect("telaInicial");
			
		}else {
			response.sendRedirect("loginForm");
		}
		
	}

}
