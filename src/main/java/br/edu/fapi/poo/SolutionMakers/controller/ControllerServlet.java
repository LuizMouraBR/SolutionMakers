package br.edu.fapi.poo.SolutionMakers.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.SolutionMakers.cliente.dao.impl.ClienteDAOImpl;
import br.edu.fapi.poo.SolutionMakers.cliente.model.Cliente;
import br.edu.fapi.poo.SolutionMakers.discussao.dao.impl.DiscussaoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.empresa.dao.impl.EmpresaDAOImpl;
import br.edu.fapi.poo.SolutionMakers.empresa.model.Empresa;
import br.edu.fapi.poo.SolutionMakers.logAcesso.dao.impl.LogAcessoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.logAcesso.model.LogAcesso;
import br.edu.fapi.poo.SolutionMakers.logAcoes.dao.impl.LogAcoesDAOImpl;
import br.edu.fapi.poo.SolutionMakers.logAcoes.model.LogAcoes;
import br.edu.fapi.poo.SolutionMakers.operador.dao.impl.OperadorDAOImpl;
import br.edu.fapi.poo.SolutionMakers.operador.model.Operador;
import br.edu.fapi.poo.SolutionMakers.topico.dao.impl.TopicoDAOImpl;
import br.edu.fapi.poo.SolutionMakers.topico.model.Topico;
import br.edu.fapi.poo.SolutionMakers.usuario.dao.impl.UsuarioDAOImpl;
import br.edu.fapi.poo.SolutionMakers.usuario.model.Usuario;

@WebServlet(urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");

		if ("listarTopicos".equalsIgnoreCase(acao)) {
			TopicoDAOImpl topicodaoimpl = new TopicoDAOImpl();
			req.setAttribute("topicos", topicodaoimpl.listarTodos("maisRecentes"));
			req.getRequestDispatcher("pages/topicos.jsp").forward(req, resp);
		}
		else if ("listarDiscussoes".equalsIgnoreCase(acao)) {
			DiscussaoDAOImpl discussaodaoimpl = new DiscussaoDAOImpl();
			req.setAttribute("discussoes", discussaodaoimpl.listarTodos("maisRecentes"));
			req.getRequestDispatcher("pages/discussoes.jsp").forward(req, resp);
		}
		else if("conta".equalsIgnoreCase(acao)) {
			
			String userNick = req.getParameter("userNick");
			
			UsuarioDAOImpl usuariodaoimpl = new UsuarioDAOImpl();
			Usuario usuario = usuariodaoimpl.buscaPorNick(userNick);
			
			req.setAttribute("usuario", usuario);
			req.getRequestDispatcher("pages/MinhaConta.jsp").forward(req, resp);
		}
		else if("Administracao".equalsIgnoreCase(acao)) {
			req.getRequestDispatcher("WEB-INF/Administracao.jsp").forward(req, resp);
		}
		else if("GerenciarOperadores".equalsIgnoreCase(acao)) {
			req.getRequestDispatcher("WEB-INF/GerenciarOperadores.jsp").forward(req, resp);
		}
		else if("AdicionarOperador".equalsIgnoreCase(acao)) {
			req.getRequestDispatcher("WEB-INF/AdicionarOperador.jsp").forward(req, resp);
		}
		else if("adicionarOperadorConfirm".equalsIgnoreCase(acao)) {
			String nickname = req.getParameter("nickname");
			String email = req.getParameter("email");
			String bio = req.getParameter("bio");
		
			OperadorDAOImpl.adicionarOperador(nickname, email, bio);
			
			req.getRequestDispatcher("WEB-INF/GerenciarOperadores.jsp").forward(req, resp);
		}
		else if("ExcluirOperador".equalsIgnoreCase(acao)) {
			String usuarioIds = req.getParameter("usuarioId");
			
			int usuarioId = Integer.parseInt(usuarioIds);
			
			OperadorDAOImpl.excluirOperador(usuarioId);
			
			req.getRequestDispatcher("WEB-INF/GerenciarOperadores.jsp").forward(req, resp);
		}
		else if("ExcluirCliente".equalsIgnoreCase(acao)) {
			String usuarioIds = req.getParameter("usuarioId");
			
			int usuarioId = Integer.parseInt(usuarioIds);
			
			ClienteDAOImpl.excluirCliente(usuarioId);
			
			req.getRequestDispatcher("WEB-INF/FuncoesOperador.jsp").forward(req, resp);
		}
		else if("ListarOperador".equalsIgnoreCase(acao)) {
			OperadorDAOImpl operadorimpl = new OperadorDAOImpl();
			List<Operador> listOperador = operadorimpl.listarTodos();
			req.setAttribute("listOperador", listOperador);
			req.getRequestDispatcher("WEB-INF/ListarOperador.jsp").forward(req, resp);
		}
		else if("ListarCliente".equalsIgnoreCase(acao)) {
			ClienteDAOImpl clienteimpl = new ClienteDAOImpl();
			List<Cliente> listCliente = clienteimpl.listarTodos();
			req.setAttribute("listCliente", listCliente);
			req.getRequestDispatcher("WEB-INF/ListarCliente.jsp").forward(req, resp);
		}
		else if("FuncoesOperador".equalsIgnoreCase(acao)) {
			req.getRequestDispatcher("WEB-INF/FuncoesOperador.jsp").forward(req, resp);
		}
		else if("AdicionarCliente".equalsIgnoreCase(acao)) {
			EmpresaDAOImpl empresaimpl = new EmpresaDAOImpl();
			List<Empresa> listEmpresas = empresaimpl.listarTodos();
			req.setAttribute("empresas", listEmpresas);
			req.getRequestDispatcher("WEB-INF/AdicionarCliente.jsp").forward(req, resp);
		}
		else if("adicionarClienteConfirm".equalsIgnoreCase(acao)) {
			String nickname = req.getParameter("nickname");
			String email = req.getParameter("email");
			String bio = req.getParameter("bio");
			String nomeCompleto = req.getParameter("nomeCompleto");
			String rg = req.getParameter("rg");
			String cpf = req.getParameter("cpf");
			String pis = req.getParameter("pis");
			String empresaIdStr = req.getParameter("empresaId");
			
			int empresaId = Integer.parseInt(empresaIdStr);
		
			ClienteDAOImpl.adicionarCliente(nickname,email,bio,nomeCompleto,rg,cpf,pis,empresaId);
			
			req.getRequestDispatcher("WEB-INF/FuncoesOperador.jsp").forward(req, resp);
		}
		else if("UsuariosBloqueados".equalsIgnoreCase(acao)) {
					
			UsuarioDAOImpl usuariodaoimpl = new UsuarioDAOImpl();
			List<Usuario> usuarios = usuariodaoimpl.buscaBloqueados();
			
			req.setAttribute("listUsuariosBloq", usuarios);
			
			req.getRequestDispatcher("WEB-INF/UsuariosBloqueados.jsp").forward(req, resp);
		}
		else if("LogAcesso".equalsIgnoreCase(acao)) {
			LogAcessoDAOImpl logacesso = new LogAcessoDAOImpl();
			List<LogAcesso> logsAcesso = logacesso.listar();	
			req.setAttribute("logsAcesso", logsAcesso);
			req.getRequestDispatcher("WEB-INF/LogAcesso.jsp").forward(req, resp);
		}
		else if("LogAcoes".equalsIgnoreCase(acao)) {
			LogAcoesDAOImpl logsAcoesimpl = new LogAcoesDAOImpl();
			List<LogAcoes> logsAcoes = logsAcoesimpl.listar();	
			req.setAttribute("logsAcoes", logsAcoes);
			req.getRequestDispatcher("WEB-INF/LogAcoes.jsp").forward(req, resp);
		}
		else if ("resultadoBusca".equalsIgnoreCase(acao)) {
			
			String busca = req.getParameter("busca");
			
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
		else if ("loginPage".equalsIgnoreCase(acao)) {
			resp.sendRedirect("pages/login.jsp");
		} 
		else {
			resp.sendRedirect("index");
		}
	}
}