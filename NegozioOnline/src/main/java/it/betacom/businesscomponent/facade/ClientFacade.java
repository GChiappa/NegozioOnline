package com.gio.businesscomponent.facade;

import java.io.IOException;

import com.gio.architecture.dao.DAOException;
import com.gio.businesscomponent.ArticoloBC;
import com.gio.businesscomponent.ImmagineBC;
import com.gio.businesscomponent.OrdineBC;
import com.gio.businesscomponent.Ordine_ArticoloBC;
import com.gio.businesscomponent.UtenteBC;
import com.gio.businesscomponent.model.Articolo;
import com.gio.businesscomponent.model.Immagine;
import com.gio.businesscomponent.model.Ordine;
import com.gio.businesscomponent.model.Ordine_Articolo;
import com.gio.businesscomponent.model.Utente;

public class ClientFacade {

	private static ClientFacade cF;

	// rapporto di aggregazione
	private UtenteBC uBC;
	private OrdineBC oBC;
	private ArticoloBC aBC;
	private Ordine_ArticoloBC oaBC;
	private ImmagineBC iBC;

	private ClientFacade() {

	}

	public static ClientFacade getInstance() {
		if (cF == null)
			cF = new ClientFacade();
		return cF;
	}

	public void createUtente(Utente utente) throws ClassNotFoundException, DAOException, IOException {
		uBC = new UtenteBC();
		uBC.create(utente);
	}

	public void createOrUpdateOrdine(Ordine ordine) throws ClassNotFoundException, DAOException, IOException {
		oBC = new OrdineBC();
		ordine.setId_ordine(0);
		oBC.createOrUpdate(ordine);
	}

	public void createOrdine_Articolo(Ordine_Articolo oa) throws ClassNotFoundException, DAOException, IOException {
		oaBC = new Ordine_ArticoloBC();
		oaBC.create(oa);
	}

	public Articolo[] getArticoli() throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		return aBC.getAll();
	}
	
	public Immagine getImmagineById(long id) throws ClassNotFoundException, DAOException, IOException {
		iBC = new ImmagineBC();
		return iBC.findById(id);
	}

	public Articolo getArticoloById(long id) throws ClassNotFoundException, DAOException, IOException {
		aBC = new ArticoloBC();
		return aBC.findById(id);
	}

}
