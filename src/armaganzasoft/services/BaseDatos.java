package armaganzasoft.services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Isaac Daniel
 */
public class BaseDatos {
    
    
    
    private final String URL        = "jdbc:mysql://localhost:3306/";
    
    private Connection conn = null;
    
    public Connection getConnection(){
        
        Properties properties = new Properties();
        InputStream input = null;
        
        try{ 
            input = new FileInputStream("config_db.properties");
            properties.load(input);
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection( URL+properties.getProperty("database"), properties.getProperty("dbuser"), properties.getProperty("dbpassword") );
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
