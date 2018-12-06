package br.edu.fapi.poo.SolutionMakers.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.resposta.dao.impl.RespostaDAOImpl;
import br.edu.fapi.poo.SolutionMakers.resposta.model.Resposta;
import br.edu.fapi.poo.SolutionMakers.discussao.dao.impl.DiscussaoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.discussao.model.Discussao;

@WebServlet(urlPatterns = "/controllerDiscussao")
public class ControllerDiscussaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		
		if ("ViewDiscussao".equalsIgnoreCase(acao)) {
			
			int discussaoID = Integer.parseInt(req.getParameter("discussaoID"));
			DiscussaoDAOImpl discussaodaoimpl = new DiscussaoDAOImpl();
			Discussao discussao = discussaodaoimpl.buscaPorID(discussaoID);
		
			req.setAttribute("discussao", discussao);
			
			req.getRequestDispatcher("pages/ViewDiscussao.jsp").forward(req, resp);
		}
		else if ("resposta".equalsIgnoreCase(acao)) {

			String conteudo = req.getParameter("conteudo");
			String usuarioNick = req.getParameter("usuarioNick");
			String discussaoids = req.getParameter("discussaoId");
			String usuario  = req.getParameter("usuarioId");
			String usuarioNivelAcessoStr = req.getParameter("usuarioNivelAcesso");
			
			int discussaoId = Integer.parseInt(discussaoids);
			int usuarioId = Integer.parseInt(usuario);
			int usuarioNivelAcesso = Integer.parseInt(usuarioNivelAcessoStr);
			
			RespostaDAOImpl.adicionarRespostaDISCUSSAO(conteudo,usuarioNick,discussaoId,usuarioId, usuarioNivelAcesso);
						
			DiscussaoDAOImpl discussaodaoimpl = new DiscussaoDAOImpl();
			Discussao discussao = discussaodaoimpl.buscaPorID(discussaoId);
		
			req.setAttribute("discussao", discussao);
			req.getRequestDispatcher("pages/ViewDiscussao.jsp").forward(req, resp);
			
		}
		else if ("criarDiscussao".equalsIgnoreCase(acao)) {

			String titulo = req.getParameter("titulo");
			String descricao = req.getParameter("descricao");
			String usuarioNick = req.getParameter("usuarioNick");
			String usuarioNivelAcessoStr = req.getParameter("usuarioNivelAcesso");
			
			int usuarioNivelAcesso = Integer.parseInt(usuarioNivelAcessoStr);
			
			int discussaoId = DiscussaoDAOImpl.criarDiscussao( titulo, descricao, usuarioNick, usuarioNivelAcesso);
						
			DiscussaoDAOImpl discussaodaoimpl = new DiscussaoDAOImpl();
			Discussao discussao = discussaodaoimpl.buscaPorID(discussaoId);
		
			req.setAttribute("discussao", discussao);
			
			req.getRequestDispatcher("pages/ViewDiscussao.jsp").forward(req, resp);
			
		}
		else if("editarResposta".equalsIgnoreCase(acao)) {
			String respostaIdSrt = req.getParameter("respostaId");
			int respostaId = Integer.parseInt(respostaIdSrt);
			Resposta resposta = RespostaDAOImpl.buscaPorIdDISCUSSAO(respostaId);
			req.setAttribute("resposta", resposta);
			req.getRequestDispatcher("WEB-INF/EditarRespostaD.jsp").forward(req, resp);
		}
		else if("editarRespostaConfirm".equalsIgnoreCase(acao)) {
			String conteudo = req.getParameter("conteudo");
			String editorIdStr = req.getParameter("editorId");
			String respostaIdStr = req.getParameter("respostaId");
			
			int editorId = Integer.parseInt(editorIdStr);
			int respostaId = Integer.parseInt(respostaIdStr);
			
			RespostaDAOImpl.editarRespostaDISCUSSAO(conteudo,editorId,respostaId);
						
			req.getRequestDispatcher("index").forward(req, resp);
		}
		else {
			resp.sendRedirect("index");
		}
	}
}
