package idv.jack.webserver;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

@Path("hello")
public class HelloWroldResource {

	
	@GET
	@Path("function1")
	@Produces(MediaType.APPLICATION_JSON)
	public Response function1(){
		//return "{key:\'value\'}";
		Gson gson = new Gson();
		String toJson = gson.toJson("runningJobsTest");
		return Response.status(200).entity(toJson).build();

	}
	
	@GET
	@Path("list")
	public Response list(){
		List<String> list = new ArrayList<String>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("ccccc");
		
		Gson gson = new Gson();
		String toJson = gson.toJson(list);
		return Response.status(200)
				         .entity(toJson)
				         .header("Access-Control-Allow-Origin", "*")
				         .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				         .build();
	}
}
