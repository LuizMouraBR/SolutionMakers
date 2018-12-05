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
import br.edu.fapi.poo.SolutionMakers.resposta.dao.impl.RespostaDAOImpl;
import br.edu.fapi.poo.SolutionMakers.topico.dao.impl.TopicoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.topico.model.Topico;

@WebServlet(urlPatterns = "/controllerEmpresa")
public class ControllerEmpresa extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");

				
		if ("criarEmpresa".equalsIgnoreCase(acao)) {
									
					req.getRequestDispatcher("WEB-INF/GerenciarEmpresas.jsp").forward(req, resp);
		
		}else if ("cadastraEmpresa".equalsIgnoreCase(acao)) {

			String nomeEmpresa = req.getParameter("nomeEmpresa");
			String razaoSocial = req.getParameter("razaoSocial");
			String cnpj = req.getParameter("cnpj");
			String endereco  = req.getParameter("endereco");
									
			EmpresaDAOImpl empresaDAOImpl = new EmpresaDAOImpl();
			Empresa empresa = empresaDAOImpl.buscaPorNome(nomeEmpresa);
			
			EmpresaDAOImpl.criarEmpresa(nomeEmpresa, razaoSocial, cnpj, endereco);
		
			req.setAttribute("empresa", empresa);
			req.getRequestDispatcher("pages/GerenciarEmpresas.jsp").forward(req, resp);
			
		}

	}
	

}
