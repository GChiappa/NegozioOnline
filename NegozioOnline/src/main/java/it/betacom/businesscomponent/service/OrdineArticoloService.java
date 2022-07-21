package it.betacom.businesscomponent.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.betacom.businesscomponent.Ordine_ArticoloBC;
import it.betacom.businesscomponent.model.Ordine_Articolo;

@Path("/ordinearticoloservice")
public class OrdineArticoloService {

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Ordine_Articolo create(Ordine_Articolo oa)
			throws ClassNotFoundException, IOException, NamingException, SQLException {

		Ordine_ArticoloBC oaBC = new Ordine_ArticoloBC();
		oaBC.create(oa);
		return oa;
	}

}
