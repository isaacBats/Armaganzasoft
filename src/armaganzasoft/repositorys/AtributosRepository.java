/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

import armaganzasoft.models.Atributo;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class AtributosRepository extends BaseRepository {
    
    private PreparedStatement query;
    
    public AtributosRepository() {
        
    }
    
     public boolean addAtrib(Atributo atributo){
        
        try {
            
            query = con.prepareStatement("INSERT INTO attributes (name_attribute) "
                                        + "VALUES(?);"
                                        );
            
            
            query.setString(1, atributo.getIdentified());
  
            
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

     public boolean edit(Atributo atributo){
        
        try {
            
            query = con.prepareStatement("UPDATE attributes SET name_attribute = ? WHERE id = ?;");
            query.setString(1, atributo.getIdentified());
            query.setInt(2, atributo.getId());
            
            if( !query.execute() ){
                System.out.println("Se edito el atributo correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar un atributo: "+ ex);
        }
        
        return false;
    } 
  
    
}
