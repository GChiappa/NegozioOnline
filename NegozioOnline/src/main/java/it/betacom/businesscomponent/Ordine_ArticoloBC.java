package com.gio.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.gio.architecture.dao.DAOException;
import com.gio.architecture.dao.Ordine_ArticoloDAO;
import com.gio.architecture.dbaccess.DBAccess;
import com.gio.businesscomponent.model.Ordine_Articolo;

public class Ordine_ArticoloBC {

	private Connection conn;

	public Ordine_ArticoloBC() throws ClassNotFoundException, DAOException, IOException {
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
