package br.edu.fapi.poo.SolutionMakers.topico.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.topico.model.Topico;
import br.edu.fapi.poo.SolutionMakers.topico.service.TopicoService;

@WebServlet(urlPatterns = "/listarTopicos")
public class ListarTopicosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TopicoService topicoService = new TopicoService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Topico> listTopicos = topicoService.listarTodos();
		req.setAttribute("topicos", listTopicos);
		req.getRequestDispatcher("pages/topicos.jsp").forward(req, resp);
	}
}
