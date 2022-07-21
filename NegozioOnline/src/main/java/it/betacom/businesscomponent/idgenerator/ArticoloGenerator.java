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

public class ArticoloGenerator implements IdGeneratorInterface, DAOConstants {

	private static ArticoloGenerator idGen;
	private Connection conn;

	private ArticoloGenerator() throws ClassNotFoundException, IOException, NamingException, SQLException {
		conn = DBAccess.getConnection();
	}

	public static ArticoloGenerator getInstance() throws ClassNotFoundException, IOException, NamingException, SQLException {
		if (idGen == null)
			idGen = new ArticoloGenerator();
		return idGen;
	}

	@Override
	public long getNextId() throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ARTICOLOSEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}

}
