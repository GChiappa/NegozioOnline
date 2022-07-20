package com.gio.architecture.dao.adapter;

import java.sql.Connection;

import com.gio.architecture.dao.DAOException;
import com.gio.architecture.dao.GenericDAO;
import com.gio.businesscomponent.model.Immagine;

public class AdaptImmagine implements GenericDAO<Immagine> {

	@Override
	public void create(Connection conn, Immagine entity) throws DAOException {
	}

	@Override
	public void update(Connection conn, Immagine entity) throws DAOException {
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
	}

	@Override
	public Immagine findById(Connection conn, long id) throws DAOException {
		return null;
	}

	@Override
	public Immagine[] getAll(Connection conn) throws DAOException {
		return null;
	}

	

}
