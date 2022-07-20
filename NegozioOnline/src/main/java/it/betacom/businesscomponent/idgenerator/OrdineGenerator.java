package com.gio.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gio.architecture.dao.DAOConstants;
import com.gio.architecture.dao.DAOException;
import com.gio.architecture.dbaccess.DBAccess;

public class OrdineGenerator implements IdGeneratorInterface, DAOConstants {

	private static OrdineGenerator idGen;
	private Connection conn;

	private OrdineGenerator() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public static OrdineGenerator getInstance() throws ClassNotFoundException, DAOException, IOException {
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
