package it.betacom.businesscomponent.facade;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import it.betacom.businesscomponent.ArticoloBC;
import it.betacom.businesscomponent.ImmagineBC;
import it.betacom.businesscomponent.OrdineBC;
import it.betacom.businesscomponent.Ordine_ArticoloBC;
import it.betacom.businesscomponent.UtenteBC;
import it.betacom.businesscomponent.model.Articolo;
import it.betacom.businesscomponent.model.Immagine;
import it.betacom.businesscomponent.model.Ordine;
import it.betacom.businesscomponent.model.Ordine_Articolo;
import it.betacom.businesscomponent.model.Utente;

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

	public void createUtente(Utente utente) throws ClassNotFoundException, IOException, NamingException, SQLException {
		uBC = new UtenteBC();
		uBC.create(utente);
	}

	public void createOrdine(Ordine ordine) throws ClassNotFoundException, IOException, NamingException, SQLException {
		oBC = new OrdineBC();
		ordine.setId_ordine(0);
		oBC.create(ordine);
	}

	public void updateOrdine(Ordine ordine) throws ClassNotFoundException, IOException, NamingException, SQLException {
		oBC = new OrdineBC();
		ordine.setId_ordine(0);
		oBC.update(ordine);
	}

	public void createOrdine_Articolo(Ordine_Articolo oa)
			throws ClassNotFoundException, IOException, NamingException, SQLException {
		oaBC = new Ordine_ArticoloBC();
		oaBC.create(oa);
	}

	public Articolo[] getArticoli() throws ClassNotFoundException, IOException, NamingException, SQLException {
		aBC = new ArticoloBC();
		return aBC.getAll();
	}

	public Immagine getImmagineById(long id) throws ClassNotFoundException, IOException, NamingException, SQLException {
		iBC = new ImmagineBC();
		return iBC.findById(id);
	}

	public Articolo getArticoloById(long id) throws ClassNotFoundException, IOException, NamingException, SQLException {
		aBC = new ArticoloBC();
		return aBC.findById(id);
	}

}
