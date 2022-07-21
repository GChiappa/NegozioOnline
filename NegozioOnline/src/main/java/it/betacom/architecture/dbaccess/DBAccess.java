package it.betacom.architecture.dbaccess;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBAccess {
	private static Connection conn;
	private static DataSource dataSource;

	public static synchronized Connection getConnection() throws NamingException, SQLException {
		InitialContext contesto = new InitialContext();
		dataSource = (DataSource) contesto.lookup("java:/OracleDS");
		conn = dataSource.getConnection();
		return conn;
	}

	public static void closeConnection() throws SQLException {
		if (conn != null)
			conn.close();
	}
}