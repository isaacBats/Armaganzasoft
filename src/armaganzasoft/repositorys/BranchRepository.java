/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;
import armaganzasoft.models.Branch;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class BranchRepository extends BaseRepository {
    
    private PreparedStatement query;
    
    public BranchRepository() {
        
    }
    
     public boolean addBranch(Branch branch){
        
        try {
            
            query = con.prepareStatement("INSERT INTO branches (name, "
                                                          + "adress, "
                                                          + "telephone, "
                                                          + "city, "
                                                          + "zip_code, "
                                                          + "rfc, "
                                                          + "email) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            query.setString(1, branch.getName());
            query.setString(2, branch.getAdress());
            query.setString(3, branch.getTelephone());
            query.setString(4, branch.getCity());
            query.setString(5, branch.getZip_code());
            query.setString(6, branch.getRfc());
            query.setString(7, branch.getEmail());
            
            
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
