package br.edu.fapi.poo.SolutionMakers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.topico.dao.impl.TopicoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.usuario.dao.impl.UsuarioDAOImpl;
import br.edu.fapi.poo.SolutionMakers.usuario.model.Usuario;
import br.edu.fapi.poo.SolutionMakers.usuario.service.LoginService;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TopicoDAOImpl topicodaoimpl = new TopicoDAOImpl();
		req.setAttribute("topicos", topicodaoimpl.listarUltimos10());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
