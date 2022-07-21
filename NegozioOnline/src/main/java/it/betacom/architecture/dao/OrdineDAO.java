package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.businesscomponent.model.Ordine;

public class OrdineDAO implements DAOConstants, GenericDAO<Ordine> {

	private Statement stmt;
	private ResultSet rs;

	public static OrdineDAO getFactory() throws DAOException {
		return new OrdineDAO();
	}

	private OrdineDAO() {
	}

	@Override
	public void create(Connection conn, Ordine entity) throws DAOException {
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(SELECT_ORDINE);

			rs.moveToInsertRow();

			rs.updateLong(1, entity.getId_ordine());
			rs.updateDouble(2, entity.getTotale());
			rs.updateDate(3, new java.sql.Date(entity.getData().getTime()));
			rs.updateString(4, entity.getUsername());

			rs.insertRow();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	@Override
	public void update(Connection conn, Ordine entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_ORDINE);

			ps.setDouble(1, entity.getTotale());
			ps.setDate(2, new java.sql.Date(entity.getData().getTime()));
			ps.setString(3, entity.getUsername());
			ps.setLong(4, entity.getId_ordine());

			ps.execute();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_ORDINE);

			ps.setLong(1, id);
			ps.execute();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	@Override
	public Ordine findById(Connection conn, long id) throws DAOException {
		Ordine ordine = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SBYID_ORDINE);
			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				ordine = new Ordine();
				ordine.setId_ordine(rs.getLong(1));
				ordine.setTotale(rs.getDouble(2));
				ordine.setData(new java.util.Date(rs.getDate(3).getTime()));
				ordine.setUsername(rs.getString(4));
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return ordine;
	}

	@Override
	public Ordine[] getAll(Connection conn) throws DAOException {

		Ordine[] ordini = null;

		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(SELECT_ORDINE);
			rs.last();
			ordini = new Ordine[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {

				Ordine o = new Ordine();
				o.setId_ordine(rs.getLong(1));
				o.setTotale(rs.getDouble(2));
				o.setData(new java.util.Date(rs.getDate(3).getTime()));
				o.setUsername(rs.getString(4));

				ordini[i] = o;
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return ordini;
	}

}
