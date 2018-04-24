

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FormularioLogin
 */
@WebServlet("/efetuarLogin")
public class FormularioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		String nome = request.getParameter("nome");
		String time = request.getParameter("time");
		
		Pessoa pessoa = new Pessoa(nome,time);
		sessao.setAttribute("pessoaFormulario", pessoa);
		
		out.println("Nome: " + pessoa.getNome() + " Time: " + pessoa.getTime());
		out.println("<br>");
		
		//sessao.removeAttribute("pessoaFormulario");
		
		Pessoa pessoa2 = (Pessoa) sessao.getAttribute("pessoaFormulario");
		out.println("Nome: " + pessoa2.getNome() + " Time: " + pessoa2.getTime());
		
		out.println("<br>");
		out.println("Id da sessão: " + sessao.getId());

		
		

		
		
		out.println("</body>");
		out.println("</html>");
	}

}
