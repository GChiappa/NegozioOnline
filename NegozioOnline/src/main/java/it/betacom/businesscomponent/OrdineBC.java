package com.gio.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.gio.architecture.dao.DAOException;
import com.gio.architecture.dao.OrdineDAO;
import com.gio.architecture.dbaccess.DBAccess;
import com.gio.businesscomponent.idgenerator.OrdineGenerator;
import com.gio.businesscomponent.model.Ordine;

public class OrdineBC {

	private Connection conn;

	public OrdineBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Ordine ordine) throws DAOException, ClassNotFoundException, IOException {

		try {
			if (ordine.getId_ordine() == 0) {
				ordine.setId_ordine(OrdineGenerator.getInstance().getNextId());
				ordine.setData(new Date());
				OrdineDAO.getFactory().create(conn, ordine);
			} else
				OrdineDAO.getFactory().update(conn, ordine);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(long id) throws DAOException {
		try {
			OrdineDAO.getFactory().delete(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Ordine findById(long id) throws DAOException {
		try {
			return OrdineDAO.getFactory().findById(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Ordine[] getAll() throws DAOException {
		try {
			return OrdineDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
