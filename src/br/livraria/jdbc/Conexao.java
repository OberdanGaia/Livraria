package br.livraria.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {

		Connection con = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/livraria", "postgres", "admin");
			System.out.println("Conectado ao DB com sucesso");
		
		} catch (SQLException e) {
			System.out.println("Falha na conex�o: " + e.getMessage());
		
		} catch (ClassNotFoundException e) {
			System.out.println("Driver n�o encontrado");
			e.printStackTrace();
		}
		return con;
	}

}
