package armaganzasoft.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Isaac Daniel
 */
public class BaseDatos {
    
    private final String URL        = "jdbc:mysql://localhost:3306/";
    private final String DB         = "armaganza";
    private final String USER       = "root";
    private final String PASSWORD   = "sasa";
    
    private Connection conn = null;
    
    public Connection getConnection(){
        
        try{            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL+DB, USER, PASSWORD);
            if(conn != null){
                System.out.println("Open Connection");
            }            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return conn;
        }
    }
    
    public void closeConnection() throws SQLException{
        conn.close();
        System.out.println("Close Connection");
    }
    
}
