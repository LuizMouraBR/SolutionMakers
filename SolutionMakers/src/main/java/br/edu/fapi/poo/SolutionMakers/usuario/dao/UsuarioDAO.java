package br.edu.fapi.poo.SolutionMakers.usuario.dao;

import java.util.List;

import br.edu.fapi.poo.SolutionMakers.usuario.model.Usuario;

public interface UsuarioDAO {
	
	Usuario buscaConta(Usuario usuario);
	
	List<Usuario> listarTodos();
}
