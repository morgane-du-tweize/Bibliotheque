package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	
	private static DbConnect connect ;
	private Connection connection ;
	
	private DbConnect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque", username, password);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnector() throws SQLException {
		if (connect == null) {
			connect = new DbConnect();
		}
		else if (connect.getConnection().isClosed()) {
			connect = new DbConnect();
		}
		
		return connect.getConnection();
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection ;
	}

}
