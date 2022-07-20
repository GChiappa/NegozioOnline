package com.gio.architecture.dao.adapter;

import java.sql.Connection;

import com.gio.architecture.dao.DAOException;
import com.gio.architecture.dao.GenericDAO;
import com.gio.businesscomponent.model.Ordine_Articolo;

public class AdaptOrdine_Articolo implements GenericDAO<Ordine_Articolo> {

	@Override
	public void create(Connection conn, Ordine_Articolo entity) throws DAOException {
	}

	@Override
	public void update(Connection conn, Ordine_Articolo entity) throws DAOException {
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
	}

	@Override
	public Ordine_Articolo findById(Connection conn, long id) throws DAOException {
		return null;
	}

	@Override
	public Ordine_Articolo[] getAll(Connection conn) throws DAOException {
		return null;
	}

	

}
