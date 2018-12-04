package br.edu.fapi.poo.SolutionMakers.resposta.dao;

import java.util.List;

import br.edu.fapi.poo.SolutionMakers.resposta.model.Resposta;

public interface RespostaDAO {

	public List<Resposta> listarTodas(int topicoId);
	
}
