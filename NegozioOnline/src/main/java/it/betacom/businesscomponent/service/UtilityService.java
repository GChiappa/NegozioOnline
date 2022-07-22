package it.betacom.businesscomponent.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.betacom.businesscomponent.utilities.LoginUtility;
import it.betacom.businesscomponent.utilities.ReportUtility;

@Path("/utilityservice")
public class UtilityService {

	@GET
	@Path("/getadminpass/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAdminPass(@PathParam("username") String username)
			throws NamingException, SQLException, ClassNotFoundException, IOException {
		LoginUtility lu = new LoginUtility();
		return lu.getAdminPass(username);
	}

	@GET
	@Path("/getuserpass/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserPass(@PathParam("username") String username)
			throws NamingException, SQLException, ClassNotFoundException, IOException {
		LoginUtility lu = new LoginUtility();
		return lu.getUserPass(username);
	}

	@GET
	@Path("/getreport")
	@Produces(MediaType.APPLICATION_JSON)
	public Vector<String[]> getReport() throws NamingException, SQLException, ClassNotFoundException, IOException {
		ReportUtility ru = new ReportUtility();
		return ru.getReport();
	}

}
