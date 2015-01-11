package com.smarthouse.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/v1/status")
public class V_status {

	
	@GET
	@Path("/cat")
	@Produces(MediaType.TEXT_HTML)
	// try new media types
	public String returnTitle() {
		return "<p>Java Web Service</p>";

	}
}

