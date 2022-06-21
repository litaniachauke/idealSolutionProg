/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import za.co.api.classes.applicants.Job;
import za.co.api.service.service.ApplicantsService;
import za.co.api.service.service.JobService;
import za.co.api.service.service.impl.AppServiceImpl;
import za.co.api.service.service.impl.JobServiceImpl;
import za.co.precious.DBManager.DBManager;

/**
 *
 * @author TRAIN 80
 */

@Path("/job")
public class JobController {
    DBManager dbm = new DBManager("jdbc:mysql://localhost:3306/", "root", "joblistings", "root", "com.mysql.jdbc.Driver");
    JobService jobserv = new JobServiceImpl(dbm.getConnection());
      
  @POST
  @Path("/jobform")
  public Response userReg(@QueryParam("des") String des,
                          @QueryParam("salary") String salary){
      
      Response res;
      Job job = new Job(0,des,Double.parseDouble(salary)); 
      if(jobserv.addJob(job)){
          res = Response.status(200).entity(job.toString()).build();
      }else{
          res=Response.status(200).entity("Add has failed").build();
      }
    return res;
  }
@GET
  @Path("/{jobid}")
  @Produces(MediaType.APPLICATION_JSON)
 public Job getUserOrder(@PathParam("jobid") Integer jobid){
   
    Job job = jobserv.getJob(jobid);
    
    return job;
 }
 @DELETE
 @Path("/{jobid}")
  public Response userReg(@PathParam("jobid") Integer jobid){
      Response res;
      if(jobserv.deleteJob(jobid)){
          res=Response.status(200).entity("Delete Complete").build();
      }else{
          res=Response.status(200).entity("Delete Failed").build();
      }
      return res;
  }
  @PUT
  @Path("/{jobid}")
  public Response userReg(@PathParam("jobid") Integer jobid,
                          @QueryParam("des") String des,
                          @QueryParam("salary") String salary
                          ){
      Response res;
     Job job = new Job(jobid,des,Double.parseDouble(salary)); 
      if(jobserv.editJob(job)){
          res = Response.status(200).entity("Update Successful: "+job.toString()).build();
      }else{
          res=Response.status(200).entity("Update failed").build();
      }
      return res;
  }
}
 
