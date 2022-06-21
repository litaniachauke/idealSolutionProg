package za.co.api.controller;



import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import za.co.api.classes.applicants.Applicants;
import za.co.api.service.service.ApplicantsService;
import za.co.api.service.service.impl.AppServiceImpl;

import za.co.precious.DBManager.DBManager;

@Path("/applicant")
public class ApplicantController{
    DBManager dbm = new DBManager("jdbc:mysql://localhost:3306/", "root", "joblistings", "root", "com.mysql.jdbc.Driver");
    ApplicantsService appserv = new AppServiceImpl(dbm.getConnection());
      
  @POST
  @Path("/appform")
  public Response userReg(@QueryParam("name") String name,
                          @QueryParam("surname") String surname,
                          @QueryParam("resume")String resume){
      
      Response res;
      Applicants app = new Applicants(0,name,surname,resume);
      
      if(appserv.addApplicant(app)){
          res = Response.status(200).entity(app.toString()).build();
      }else{
          res=Response.status(200).entity("Add has failed").build();
      }
    return res;
  }
@GET
  @Path("/{appid}")
  @Produces(MediaType.APPLICATION_JSON)
 public Applicants getUserOrder(@PathParam("appid") Integer appid){
   Applicants app = appserv.getApplicant(appid);
    System.out.println(app.toString());
    
   return app;
 }
 @DELETE
 @Path("/{appid}")
  public Response userReg(@PathParam("appid") Integer appid){
      Response res;
      if(appserv.deleteApplicant(appid)){
          res=Response.status(200).entity("Delete Complete").build();
      }else{
          res=Response.status(200).entity("Delete Failed").build();
      }
      return res;
  }
  
  @PUT
  @Path("/{appid}")
  public Response userReg(@PathParam("appid") Integer appid,
                          @QueryParam("name") String name,
                          @QueryParam("surname") String surname,
                          @QueryParam("resume")String resume
                          ){
      Response res;
      Applicants app = new Applicants(appid,name,surname,resume);
      if(appserv.editApplicant(app)){
          res=Response.status(200).entity("Update Complete: "+app.toString()).build();
      }else{
          res=Response.status(200).entity("Update Failed").build();
      }
      return res;
  }
 
}
