/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

/**
 *
 * @author rodri
 */


import armaganzasoft.models.Material;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaterialesRepository extends BaseRepository {
    private PreparedStatement query;
    
    public MaterialesRepository() {
        
    }
    
     public boolean addMat(Material material){
        
        try {
            
            query = con.prepareStatement("INSERT INTO materials (name "
                                        +"code)"
                                        + "VALUES(?,?);"
                                        );
            query = con.prepareStatement("INSERT INTO material_attribute (value)"                                        
                                        + "VALUES(?);"
                                        );
            
            
            
            query.setString(1, material.getName());
            query.setString(2, material.getCode());
            query.setString(3, material.getValue());

  
            
            if( !query.execute() ){
                return true;
            }
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }finally{
            return false;
        }
    }    

    
}
