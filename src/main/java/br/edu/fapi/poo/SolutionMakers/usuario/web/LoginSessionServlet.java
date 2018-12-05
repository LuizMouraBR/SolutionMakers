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

@WebServlet(urlPatterns = "/login")
public class LoginSessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginService();

	protected void doExecute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Receber o que foi digitado pelo usu�rio atrav�s do 'req.getParameter()'
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		// Instanciar um novo objeto Usu�rio e colocar as informa��es de login nele.
		// Isso ir� permitir que ele seja buscado e comparado.
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);

		// O m�todo loginService.login() compara este usu�rio com todos os cadastrados
		// _na base de dados
		boolean logado = loginService.login(usuario);

		// Retornar um usu�rio utilizando email como chave de busca.
		usuario = UsuarioDAOImpl.buscaPorEmail(email);

		if (logado) {

			usuario = loginService.usuarioLogado(usuario);
			
			req.getSession().setAttribute("usuarioEmSessao", usuario);
			
			// Se houver um ultimo acesso � conta, ent�o ir para uma p�gina.
			if (usuario.getUltimoAcesso() != null) {

				// Se o usu�rio for um Admin ou Operador, ent�o registrar no log de acesso.
				if (usuario.getNivelAcesso() == 1 || usuario.getNivelAcesso() == 2) {
					UsuarioDAOImpl.adicionarLogAcesso(usuario.getEmail(), "Login");
				}

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/IndexRedirect.jsp");
				requestDispatcher.forward(req, resp);
			}

			// Se n�o houver um ultimo acesso significa que � a primeira vez que este
			// usu�rio faz login em sua conta
			// Portanto, ele � redirecionado � pagina de troca de senha.
			else {

				UsuarioDAOImpl.adicionarLogAcesso(usuario.getEmail(), "Troca de Senha");
				req.setAttribute("email", usuario.getEmail());
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/trocaSenha.jsp");
				requestDispatcher.forward(req, resp);
			}
		}

		// Caso n�o haja um usu�rio com tais informa��es de login
		else {
			req.setAttribute("erro", "Nome de usu�rio ou senha incorretos.");
			resp.sendRedirect("pages/login.jsp");

			//Caso exista um usu�rio, ent�o registrar a tentativa errada de aceso.
			if (UsuarioDAOImpl.buscaPorEmail(email) != null) {
				UsuarioDAOImpl.adicionarLogAcesso(usuario.getEmail(), "Tentativa errada de acesso");
			}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doExecute(req, resp);
	}

}
