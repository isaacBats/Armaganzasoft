package armaganzasoft.repositorys;

import armaganzasoft.models.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class UserRepository extends BaseRepository {
     
    /**
     * Sentence to execute in database
     */
    private PreparedStatement query;
    
    

    public UserRepository() {
        
    }
    
    /**
     * Insert a new User in data Base
     * @return Boolean   True if I was inserted into the Data Base
     */
    public boolean addUsuario(User user){
        
        try {
            
            query = con.prepareStatement("INSERT INTO users (branch_id,"
                                                          + "num_employee, "
                                                          + "name, "
                                                          + "lastname, "
                                                          + "email, "
                                                          + "user, "
                                                          + "pass, "
                                                          + "posotion, "
                                                          + "roll, "
                                                          + "active) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            query.setInt(1, user.getBranch_id());
            query.setString(2, user.getNum_employee());
            query.setString(3, user.getName());
            query.setString(4, user.getLast_name());
            query.setString(5, user.getEmail());
            query.setString(6, user.getUser());
            query.setString(7, user.getPassword());
            query.setString(8, user.getPosition());
            query.setString(9, user.getRoll());
            query.setBoolean(8, user.isActive());
            
            if( query.execute() )
                return true;
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }finally{
            return false;
        }
    }    
    
}
