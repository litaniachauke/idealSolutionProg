package za.co.api.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.api.classes.applicants.Listing;
import za.co.api.service.dao.ListingsDAO;

public class ListingsDAOImpl implements ListingsDAO{

    private Connection con=null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ListingsDAOImpl(Connection con) {
        this.con = con;
    }
    @Override
    public boolean addListing(Listing list) {
        try {
            ps = con.prepareStatement("INSERT INTO listing(jobId,appId) VALUES(?,?)");
            ps.setInt(1, list.getJobId());
            ps.setInt(2,list.getCandidates());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
            return false;
        }
        return true;
    }

    @Override
    public Listing getListing(int lsId) {
        Listing list = new Listing();
        try {
            ps= con.prepareStatement("SELECT listingId,appId,jobId FROM listing WHERE listingId=?");
            ps.setInt(1, lsId);
            rs=ps.executeQuery();
            while(rs.next()){
                list=new Listing(lsId,rs.getInt("listingId"),rs.getInt("appId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean deleteListing(int lsId) {
        boolean res = false;
        try {
            ps= con.prepareStatement("DELETE FROM Listing WHERE listingId=?");
            ps.setInt(1, lsId);
            if(ps.executeUpdate()>0){
                res=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
}
