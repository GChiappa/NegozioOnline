package com.gio.businesscomponent.idgenerator;

import java.io.IOException;

import com.gio.architecture.dao.DAOException;

// Genera automaticamente l'id da inserire nelle tabelle
public interface IdGeneratorInterface {
	
	long getNextId()throws ClassNotFoundException, DAOException,IOException;
	
}
