package za.co.api.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.api.classes.applicants.Applicants;
import za.co.api.service.dao.ApplicantsDAO;

public class ApplicantsDAOImpl implements ApplicantsDAO {
    private Connection con=null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ApplicantsDAOImpl(Connection con) {
        this.con = con;
    }
   
    
    
    @Override
    public boolean addApplicant(Applicants app) {
       Boolean ans = false;
       
       if(con!=null){
       try {
            ps = con.prepareStatement("INSERT INTO applicants(name,surname,resume) VALUES(?,?,?)");
            ps.setString(1,app.getName());
            ps.setString(2,app.getSurname());
            ps.setString(3,app.getResume());
            ps.execute();
            ans=true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
            
        }
       }else{
           System.out.println("No Connection!!");
       }
        
        return ans;
    }

    @Override
    public Applicants getApplicant(int appId) {
       Applicants app = new Applicants();
       if(con!=null){
       try {
            ps = con.prepareStatement("SELECT name,surname,resume FROM applicants WHERE appId=?");
            ps.setInt(1,appId);
            rs = ps.executeQuery();
            while(rs.next()){
               app.setAppId(appId);
               app.setName(rs.getString("name"));
               app.setSurname(rs.getString("surname"));
               app.setResume(rs.getString("resume"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
            
        }
       }else{
           System.out.println("No Connection!!");
       }
       return app;
    }

    @Override
    public boolean deleteApplicant(int appId) {
          boolean res = false;
        try {
            ps= con.prepareStatement("DELETE FROM applicants WHERE appId=?");
            ps.setInt(1, appId);
            if(ps.executeUpdate()>0){
                res=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean editApplicant(Applicants app) {
                boolean res = false;
        try {
            ps = con.prepareStatement("UPDATE applicants SET name=?,surname=?,resume=?  WHERE appId=?;");
            ps.setString(1, app.getName());
            ps.setString(2, app.getSurname());
            ps.setString(3, app.getResume());
            ps.setInt(4, app.getAppId());
            ps.execute();
            res=true;
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
            
        }
        return res;
    }
    
}
