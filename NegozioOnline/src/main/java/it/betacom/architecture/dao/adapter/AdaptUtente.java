package it.betacom.architecture.dao.adapter;

import java.sql.Connection;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.GenericDAO;
import it.betacom.businesscomponent.model.Utente;

public class AdaptUtente implements GenericDAO<Utente> {

	@Override
	public void create(Connection conn, Utente entity) throws DAOException {
	}

	@Override
	public void update(Connection conn, Utente entity) throws DAOException {
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
	}

	@Override
	public Utente findById(Connection conn, long id) throws DAOException {
		return null;
	}

	@Override
	public Utente[] getAll(Connection conn) throws DAOException {
		return null;
	}

	public Utente findByUsername(Connection conn, String username) throws DAOException {
		return null;
	}

}
