package br.livraria.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.livraria.entidade.Livro;
import br.livraria.jdbc.LivroDAO;

@WebServlet("/livrocontroller")
public class livroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public livroController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("Metodo GET");
    	
    	PrintWriter pw = resp.getWriter();
    	
    	LivroDAO livrodao = new LivroDAO();
    	List<Livro> lista = livrodao.listarTodos();
    	
    	String html = "<html> <body> <table border='1' >";
    	html += "<tr> <td>Id</td> <td>Nome</td> <td>Quantidade de Páginas</td> <td>Tema</td> </tr>";
    	
    	for(Livro livros : lista){
    		html += "<tr> <td>"+ livros.getIdLivro() +"</td> <td> " + livros.getNomeLivro()+ " </td> "
    				+ "<td>"+ livros.getQuantidadePaginas() +" </td> <td> "+ livros.getTemaLivro()+" </td> </tr>";  	
    	}
    	
    	html+= "</table>";
    	
    	html+= "<br><a href='index.html'> Voltar a página inicial</a> </body> </html>";
    	
    	pw.println(html);
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Metodo POST");
		
		PrintWriter pw = response.getWriter();
		
		String nomeLivro = request.getParameter("nomeLivro");
		String qntPaginas = request.getParameter("qntPag");
		String temaLivro = request.getParameter("temaLivro");
		
		Livro livro = new Livro();
		livro.setNomeLivro(nomeLivro);
		livro.setQuantidadePaginas(Integer.parseInt(qntPaginas));
		livro.setTemaLivro(temaLivro);
		
		LivroDAO livrodao = new LivroDAO();
		livrodao.cadastrarLivro(livro);
		
		request.getRequestDispatcher("sucesso-cadastro.html").forward(request, response);
		//doGet(request, response);
	}

}
