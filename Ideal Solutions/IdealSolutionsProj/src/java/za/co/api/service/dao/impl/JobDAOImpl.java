package za.co.api.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.api.classes.applicants.Job;

import za.co.api.service.dao.JobDAO;

 public class JobDAOImpl implements JobDAO {
     
    private Connection con=null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public JobDAOImpl(Connection con) {
        this.con = con;
    }

     

    @Override
    public boolean addJob(Job job) {
        try {
            ps = con.prepareStatement("INSERT INTO job(description,salary) VALUES(?,?)");
            ps.setString(1, job.getDes());
            ps.setDouble(2, job.getSalary());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
            return false;
        }
        return true;
    }

    @Override
    public Job getJob(int jobId) {
        Job job = new Job();
        try {
            ps= con.prepareStatement("SELECT description,salary FROM job WHERE jobId=?");
            ps.setInt(1, jobId);
            rs=ps.executeQuery();
            while(rs.next()){
                job=new Job(jobId,rs.getString("description"),rs.getDouble("salary"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return job;
    }

    @Override
    public boolean deleteJob(int jobId) {
        boolean res = false;
        try {
            ps= con.prepareStatement("DELETE FROM job WHERE jobId=?");
            ps.setInt(1, jobId);
            if(ps.executeUpdate()>0){
                res=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean editJob(Job job) {
        boolean res = false;
        try {
            ps = con.prepareStatement("UPDATE job SET description = ?,salary = ?  WHERE jobId=?;");
            ps.setString(1, job.getDes());
            ps.setDouble(2, job.getSalary());
            ps.setInt(3, job.getJobID());
            ps.execute();
            res=true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
            
        }
        return res;
    }
     
}
