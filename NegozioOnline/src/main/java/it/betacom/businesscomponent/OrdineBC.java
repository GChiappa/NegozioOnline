package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.OrdineDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.OrdineGenerator;
import it.betacom.businesscomponent.model.Ordine;

public class OrdineBC {

	private Connection conn;

	public OrdineBC() throws ClassNotFoundException, IOException, NamingException, SQLException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Ordine ordine) throws DAOException, ClassNotFoundException, IOException, NamingException {

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
