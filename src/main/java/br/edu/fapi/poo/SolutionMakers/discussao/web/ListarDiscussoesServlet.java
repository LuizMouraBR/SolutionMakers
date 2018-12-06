package br.edu.fapi.poo.SolutionMakers.discussao.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.discussao.model.Discussao;
import br.edu.fapi.poo.SolutionMakers.discussao.service.DiscussaoService;

@WebServlet(urlPatterns = "/listarDiscussoes")
public class ListarDiscussoesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DiscussaoService discussoesService = new DiscussaoService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Discussao> listDiscussoes = discussoesService.listarTodos();
		req.setAttribute("discussoes", listDiscussoes);
		req.getRequestDispatcher("pages/discussoes.jsp").forward(req, resp);
	}
}
