package armaganzasoft.repositorys;

import armaganzasoft.models.Order;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        List<String> detailForm;
        
        detailForm = new ArrayList<String>();
        String sql = "SELECT df.order, ope.code, ope.name, mat.name, CONCAT(df.value, df.type) as value " +
                     "FROM detail_form df " +
                     "INNER JOIN operations ope on df.operation_id = ope.id " +
                     "INNER JOIN materials mat oN df.material_id = mat.id " +
                     "WHERE form_id = 1";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sql );

            while (rs.next()) {
                detailForm.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("No se ejecuto el query "+ sql);
        }
        
    }
    
}