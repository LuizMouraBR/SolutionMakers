package br.edu.fapi.poo.SolutionMakers.usuario.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.operacoes.ColetorData;
import br.edu.fapi.poo.SolutionMakers.usuario.dao.impl.UsuarioDAOImpl;

@WebServlet(urlPatterns = "/TrocaSenha")
public class TrocaSenhaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email").toString();
		String senha1 = req.getParameter("senha1").toString();
		String senha2 = req.getParameter("senha2").toString();
		
		if (senha1.equals(senha2)) {
			
			UsuarioDAOImpl.adicionarLogAcesso(email, "Primeiro acesso de " + email);
			UsuarioDAOImpl.trocaSenha(email, senha2);
			UsuarioDAOImpl.atualizaUltimoAcesso(email);

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(req, resp);
			
		}else {

			req.setAttribute("erro", "As senhas não coincidem.");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/trocaSenha.jsp");
			requestDispatcher.forward(req, resp);
			
		}
		
	}
	
	
}
