package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import it.betacom.architecture.dao.ArticoloDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.ArticoloGenerator;
import it.betacom.businesscomponent.model.Articolo;

public class ArticoloBC {

	private Connection conn;

	public ArticoloBC() throws ClassNotFoundException, IOException, NamingException, SQLException {
		conn = DBAccess.getConnection();
	}

	public void createOrUpdate(Articolo articolo) throws DAOException, ClassNotFoundException, IOException, NamingException {
		try {
			if (articolo.getId_articolo() == 0) {
				articolo.setId_articolo(ArticoloGenerator.getInstance().getNextId());
				ArticoloDAO.getFactory().create(conn, articolo);
			} else
				ArticoloDAO.getFactory().update(conn, articolo);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(long id) throws DAOException {
		try {
			ArticoloDAO.getFactory().delete(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Articolo findById(long id) throws DAOException {
		try {
			return ArticoloDAO.getFactory().findById(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Articolo[] getAll() throws DAOException {
		try {
			return ArticoloDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Articolo[] searchByName(String query) throws DAOException {
		ArrayList<Articolo> lista = new ArrayList<Articolo>();
		String[] criterioRicerca = query.toLowerCase().split(" ");
		for (Articolo a : getAll()) {
			for (String s : criterioRicerca) {
				if (a.getMarca().toLowerCase().contains(s) || a.getModello().toLowerCase().contains(s))
					lista.add(a);
			}
		}
		Articolo[] articoli = new Articolo[lista.size()];
		for (int i = 0; i < articoli.length; i++) {
			articoli[i] = lista.get(i);
		}
		return articoli;
	}

}
