package br.edu.fapi.poo.SolutionMakers.resposta.model;

public class Resposta {

	private int id;
	private int usuarioId;
	private String usuarioNick;
	private int usuarioNivelAcesso;
	private String conteudo;
	private String dataPostagem;
	private boolean isEditada;
	private String dataEdicao;
	private int editorId;
	
	
	public int getUsuarioNivelAcesso() {
		return usuarioNivelAcesso;
	}
	public void setUsuarioNivelAcesso(int usuarioNivelAcesso) {
		this.usuarioNivelAcesso = usuarioNivelAcesso;
	}
	public String getUsuarioNick() {
		return usuarioNick;
	}
	public void setUsuarioNick(String usuarioNick) {
		this.usuarioNick = usuarioNick;
	}
	public String getDataPostagem() {
		return dataPostagem;
	}
	public void setDataPostagem(String dataPostagem) {
		this.dataPostagem = dataPostagem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public boolean isEditada() {
		return isEditada;
	}
	public void setEditada(boolean isEditada) {
		this.isEditada = isEditada;
	}
	public String getDataEdicao() {
		return dataEdicao;
	}
	public void setDataEdicao(String dataEdicao) {
		this.dataEdicao = dataEdicao;
	}
	public int getEditorId() {
		return editorId;
	}
	public void setEditorId(int editorId) {
		this.editorId = editorId;
	}
	
	
	
}
