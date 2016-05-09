package armaganzasoft.repositorys;

import armaganzasoft.models.Measurement;
import armaganzasoft.models.Recipe;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import armaganzasoft.repositorys.BaseRepository;

/**
 *
 * @author ErwinValle
 */
public class MeasurementRepository extends BaseRepository {
    
    private PreparedStatement query;
    
    public MeasurementRepository() {
        
    }
    
     public boolean addReceta(Measurement measurement){
        
        try {
            
            query = con.prepareStatement("INSERT INTO measurement (code, "
                                                          + "name, "
                                                          + "agua, "
                                                          + "arena,"          
                                                          + "grava,"
                                                          + "cemento,"
                                                          + "aditivo ) "
                                                         
                                        + "VALUES(?,?,?,?,?,?,?);"
                                        );
            
            
            query.setString(1, measurement.getCode());
            query.setString(2, measurement.getName());
            query.setString(3, measurement.getAgua());
            query.setString(4, measurement.getArena());
            query.setString(5, measurement.getGrava());
            query.setString(6, measurement.getCemento());
            query.setString(7, measurement.getAditivo());
            
            
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
