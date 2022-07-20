package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.gio.architecture.dao.adapter.AdaptOrdine_Articolo;
import com.gio.businesscomponent.model.Ordine_Articolo;

public class Ordine_ArticoloDAO extends AdaptOrdine_Articolo implements DAOConstants {

	private CachedRowSet rowSet;

	public static Ordine_ArticoloDAO getFactory() throws DAOException {
		return new Ordine_ArticoloDAO();
	}

	private Ordine_ArticoloDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, Ordine_Articolo entity) throws DAOException {

		try {
			rowSet.setCommand(SELECT_ORDINE_ARTICOLO);
			rowSet.execute(conn);

			rowSet.moveToInsertRow();

			rowSet.updateLong(1, entity.getId_ordine());
			rowSet.updateLong(2, entity.getId_articolo());
			rowSet.updateInt(3, entity.getQuantita());

			rowSet.insertRow();

			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

}
