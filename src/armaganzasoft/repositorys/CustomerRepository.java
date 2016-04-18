package armaganzasoft.repositorys;

import armaganzasoft.models.Customer;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ErwinValle
 */
public class CustomerRepository extends BaseRepository {
    
    private PreparedStatement query;
    
    public CustomerRepository() {
        
    }
    
     public boolean addCustom(Customer customer){
        
        try {
            
            query = con.prepareStatement("INSERT INTO customers (identified, "
                                                          + "name, "
                                                          + "last_name, "
                                                          + "email, "
                                                          + "telephone, "
                                                          + "movil, "
                                                          + "rfc, "
                                                          + "adress, "
                                                          + "city, "
                                                          + "zip_code, " 
                                                          + "sub_customer, "
                                                          + "customer_id) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            query.setString(1, customer.getIdentified());
            query.setString(2, customer.getName());
            query.setString(3, customer.getLast_name());
            query.setString(4, customer.getEmail());
            query.setString(5, customer.getTelephone());
            query.setString(6, customer.getMovil());
            query.setString(7, customer.getRfc());
            query.setString(8, customer.getAdress());
            query.setString(9, customer.getCity());
            query.setString(10, customer.getZip_code());
            query.setString(11, customer.getSub_customer());
            query.setString(12, customer.getCustomer_id());
            
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
