package idv.jack.webserver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

//https://examples.javacodegeeks.com/enterprise-java/rest/jersey/jersey-file-upload-example/
//https://visionmedia.github.io/superagent/#get-requests
@Path("upload")
public class UploadFileResource {
	
	@POST
	@Path("file")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response function1(
			@FormDataParam("file") InputStream fileInputStream,
         @FormDataParam("file") FormDataContentDisposition contentDispositionHeader){
		
		System.out.println(fileInputStream);
		System.out.println(contentDispositionHeader);
		String SERVER_UPLOAD_LOCATION_FOLDER = "/home/user1/upload/";
		String filePath = SERVER_UPLOAD_LOCATION_FOLDER + contentDispositionHeader.getFileName();
		
		saveFile(fileInputStream, filePath);

		
		Gson gson = new Gson();
		String toJson = gson.toJson("runningJobsTest");
		return Response.status(200).entity(toJson).build();

	}
	
    private void saveFile(InputStream uploadedInputStream,
            String serverLocation) {
         try {
             OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
             int read = 0;
             byte[] bytes = new byte[1024];
             outpuStream = new FileOutputStream(new File(serverLocation));
             while ((read = uploadedInputStream.read(bytes)) != -1) {
                 outpuStream.write(bytes, 0, read);
               }
             outpuStream.flush();
             outpuStream.close();
         } catch (IOException e) {
             e.printStackTrace();
          }
      }
  

}
