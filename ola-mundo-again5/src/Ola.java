

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ola
 */
@WebServlet("/Ola")
public class Ola extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<Pessoa> pessoas;
	PessoaDAO pessoaDAO = new PessoaDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ola() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		pessoas = pessoaDAO.adicionarPessoa();
		
		out.println("<ul>");
		
			for (Pessoa pessoa : pessoas) {
				out.println("<li>" + pessoa.getNome() + "|" + pessoa.getTime() + "</li>");
			}
		
		out.println("</ul>");
		
		out.println("Ola mundo");
			
		out.println("</body>");
		out.println("</html>");
	}

}
