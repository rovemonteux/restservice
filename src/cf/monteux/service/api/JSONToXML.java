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

@Path("/jsontoxml")
public class JSONToXML {

	private static final Logger log = Logger.getLogger(JSONToXML.class.getName());
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Response xmlToJson(String input) throws JSONException {
		
		log.log(Level.INFO, "Input: "+input);
		JSONObject jsonObject = new JSONObject(input);
		String xml = XML.toString(jsonObject);
		//jsonObject.put("status", input);
		
		return Response.status(200).entity(xml).build();
		
	}
			
}