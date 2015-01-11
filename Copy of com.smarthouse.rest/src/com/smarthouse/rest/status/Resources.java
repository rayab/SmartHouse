package com.smarthouse.rest.status;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONString;

import SmartFunctions.House;
import Client.Client;


//import SmartFunctions.Alarms;

/*Info on SSL
 * If I understand your problem correctly, you are publishing a URL for http from a web page served by your servlet.
If you need to change the request to be https instead you should redirect your plain http connector (in port 80 or 8080 where you have it) to connector for port 443.
If you google tomcat redirect http to https you wil find plenty of links e.g. redirect tomcat to https
 * */

@Path("/services")
public class Resources {

	@GET
	@Path("protoTest")
	@Produces(MediaType.TEXT_HTML)
	public String protoTest(){
	String temp = "test";
	Client client = new Client("localhost", 4567 );
	client.start();
	client.setCommand("test_Dinosaurs will get you while you sleep");
	String string = client.getReply();
	return "<p>Your message: "+string+"</p>";
	}
	
	@GET
	@Path("IPTest")
	@Produces(MediaType.TEXT_HTML)
	// Error when I use @produces(MediaType.TEXT_HTML) NO IDEA WHY. DID NOT DO
	// BEFORE.
	public String activate(@Context HttpServletRequest requestContext,
			@Context SecurityContext context) {
		String yourIP = requestContext.getRemoteAddr().toString();
		System.out.println(yourIP);
		return "<p>Your IP: " + yourIP+"<p>";
	}

	@GET
	@Path("JSONTest")
	@Produces(MediaType.APPLICATION_JSON)
	// try with TEXT_HTML. See if still works.
	public String returnJSON() throws JsonGenerationException,
			JsonMappingException, IOException {

		SmartHouse instance = new SmartHouse();
		String jsonString = null;
		// Alarms instance = new Alarms();

		// this lets us try modify the address
		// instance.setAddress("321 Real St, Realville");
		ObjectMapper mapper = new ObjectMapper();// thing that makes json

		jsonString = mapper.writeValueAsString(instance);
		return jsonString;
	}

	// Write like this
	// http://localhost:8080/com.smarthouse.rest/api/services/iliketuna@fishlovers.com/houses
	@GET
	@Path("{email}/houses")
	@Produces(MediaType.TEXT_HTML)
	public Response getHouses(
			@DefaultValue("default") @PathParam("email") String email) {

		String output = " This is your email: " + email;
		System.out.println("Client requesting accessible houses");

		// Just testing another way to return a response
		return Response.status(200).entity(output).build();
	}
	
	// Write like this
	// http://localhost:8080/com.smarthouse.rest/api/services/iliketuna@fishlovers.com/house/7
	@GET
	@Path("{email}/house/{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response getDevices(
			@DefaultValue("default") @PathParam("email") String email, @DefaultValue("default") @PathParam("id") String id) {

		String output = " This is your email: " + email + " This is your id: "+id;
		System.out.println("Client requesting house "+id+" device information");

		// Just testing another way to return a response
		return Response.status(200).entity(output).build();
	}

	// Type like this
	// http://localhost:8080/com.smarthouse.rest/api/serices/login?username=cameron&password=tuna
	@POST
	@Path("login")
	@Produces(MediaType.TEXT_HTML)
	// can also do TEXT_PLAIN
	public String login(
			@DefaultValue("default username") @QueryParam("username") String username,
			@DefaultValue("default password") @QueryParam("password") String password) {
		System.out.println("Username = " + username + " Password: " + password);
		String name = username;
		return "<p>WELCOME  " + name + "</p><p>  your password is  " + password
				+ "</p>";

	}

	@POST
	@Path("test")
	@Produces(MediaType.TEXT_HTML)
	//Write like this http://localhost:8080/com.smarthouse.rest/api/services/test?name=light&state=true&selected=3
	public String TestJson(@QueryParam("name") String name,@QueryParam("state") boolean state, @QueryParam("selected") int selected) {
		return "<p>Name  " + name + "</p><p>  state " + state
				+ "</p><p>selected " + selected + "</p>";

	}
	
	@GET
	@Path("toggle")
	@Produces(MediaType.APPLICATION_JSON)
	public String TestJSONToggle() {
		
		House instance = new House();
		String jsonString = null;
		ObjectMapper mapper = new ObjectMapper();//thing that makes  json
		instance.getInside()[0].setName("light");
		try {
			jsonString = mapper.writeValueAsString(instance);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		instance.setAddress("321 Real St, Realville");
//		instance.setAddress("321 Real St, Realville");
//		instance.setAddress("321 Real St, Realville");
		//jsonString = "Cat";
		return jsonString;

	}

}
