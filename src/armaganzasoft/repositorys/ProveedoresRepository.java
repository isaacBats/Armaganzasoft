/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

import armaganzasoft.models.Provider;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class ProveedoresRepository extends BaseRepository {
    
    private PreparedStatement query;
    
    public ProveedoresRepository() {
        
    }
    
     public boolean addProv(Provider provider){
        
        try {
            
            query = con.prepareStatement("INSERT INTO providers (contact_name, "
                                                          + "company, "
                                                          + "email, "
                                                          + "telephone, "
                                                          + "fax, "
                                                          + "movil_1, "
                                                          + "notes, "
                                                          + "active) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            query.setString(1, provider.getContact_name());
            query.setString(2, provider.getCompany());
            query.setString(3, provider.getEmail());
            query.setString(4, provider.getTelephone());
            query.setString(5, provider.getFax());
            query.setString(6, provider.getMovil_1());
            query.setString(7, provider.getNotes());
            query.setBoolean(8, provider.isActive());
            
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
