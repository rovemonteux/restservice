package cf.monteux.service.api;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
Presents documentation on the API usage.
*/
@Path("/")
public class Content {

	private static final Logger log = Logger.getLogger(Content.class.getName());
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_HTML)
	public Response documentation(String input) {
		
		return Response.status(200).entity("<html><title>Rove Monteux's API - api.monteux.cf</title><body><h1>Rove Monteux's API - api.monteux.cf</h1><h2>Available APIs:</h2><br/><b>JSON to XML</b>: <a href=\"/jsontoxml\">jsontoxml</a><br/><b>XML to JSON</b>: <a href=\"xmltojson\">xmltojson</a></body></html>").build();
		
	}
}
