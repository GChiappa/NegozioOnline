package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.gio.architecture.dao.DAOException;
import com.gio.architecture.dao.ImmagineDAO;
import com.gio.architecture.dbaccess.DBAccess;
import com.gio.businesscomponent.model.Immagine;

public class ImmagineBC {

	private Connection conn;

	public ImmagineBC() throws ClassNotFoundException, DAOException, IOException {
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
