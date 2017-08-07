package cf.monteux.service.api;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

@Path("/xmltojson")
public class XMLToJSON {

	private static final Logger log = Logger.getLogger(XMLToJSON.class.getName());
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Response xmlToJson(String input) throws JSONException {
		
		log.log(Level.INFO, "Input: "+input);
		JSONObject jsonObject = XML.toJSONObject(input);
		//jsonObject.put("status", input);
		
		return Response.status(200).entity(jsonObject.toString()).build();
		
	}
			
}
