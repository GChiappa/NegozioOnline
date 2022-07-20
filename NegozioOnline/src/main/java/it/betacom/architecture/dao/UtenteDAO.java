package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.architecture.dao.adapter.AdaptUtente;
//Concrete Component
import it.betacom.businesscomponent.model.Utente;

public class UtenteDAO extends AdaptUtente implements DAOConstants {

	private CachedRowSet rowSet;

	public static UtenteDAO getFactory() throws DAOException {
		return new UtenteDAO();
	}

	private UtenteDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, Utente entity) throws DAOException {

		try {
			rowSet.setCommand(SELECT_UTENTE);
			rowSet.execute(conn);

			rowSet.moveToInsertRow();

			rowSet.updateString(1, entity.getNome());
			rowSet.updateString(2, entity.getCognome());
			rowSet.updateString(3, entity.getIndirizzo());
			rowSet.updateString(4, entity.getCap());
			rowSet.updateDate(5, new java.sql.Date(entity.getNascita().getTime()));
			rowSet.updateString(6, entity.getUsername());
			rowSet.updateString(7, entity.getPassword());
			rowSet.updateString(8, entity.getEmail());

			rowSet.insertRow();

			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	@Override
	public void update(Connection conn, Utente entity) throws DAOException {

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(UPDATE_UTENTE);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getCognome());
			ps.setString(3, entity.getIndirizzo());
			ps.setString(4, entity.getCap());
			ps.setDate(5, new java.sql.Date(entity.getNascita().getTime()));
			ps.setString(6, entity.getPassword());
			ps.setString(7, entity.getEmail());
			ps.setString(8, entity.getUsername());
			ps.execute();

			conn.commit();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	@Override
	public Utente findByUsername(Connection conn, String username) throws DAOException {

		Utente utente = null;
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(SBYUSERNAME_UTENTE);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				utente = new Utente();
				utente.setNome(rs.getString(1));
				utente.setCognome(rs.getString(2));
				utente.setIndirizzo(rs.getString(3));
				utente.setCap(rs.getString(4));
				utente.setNascita(new java.util.Date(rs.getDate(5).getTime()));
				utente.setUsername(rs.getString(6));
				utente.setPassword(rs.getString(7));
				utente.setEmail(rs.getString(8));
			}

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return utente;
	}

}
