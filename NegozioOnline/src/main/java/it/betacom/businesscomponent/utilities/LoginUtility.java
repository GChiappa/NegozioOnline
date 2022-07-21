package it.betacom.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;

public class LoginUtility implements DAOConstants {

	// non serve implementare un dao perche non si ha un modello
	private Connection conn;

	public LoginUtility() throws ClassNotFoundException, IOException, NamingException, SQLException {
		conn = DBAccess.getConnection();
	}

	// Si puo ritornare direttamente la password
	public String getUserPass(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_PASSWORD_UTENTE);

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			else
				return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public String getAdminPass(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_PASSWORD_AMMINISTRATORE);

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			else
				return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	// Altrimenti si controlla se la password coincide
}
