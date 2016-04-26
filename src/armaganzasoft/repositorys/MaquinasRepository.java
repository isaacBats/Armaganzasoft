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

import armaganzasoft.models.Machines;
import armaganzasoft.interfaces.EquipoDeTrabajo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaquinasRepository extends BaseRepository {
    private PreparedStatement query;
    
    public MaquinasRepository() {
        
    }
    
     public boolean addMaq(Machines machines){
         
        
        try {
            
            query = con.prepareStatement("INSERT INTO machines (name, "
                                        +"code,"
                                        +"value)"
                                        + "VALUES(?,?,?);"
                                        );
                      
            
            query.setString(1, machines.getName());
            query.setString(2, machines.getCode());
            query.setString(3, machines.getValue());

  
            
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
