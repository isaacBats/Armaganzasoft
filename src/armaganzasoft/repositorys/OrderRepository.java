package armaganzasoft.repositorys;

import armaganzasoft.models.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rodri
 */
public class OrderRepository extends BaseRepository {
     
    /**
     * Sentence to execute in database
     */
    private PreparedStatement query;
    
    

    public OrderRepository() {
        
    }
    
    /**
     * Insert a new User in data Base
     * @param user
     * @return Boolean   True if I was inserted into the Data Base
     */
    public boolean addOrden(Order order){
        
        try {
            
            query = con.prepareStatement("INSERT INTO users (num_employee, "
                                                          + "name, "
                                                          + "last_name, "
                                                          + "email, "
                                                          + "password, "
                                                          + "position, "
                                                          + "roll, "
                                                          + "active) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            query.setString(1, order.getNum_employee());
            query.setString(2, order.getName());
            query.setString(3, order.getLast_name());
            query.setString(4, order.getEmail());
            query.setString(5, order.getPassword());
            query.setString(6, order.getPosition());
            query.setString(7, order.getRoll());
            query.setBoolean(8, order.isActive());
            
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
    
    public ResultSet getDetailForm( int formId ){
    
        Statement stmt = null;       
        
        String sql = "SELECT df.order, ope.code, ope.descripcion, mat.name, CONCAT(df.value, df.type) as value " +
                     "FROM detail_form df " +
                     "INNER JOIN operations ope ON df.operation_id = ope.id " +
                     "INNER JOIN materials mat ON df.material_id = mat.id " +
                     "WHERE form_id = " + formId;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            return rs;
        } catch (SQLException e) {
            System.out.println("No se ejecuto el query "+ e);
            System.out.println(sql);
        }
        
        return null;
    }
    
    public ResultSet getForm( int formId ){
    
        Statement stmt = null;       
        
        String sql = "SELECT m.tipo, CONCAT(df.value, df.type) as porcentaje, '10%' as teorico " +
                     "FROM detail_form df " +
                     "INNER JOIN materials m ON df.material_id = m.id " +
                     "WHERE df.form_id = " + formId;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            return rs;
        } catch (SQLException e) {
            System.out.println("No se ejecuto el query "+ e);
            System.out.println(sql);
        }
        
        return null;
    }
        
}