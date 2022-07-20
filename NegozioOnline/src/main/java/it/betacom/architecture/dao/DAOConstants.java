package com.gio.architecture.dao;

public interface DAOConstants {

	// Client ----------
	String SELECT_UTENTE = "select * from UTENTE";
	String SBYUSERNAME_UTENTE = "select * from UTENTE where username = ?";
	String SELECT_PASSWORD_UTENTE = "select password from UTENTE where username = ?";
	String UPDATE_UTENTE = "update UTENTE set nome = ?, cognome = ?, indirizzo = ?, cap = ?, nascita = ?, password = ?, email = ? where username = ?";

	String SELECT_ARTICOLO = "select * from ARTICOLO";
	String DELETE_ARTICOLO = "delete from ARTICOLO where id_articolo = ?";
	String SBYID_ARTICOLO = "select * from ARTICOLO where id_articolo = ?";
	String UPDATE_ARTICOLO = "update ARTICOLO set marca = ?, modello = ?, prezzo = ? where id_articolo = ?";

	String SELECT_ORDINE = "select * from ORDINE";
	String SBYID_ORDINE = "select * from ORDINE where id_ordine = ?";
	String DELETE_ORDINE = "delete from ORDINE where id_ordine = ?";
	String UPDATE_ORDINE = "update ORDINE set totale = ?, data = ?, username = ? where id_ordine = ?";

	String SELECT_ORDINE_ARTICOLO = "select * from ORDINE_ARTICOLO";

	String SELECT_IMMAGINE = "select * from IMMAGINE";
	String SBYID_IMMAGINE = "select * from IMMAGINE where id_immagine = ?";

	// Sequences ----------
	String SELECT_ORDINESEQ = "select ordine_seq.nextval from DUAL";

	String SELECT_ARTICOLOSEQ = "select articolo_seq.nextval from DUAL";

	// Admin ----------
	String SELECT_PASSWORD_AMMINISTRATORE = "select password from AMMINISTRATORE where username = ?";

	String SELECT_REPORT = "select * from REPORT";

}
