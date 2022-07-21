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

import it.betacom.businesscomponent.OrdineBC;
import it.betacom.businesscomponent.model.Ordine;

@Path("/ordineservice")
public class OrdineService {

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Ordine create(Ordine ordine) throws ClassNotFoundException, IOException, NamingException, SQLException {
		if (ordine.getId_ordine() == 0) {
			OrdineBC oBC = new OrdineBC();
			oBC.createOrUpdate(ordine);
		}
		return ordine;
	}

	@GET
	@Path("/ordini")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordine> getOrdini() throws ClassNotFoundException, IOException, NamingException, SQLException {
		OrdineBC oBC = new OrdineBC();
		return Arrays.asList(oBC.getAll());
	}

	@GET
	@Path("/ordine/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ordine getOrdine(@PathParam("id") long id)
			throws ClassNotFoundException, IOException, NamingException, SQLException {
		OrdineBC oBC = new OrdineBC();
		return oBC.findById(id);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Ordine update(Ordine ordine) throws ClassNotFoundException, IOException, NamingException, SQLException {
		if (ordine.getId_ordine() != 0) {
			OrdineBC oBC = new OrdineBC();
			oBC.createOrUpdate(ordine);
		}
		return ordine;
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") long id)
			throws ClassNotFoundException, IOException, NamingException, SQLException {
		OrdineBC oBC = new OrdineBC();
		oBC.delete(id);
	}

}
