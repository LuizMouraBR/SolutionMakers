package br.edu.fapi.poo.SolutionMakers.topico.model;

public class Topico {

	private int id;
	private String titulo;
	private String descricao;
	private String autor_nickname;
	private String data_postagem;
	private int respostas;
	private boolean resolvido;
	private String pChave1,pChave2,pChave3;
	
	public String getpChave1() {
		return pChave1;
	}
	public void setpChave1(String pChave1) {
		this.pChave1 = pChave1;
	}
	public String getpChave2() {
		return pChave2;
	}
	public void setpChave2(String pChave2) {
		this.pChave2 = pChave2;
	}
	public String getpChave3() {
		return pChave3;
	}
	public void setpChave3(String pChave3) {
		this.pChave3 = pChave3;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAutor_nickname() {
		return autor_nickname;
	}
	public void setAutor_nickname(String autor_nickname) {
		this.autor_nickname = autor_nickname;
	}
	public String getData_postagem() {
		return data_postagem;
	}
	public void setData_postagem(String data_postagem) {
		this.data_postagem = data_postagem;
	}
	public int getRespostas() {
		return respostas;
	}
	public void setRespostas(int respostas) {
		this.respostas = respostas;
	}
	public boolean isResolvido() {
		return resolvido;
	}
	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}
	
}
