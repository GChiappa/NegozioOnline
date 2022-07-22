package it.betacom.businesscomponent.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PUT;


import it.betacom.businesscomponent.model.Utente;
import it.betacom.businesscomponent.UtenteBC;

@Path("/utenteservice")
public class UtenteService {

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Utente createUtente(Utente utente) 
			throws NamingException, SQLException, ParseException, ClassNotFoundException, IOException {
		UtenteBC uBC = new UtenteBC();
		uBC.create(utente);
		
		return utente;
	
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void update(Utente utente) 
		throws NamingException, SQLException, ParseException, ClassNotFoundException, IOException {

		UtenteBC uBC = new UtenteBC();
		uBC.update(utente);
	}
	
	@GET
	@Path("/findbyusername/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Utente findByUsername(@PathParam("username") String username) throws ClassNotFoundException, IOException, NamingException, SQLException{
		UtenteBC uBC = new UtenteBC();
		return uBC.findByUsername(username);
		
	}
	
	
	
	
}
