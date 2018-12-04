package br.edu.fapi.poo.SolutionMakers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.operacoes.ColetorData;
import br.edu.fapi.poo.SolutionMakers.topico.dao.impl.TopicoDAOImpl;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TopicoDAOImpl topicodaoimpl = new TopicoDAOImpl();
		req.setAttribute("topicos", topicodaoimpl.listarUltimos10());
		req.setAttribute("data", ColetorData.dateExtense().toString());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
