package it.betacom.businesscomponent.idgenerator;

import java.io.IOException;

import it.betacom.architecture.dao.DAOException;

// Genera automaticamente l'id da inserire nelle tabelle
public interface IdGeneratorInterface {
	
	long getNextId()throws ClassNotFoundException, DAOException,IOException;
	
}
