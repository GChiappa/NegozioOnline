package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.ImmagineDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Immagine;

public class ImmagineBC {

	private Connection conn;

	public ImmagineBC() throws ClassNotFoundException, IOException, NamingException, SQLException {
		conn = DBAccess.getConnection();
	}

	public Immagine findById(long id) throws DAOException {
		try {
			return ImmagineDAO.getFactory().findById(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
