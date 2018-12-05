package br.edu.fapi.poo.SolutionMakers.operador.model;

public class Operador {

	private int id;
	private int ticketsResolvidos;
	private int usuarioId;
	private String usuarioNickname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTicketsResolvidos() {
		return ticketsResolvidos;
	}
	public void setTicketsResolvidos(int ticketsResolvidos) {
		this.ticketsResolvidos = ticketsResolvidos;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getUsuarioNickname() {
		return usuarioNickname;
	}
	public void setUsuarioNickname(String usuarioNickname) {
		this.usuarioNickname = usuarioNickname;
	}

}
