package it.betacom.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;

public class OrdineGenerator implements IdGeneratorInterface, DAOConstants {

	private static OrdineGenerator idGen;
	private Connection conn;

	private OrdineGenerator() throws ClassNotFoundException, IOException, NamingException, SQLException {
		conn = DBAccess.getConnection();
	}

	public static OrdineGenerator getInstance() throws ClassNotFoundException, IOException, NamingException, SQLException {
		if (idGen == null)
			idGen = new OrdineGenerator();
		return idGen;
	}

	@Override
	public long getNextId() throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ORDINESEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
		return id;
	}

}
