package br.edu.fapi.poo.SolutionMakers.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.empresa.dao.impl.EmpresaDAOImpl;
import br.edu.fapi.poo.SolutionMakers.empresa.model.Empresa;
import br.edu.fapi.poo.SolutionMakers.topico.dao.impl.TopicoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.topico.model.Topico;
import br.edu.fapi.poo.SolutionMakers.usuario.dao.impl.UsuarioDAOImpl;
import br.edu.fapi.poo.SolutionMakers.usuario.model.Usuario;

@WebServlet(urlPatterns = "/controllerUsuario")
public class ControllerUsuario extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");

				
		if ("cadastrarUsuarios".equalsIgnoreCase(acao)) {
									
					req.getRequestDispatcher("WEB-INF/Cadastro.jsp").forward(req, resp);
		
		} else if ("cadastraUsuario".equalsIgnoreCase(acao)) {
			
			String nickname = req.getParameter("nickname");
			String email = req.getParameter("email");
			String bio = req.getParameter("bio");
									
			UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
			Usuario usuario = usuarioDAOImpl.buscaPorNick(nickname);
			
			UsuarioDAOImpl.criarUsuario(nickname, email, bio);
		
			req.setAttribute("usuario", usuario);
			req.getRequestDispatcher("WEB-INF/Cadastro.jsp").forward(req, resp);
			
			
			
		}

	}
	

}
