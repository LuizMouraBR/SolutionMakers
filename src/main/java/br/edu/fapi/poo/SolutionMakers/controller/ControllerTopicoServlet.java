package br.edu.fapi.poo.SolutionMakers.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.topico.dao.impl.TopicoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.topico.model.Topico;

@WebServlet(urlPatterns = "/controllerTopico")
public class ControllerTopicoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		
		if ("ViewTopico".equalsIgnoreCase(acao)) {
			
			//Receber o ID do tópico que a página vai exibir.
			int topicoID = Integer.parseInt(req.getParameter("topicoID"));
			
			//Instanciar a classe que fará a busca e retornará o tópico
			//_ utilizando o ID que foi recebido da página.
			TopicoDAOImpl topicodaoimpl = new TopicoDAOImpl();
			Topico topico = topicodaoimpl.buscaPorID(topicoID);
		
			//Atribuir o tópico instanciado para que a página possa exibir.
			req.setAttribute("topico", topico);
			
			req.getRequestDispatcher("pages/ViewTopico.jsp").forward(req, resp);
		}
		else if ("buscaPalavraChave".equalsIgnoreCase(acao)) {
			
			//Receber a strng da busca.
			String busca = req.getParameter("pChave");
			
			//Instanciar a classe que fará a busca e retornará a lista de tópicos.
			TopicoDAOImpl topicodaoimpl = new TopicoDAOImpl();
			List<Topico> listTopico = topicodaoimpl.buscaPorTag(busca);
			
			//Atribuir a string da busca para que a página possa exibir.
			//_ o que foi buscado pelo usuário.
			req.setAttribute("busca", busca);
			
			//Atribuir a lista de tópicos que possuem a palavra chave.
			req.setAttribute("topicos", listTopico);
			
			req.getRequestDispatcher("WEB-INF/resultadoBusca.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("index.jsp");
		}
	}
}
