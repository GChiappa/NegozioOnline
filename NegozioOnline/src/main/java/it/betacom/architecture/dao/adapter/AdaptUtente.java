package com.gio.architecture.dao.adapter;

import java.sql.Connection;

import com.gio.architecture.dao.DAOException;
import com.gio.architecture.dao.GenericDAO;
import com.gio.businesscomponent.model.Utente;

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
