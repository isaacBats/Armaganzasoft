/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.tests;

import armaganzasoft.services.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author daniel
 */
public class BaseDatosTest {
    
    
    public void test_connection_data_base(){
    
         try {

            String sql = "SELECT * FROM users";
            
            BaseDatos conn = new BaseDatos();
            Statement statement = conn.getConnection().createStatement();
            
            ResultSet rs;
            
            rs = statement.executeQuery(sql);
            
//            while(rs.next()){
//                System.out.println(rs.getString("name"));
//            }

            assertTrue(rs.first());            
            conn.closeConnection();
            
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex );
        }
        
        
    }
    
}
