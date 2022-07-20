package it.betacom.businesscomponent.facade;

import java.io.IOException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.ArticoloBC;
import it.betacom.businesscomponent.model.Articolo;

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
