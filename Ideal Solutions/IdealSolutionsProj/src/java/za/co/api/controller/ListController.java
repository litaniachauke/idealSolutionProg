package za.co.api.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import za.co.api.classes.applicants.Listing;
import za.co.api.service.service.ListService;
import za.co.api.service.service.impl.ListServiceImpl;
import za.co.precious.DBManager.DBManager;

@Path("/list")
public class ListController {
    DBManager dbm = new DBManager("jdbc:mysql://localhost:3306/", "root", "joblistings", "root", "com.mysql.jdbc.Driver");
    ListService lsServ = new ListServiceImpl(dbm.getConnection());
    
  @POST
  @Path("/listform")
  public Response userReg(@QueryParam("jobId") String jobId,
                          @QueryParam("appId") String appId
                          ){
      
      Response res;
      Listing list = new Listing(0,Integer.parseInt(jobId),Integer.parseInt(appId)); 
      if(lsServ.addListing(list)){
          res = Response.status(200).entity(list.toString()).build();
      }else{
          res=Response.status(200).entity("Add has failed").build();
      }
    return res;
  }
@GET
  @Path("/{listid}")
  @Produces(MediaType.APPLICATION_JSON)
 public Listing getUserOrder(@PathParam("listid") Integer listid){
   
    Listing list = lsServ.getListing(listid);
    
    return list;
 }
 
 @DELETE
 @Path("/{listid}")
  public Response userReg(@PathParam("listid") Integer listid){
      Response res;
      if(lsServ.deleteListing(listid)){
          res=Response.status(200).entity("Delete Complete").build();
      }else{
          res=Response.status(200).entity("Delete Failed").build();
      }
      return res;
  }
}
