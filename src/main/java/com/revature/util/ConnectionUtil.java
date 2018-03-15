package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.model.Customer;

/* Final utility class to obtain connections in a modular way */
public final class ConnectionUtil {

	private static Logger logger = Logger.getLogger(ConnectionUtil.class);

	/* Make Tomcat now which database driver to use */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			logger.warn("Exception thrown adding oracle driver.", e);
		}
	}

	/* Get connection to JDBC */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@orcl.cgpqwihneghe.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "LOGIN_TEST_DB";
		String password = "p4ssw0rd";

		return DriverManager.getConnection(url, username, password);
	}
	
//	public static void main(String[] args) {
//		try (Connection connection = ConnectionUtil.getConnection()) {
//			String sql = "INSERT INTO CUSTOMER(C_FIRST_NAME, C_LAST_NAME, C_USERNAME, C_PASSWORD) "
//					+ "VALUES(?,?,?,?)";
//			int parameterIndex = 0;
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setString(++parameterIndex, "James");
//			statement.setString(++parameterIndex, "Kempf");
//			statement.setString(++parameterIndex, "jamesk4321");
//			statement.setString(++parameterIndex, "p4ssw0rd");
//			
//			if (statement.executeUpdate() > 0) {
//				System.out.println("Insert Success");
//			}
//			
//			sql = "SELECT * FROM CUSTOMER";
//			statement = connection.prepareStatement(sql);
//			
//			ResultSet result = statement.executeQuery();
//			
//			while (result.next()) {
//				System.out.println(new Customer(
//						result.getInt("C_ID"),
//						result.getString("C_FIRST_NAME"),
//						result.getString("C_LAST_NAME"),
//						result.getString("C_USERNAME"),
//						result.getString("C_PASSWORD")
//						).toString());
//			}
//			
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//	}
}
