package br.ufc.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		String url="jdbc:mysql://localhost/banco_teste"; 
		try {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // linha que que se comunica como o driver
		return DriverManager.getConnection(url,"julio","admin");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
