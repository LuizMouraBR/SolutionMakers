package br.edu.fapi.poo.SolutionMakers.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	public static String url = "jdbc:mysql://localhost:3306/solutionmakers";
	public static String usuario = "root";
	public static String senha = "";

	public static Connection connection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, usuario, senha);
	}

	public static Connection doGet() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, usuario, senha);
	}
}
