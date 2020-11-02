package br.com.exemplo.until;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String login = "root";
			String senha = "";
			String url = "jdbc:mysql://localhost:3306/gerencial_aulas";
			return DriverManager.getConnection(url,login,senha);
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}