package armaganzasoft.repositorys;

import armaganzasoft.models.Operation;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import armaganzasoft.repositorys.BaseRepository;

/**
 *
 * @author ErwinValle
 */
public class OperationRepository extends BaseRepository {
    
    private PreparedStatement query;
    
    public OperationRepository() {
        
    }
    
     public boolean addOpera(Operation operation){
        
        try {
            
            query = con.prepareStatement("INSERT INTO operations (code, "
                                                          + "name) "
                                                          
                                        + "VALUES(?,?);"
                                        );
            
            
            query.setString(1, operation.getCode());
            query.setString(2, operation.getName());
            
            
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
