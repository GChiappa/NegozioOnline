package com.gio.architecture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException{
	private static final long serialVersionUID = 5453502934596357316L;

	private final static int ORA1017 = 1017;
	private final static int ORA17002 = 17002; // I/O 
	private final static int ORA00001 = 0; //Constraint violata
	
	private String message;
	
	@Override
	public String getMessage() {
		return this.message;
	}

	public DAOException(SQLException sql) {
		String chiave = "";
		if(sql != null) {
			switch (sql.getErrorCode()) {
			case ORA1017:
				chiave = "Credenziali di accesso al DBerrate.";
				log(sql);
				break;
			case ORA17002:
				chiave = "Errore I/O Oracle. Impossibile connettersi al DB";
				log(sql);
				break;
			case ORA00001:
				chiave = "Violazione dei vincoli della tabella.";
				log(sql);
				break;

			default:
				chiave = "Eccezione SQL non prevista. " + sql.getErrorCode();
				log(sql);
				break;
			}
			
		}
		message = chiave;
	}
	
	private void log(SQLException sql) {
		sql.printStackTrace();
		System.err.println("Motivo: " + sql.getMessage());
		System.err.println("Stato app: " + sql.getSQLState());
		System.err.println("Codice errore: " + sql.getErrorCode());
		System.err.println("Causa eccezione: " + sql.getCause());
	}
	
}
