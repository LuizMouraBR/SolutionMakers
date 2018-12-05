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
		if(checkUser(req) != null) {
			req.setAttribute("usuarioEmSessao", checkUser(req) );
			System.out.println("Usu�rio " + checkUser(req).getEmail() + " est� acessando: " + uri);
		}
		else {
			System.out.println("Usu�rio an�nimo est� acessando: " + uri);
		}
		chain.doFilter(request, response);
	}

	private Usuario checkUser(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioEmSessao");
		if (usuario != null) {
			return usuario;
		}
		return null;
	}
	
	public void doGet(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setAttribute("usuarioEmSessao", checkUser(req) );
	}
	
	public void doPost(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setAttribute("usuarioEmSessao", checkUser(req) );
	}

}
