package it.betacom.businesscomponent.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.betacom.businesscomponent.ArticoloBC;
import it.betacom.businesscomponent.model.Articolo;

@Path("/articoloservice")
public class ArticoloService {

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Articolo createArticolo(Articolo articolo)
			throws ClassNotFoundException, IOException, NamingException, SQLException {
		if (articolo.getId_articolo() == 0) {
			ArticoloBC aBC = new ArticoloBC();
			aBC.createOrUpdate(articolo);
		}
		return articolo;
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Articolo updateArticolo(Articolo articolo)
			throws ClassNotFoundException, IOException, NamingException, SQLException {
		if (articolo.getId_articolo() != 0) {
			ArticoloBC aBC = new ArticoloBC();
			aBC.createOrUpdate(articolo);
		}
		return articolo;
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") long id)
			throws ClassNotFoundException, IOException, NamingException, SQLException {
		ArticoloBC aBC = new ArticoloBC();
		aBC.delete(id);
	}

	@GET
	@Path("/articolo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Articolo getArticolo(@PathParam("id") long id)
			throws ClassNotFoundException, IOException, NamingException, SQLException {
		ArticoloBC aBC = new ArticoloBC();
		return aBC.findById(id);
	}

	@GET
	@Path("/articoli")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Articolo> getArticoli() throws ClassNotFoundException, IOException, NamingException, SQLException {
		ArticoloBC aBC = new ArticoloBC();
		return Arrays.asList(aBC.getAll());
	}

	@GET
	@Path("/articolobynome/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Articolo> getArticoloName(@PathParam("name") String name)
			throws ClassNotFoundException, IOException, NamingException, SQLException {
		ArticoloBC aBC = new ArticoloBC();
		return Arrays.asList(aBC.searchByName(name));
	}

}
