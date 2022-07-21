package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import it.betacom.architecture.dao.adapter.AdaptUtente;
//Concrete Component
import it.betacom.businesscomponent.model.Utente;

public class UtenteDAO extends AdaptUtente implements DAOConstants {

	private Statement stmt;
	private ResultSet rs;


	public static UtenteDAO getFactory() throws DAOException {
		return new UtenteDAO();
	}

	private UtenteDAO() {
	
	}

	@Override
	public void create(Connection conn, Utente entity) throws DAOException {

		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(SELECT_UTENTE);
			rs.updateString(1, entity.getNome());
			rs.updateString(2, entity.getCognome());
			rs.updateString(3, entity.getIndirizzo());
			rs.updateString(4, entity.getCap());
			rs.updateDate(5, new java.sql.Date(entity.getNascita().getTime()));
			rs.updateString(6, entity.getUsername());
			rs.updateString(7, entity.getPassword());
			rs.updateString(8, entity.getEmail());

			rs.insertRow();


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

			rs = ps.executeQuery();

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
