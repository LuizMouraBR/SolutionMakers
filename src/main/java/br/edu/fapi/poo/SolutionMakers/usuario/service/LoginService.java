package br.edu.fapi.poo.SolutionMakers.usuario.service;

import br.edu.fapi.poo.SolutionMakers.usuario.dao.UsuarioDAO;
import br.edu.fapi.poo.SolutionMakers.usuario.dao.impl.UsuarioDAOImpl;
import br.edu.fapi.poo.SolutionMakers.usuario.model.Usuario;

public class LoginService {

	private UsuarioDAO usuarioDAO;

	public LoginService() {
		this.usuarioDAO = new UsuarioDAOImpl();
	}

	public LoginService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public boolean login(Usuario usuario) {
		Usuario busca = usuarioDAO.buscaConta(usuario);
		if (busca != null) {
			return true;
		}
		return false;
	}
	
	public Usuario usuarioLogado(Usuario usuario) {
		Usuario busca = usuarioDAO.buscaConta(usuario);
		if (busca != null) {
			return busca;
		}
		return null;
	}

}
