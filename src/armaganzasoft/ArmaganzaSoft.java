/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft;

import armaganzasoft.services.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author daniel
 */
public class ArmaganzaSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {

            String sql = "SELECT * FROM users";
            
            BaseDatos conn = new BaseDatos();
            Statement statement = conn.getConnection().createStatement();
            
            ResultSet rs;
            
            rs = statement.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
            
            conn.closeConnection();
            
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex );
        }
        
               
    }
    
}
