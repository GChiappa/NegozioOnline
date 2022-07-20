package com.gio.businesscomponent.facade;

import java.io.IOException;

import com.gio.architecture.dao.DAOException;
import com.gio.businesscomponent.ArticoloBC;
import com.gio.businesscomponent.model.Articolo;

public class AdminFacade {

	private static AdminFacade aF;
	private ArticoloBC aBC;

	private AdminFacade() {
	}

	public static AdminFacade getInstance() {
		if (aF == null)
			aF = new AdminFacade();
		return aF;
	}

	public Articolo getArticoloById(long id) throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		return aBC.findById(id);
	}

	public void createOrUpdateArticolo(Articolo articolo) throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		aBC.createOrUpdate(articolo);
	}

	public Articolo[] getArticoli() throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		return aBC.getAll();
	}

	public void removeArticolo(long id) throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		aBC.delete(id);
		
	}

}
