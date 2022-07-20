package it.betacom.architecture.dao.adapter;

import java.sql.Connection;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.GenericDAO;
import it.betacom.businesscomponent.model.Ordine_Articolo;

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
