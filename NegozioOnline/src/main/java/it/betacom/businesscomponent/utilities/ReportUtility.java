package it.betacom.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.NamingException;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;

public class ReportUtility implements DAOConstants {

	private Connection conn;

	public ReportUtility() throws ClassNotFoundException, IOException, NamingException, SQLException {
		conn = DBAccess.getConnection();
	}

	public Vector<String[]> getReport() throws DAOException {

		try {

			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_REPORT);
			ResultSetMetaData meta = rs.getMetaData();

			Vector<String[]> report = new Vector<String[]>();
			int nColonne = meta.getColumnCount();

			rs.beforeFirst();

			while (rs.next()) {
				String[] riga = new String[nColonne];
				for (int i = 0; i < nColonne; i++) {
					riga[i] = rs.getString(i + 1);
				}
				report.add(riga);
			}

			return report;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

}
