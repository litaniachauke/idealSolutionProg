
package za.co.precious.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager{

  private Connection con = null;
  private String url;
  private String username;
  private String database;
  private String password;
  private String driver;
// ***********************************************************************

    public DBManager(String url, String username, String database, String password, String driver) {
        this.url = url;
        this.username = username;
        this.database = database;
        this.password = password;
        this.driver = driver;
    }

 
  public Connection getConnection(){
    if(con == null){
      createConnection();
    }
    return con;
  }
  
// ***********************************************************************
   public boolean closeConnection(){
     boolean retVal = false;     
       if (con!=null){
         try{
           con.close();
           retVal=true;
         }catch(SQLException ex){
           System.out.println("Error closing connection: "+ex.getMessage());
         }finally{
           con=null;
         }
       }
    return retVal;
  }
  
// ***********************************************************************
   private boolean createConnection(){
     boolean retVal=false;
     
     try{
       Class.forName(driver);
     }catch(ClassNotFoundException ex){
       System.out.println("Error: "+ex.getMessage());
       return retVal;
     }
     System.out.println("Driver Loaded");

     String ourUri = url+database;
     try{
       con = DriverManager.getConnection(ourUri,username,password);
       retVal=true;
     }catch(SQLException ex){
       System.out.println("Ooops Could not connect: "+ex.getMessage());
       return retVal;
     }
     return retVal;        
   }
   // ***********************************************************************

    @Override
    public String toString() {
        return "DBManager{" + "con=" + con + ", url=" + url + ", username=" + username + ", database=" + database + ", password=" + password + ", driver=" + driver + '}';
    }
   
}
