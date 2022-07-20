package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.UtenteDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Utente;

public class UtenteBC {

	private Connection conn;

	public UtenteBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	// Validati tramite JS
	public void create(Utente utente) throws DAOException {
		try {
			UtenteDAO.getFactory().create(conn, utente);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void update(Utente utente) throws DAOException {
		try {
			UtenteDAO.getFactory().update(conn, utente);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Utente findByUsername(String username) throws DAOException {
		try {
			return UtenteDAO.getFactory().findByUsername(conn, username);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
