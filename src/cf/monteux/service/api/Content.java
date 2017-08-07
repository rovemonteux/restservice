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

@Path("/content")
public class Content {

	private static final Logger log = Logger.getLogger(Content.class.getName());
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_HTML)
	public Response xmlToJson(String input) {
		
		log.log(Level.INFO, "Input: "+input);
		
		java.nio.file.Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		
		return Response.status(200).entity("<html><title>test</title><body>"+s+"</body></html>").build();
		
	}
}
