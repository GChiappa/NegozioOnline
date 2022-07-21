package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.Ordine_ArticoloDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Ordine_Articolo;

public class Ordine_ArticoloBC {

	private Connection conn;

	public Ordine_ArticoloBC() throws ClassNotFoundException, IOException, NamingException, SQLException {
		conn = DBAccess.getConnection();
	}

	// Validati tramite JS
	public void create(Ordine_Articolo oa) throws DAOException {
		try {
			Ordine_ArticoloDAO.getFactory().create(conn, oa);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
