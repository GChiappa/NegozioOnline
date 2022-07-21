package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.architecture.dao.adapter.AdaptOrdine_Articolo;
import it.betacom.businesscomponent.model.Ordine_Articolo;

public class Ordine_ArticoloDAO extends AdaptOrdine_Articolo implements DAOConstants {

	private Statement stmt;
	private ResultSet rs;

	public static Ordine_ArticoloDAO getFactory() throws DAOException {
		return new Ordine_ArticoloDAO();
	}

	private Ordine_ArticoloDAO() {
	}

	@Override
	public void create(Connection conn, Ordine_Articolo entity) throws DAOException {

		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(SELECT_ORDINE_ARTICOLO);

			rs.moveToInsertRow();

			rs.updateLong(1, entity.getId_ordine());
			rs.updateLong(2, entity.getId_articolo());
			rs.updateInt(3, entity.getQuantita());

			rs.insertRow();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

}
