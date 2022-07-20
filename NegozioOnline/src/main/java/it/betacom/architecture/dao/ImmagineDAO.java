package com.gio.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gio.architecture.dao.adapter.AdaptImmagine;
import com.gio.businesscomponent.model.Immagine;

public class ImmagineDAO extends AdaptImmagine implements DAOConstants {


	public static ImmagineDAO getFactory() throws DAOException {
		return new ImmagineDAO();
	}

	private ImmagineDAO() throws DAOException {
	}
	
	@Override
	public Immagine findById(Connection conn, long id) throws DAOException {
		Immagine immagine = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SBYID_IMMAGINE);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				immagine = new Immagine();
				immagine.setId_immagine(rs.getLong(1));
				immagine.setUrl(rs.getString(2));
				immagine.setDescrizione(rs.getString(3));
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return immagine;
	}

	

}
