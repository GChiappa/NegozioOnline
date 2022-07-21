package it.betacom.businesscomponent.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import it.betacom.businesscomponent.ImmagineBC;
import it.betacom.businesscomponent.model.Immagine;


@Path("/immagineservice")
public class ImmagineService {

	
	@GET
	@Path("/findbyId/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Immagine findById(@PathParam("id") long id) throws ClassNotFoundException, IOException, NamingException, SQLException{
		ImmagineBC iBC = new ImmagineBC();
		return iBC.findById(id);
		
	}
}
