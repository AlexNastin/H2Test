package by.st.h2_test.rest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.model.ParamQualifier;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;

import by.st.h2_test.beans.Login;
import by.st.h2_test.comet.CometController;
import by.st.h2_test.dao.impl.H2Dao;
import by.st.h2_test.helper.HelperJSON;

@Path("/act")
public class ResourceREST {

	private H2Dao dao = H2Dao.getInstance();
	
	public final String ADD = "ADD";
	public final String DELETE = "DELETE";
	public final String UPDATE = "UPDATE";
	
	BridgeCometRest bridge = BridgeCometRest.getInstance();
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("/getlogins")
	@Produces({ MediaType.TEXT_PLAIN })
	public String getLogins() {
		ArrayList<Login> arrayList = dao.getLogins();
		JSONArray logins = HelperJSON.generationJsons(arrayList);
		return logins.toJSONString();
	}

	@GET
	@Path("/getlogin/{id}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String getLogin(@PathParam("id") int id) {
		JSONObject jsonObject = HelperJSON.generationJson(dao.getLogin(id));
		return jsonObject.toJSONString();
	}


	
	
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addLoginJSON(@FormParam("json") String json)
			throws IOException {
		try {
			Login login = HelperJSON.generationLoginFromJson(json);
			dao.insertLogin(login.getIdLogin(), login.getName(),login.getEmail(), login.getPassword());
			bridge.getActions().add(ADD);
		} catch (ParseException e) {
		}
	}
	
	@POST
	@Path("/deletelogin")
	@Produces({ MediaType.TEXT_HTML })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void deleteLogin(@FormParam("delIdLogin") String delIdLogin) {
		dao.deleteLogin(Integer.valueOf(delIdLogin).intValue());
		bridge.getActions().add(DELETE);
	}
	
	@POST
	@Path("/updatelogin")
	@Produces({ MediaType.TEXT_HTML })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateLogin(@FormParam("json") String json) {
		try {
			Login login = HelperJSON.generationLoginFromJson(json);
			dao.updateLogin(login.getIdLogin(), login.getName(),login.getEmail(), login.getPassword());
			bridge.getActions().add(UPDATE);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// @POST
	// @Produces(MediaType.TEXT_HTML)
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// public void addLogin(@FormParam("idLogin") int id,
	// @FormParam("name") String name, @FormParam("email") String email,
	// @FormParam("pass") int pass,
	// @Context HttpServletResponse servletResponse) throws IOException {
	// if (id != 0) {
	// System.out.println(id);
	// System.out.println(name);
	// System.out.println(email);
	// System.out.println(pass);
	// dao.insertLogin(id, name, email, pass);
	// servletResponse.sendRedirect("../indexH2html.html");
	// }

	// }

}
