package br.edu.fapi.poo.SolutionMakers.usuario.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.usuario.dao.impl.UsuarioDAOImpl;
import br.edu.fapi.poo.SolutionMakers.usuario.model.Usuario;
import br.edu.fapi.poo.SolutionMakers.usuario.service.LoginService;

@WebServlet(urlPatterns = "/logout")
public class LogoutSessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginService();

	protected void doExecute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().removeAttribute("usuarioEmSessao");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/Deslogar.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doExecute(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doExecute(req, resp);
	}

}
