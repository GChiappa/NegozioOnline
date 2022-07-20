package it.betacom.architecture.dao.adapter;

import java.sql.Connection;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.GenericDAO;
import it.betacom.businesscomponent.model.Immagine;

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
