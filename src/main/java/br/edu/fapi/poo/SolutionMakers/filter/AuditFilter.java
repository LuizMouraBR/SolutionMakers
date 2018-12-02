package br.edu.fapi.poo.SolutionMakers.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.edu.fapi.poo.SolutionMakers.usuario.model.Usuario;


@WebFilter(urlPatterns = "/*")
public class AuditFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		req.setAttribute("usuario.logado", checkUser(req) );
		System.out.println("Usuário " + checkUser(req) + " está acessando a URI: " + uri);

		chain.doFilter(request, response);
	}

	private String checkUser(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
		if (usuario == null) {
			return "<deslogado>";
		}
		return usuario.getEmail();
	}
	
	public void doGet(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setAttribute("usuario.logado", checkUser(req) );
	}
	
	public void doPost(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setAttribute("usuario.logado", checkUser(req) );
	}

}
