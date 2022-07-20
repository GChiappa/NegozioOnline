package com.gio.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gio.architecture.dao.DAOConstants;
import com.gio.architecture.dao.DAOException;
import com.gio.architecture.dbaccess.DBAccess;

public class ArticoloGenerator implements IdGeneratorInterface, DAOConstants {

	private static ArticoloGenerator idGen;
	private Connection conn;

	private ArticoloGenerator() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public static ArticoloGenerator getInstance() throws ClassNotFoundException, DAOException, IOException {
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
