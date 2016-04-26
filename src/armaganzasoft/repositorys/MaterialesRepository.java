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


import armaganzasoft.models.Materials;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaterialsRepository extends BaseRepository {
    private PreparedStatement query;
    
    public MaterialsRepository() {
        
    }
    
     public boolean addMat(Materials materials){
        
        try {
            
            query = con.prepareStatement("INSERT INTO materials (name, "
                                        +"code,"
                                        +"value)"
                                        + "VALUES(?,?,?);"
                                        );
                       
            
            query.setString(1, materials.getName());
            query.setString(2, materials.getCode());
            query.setString(3, materials.getValue());

  
            
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
