package armaganzasoft.repositorys;

import armaganzasoft.models.Costumer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author ErwinValle
 */
public class CostumerRepository extends BaseRepository {
    
    private PreparedStatement query;
    
    public CostumerRepository() {
        
    }
    
     public boolean addCustom(Costumer customer){
        
        try {
            
            query = con.prepareStatement("INSERT INTO customers (name, "
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
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
          
            query.setString(1, customer.getName());
            query.setString(2, customer.getLast_name());
            query.setString(3, customer.getEmail());
            query.setString(4, customer.getTelephone());
            query.setString(5, customer.getMovil());
            query.setString(6, customer.getRfc());
            query.setString(7, customer.getAdress());
            query.setString(8, customer.getCity());
            query.setString(9, customer.getZip_code());
            query.setString(10, customer.getSub_customer());
            query.setString(11, customer.getCustomer_id());
            
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
     
    public Customer buscarCliente(Customer cliente){
        String where ="";
        ResultSet rs;
        Customer busqueda = new Customer();
        if(cliente.getCustomer_id() != null ||
           cliente.getCustomer_id() != ""   ||
           cliente.getName()       != null ||
           cliente.getName()       != ""   ||
           cliente.getEmail()      != null ||
           cliente.getEmail()      != ""){
        where = "WHERE customer_id LIKE '"+cliente.getCustomer_id()+"' OR "
              + "name       LIKE '"+cliente.getName()+"' OR "
              + "email      LIKE '"+cliente.getEmail()+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM customers "+where);
            rs = query.executeQuery();
            if(rs.next()){
                while(rs.next())             
                busqueda.setCustomer_id(rs.getString("customer_id"));
                busqueda.setName(rs.getString("name"));
                busqueda.setLast_name(rs.getString("last_name"));
                busqueda.setEmail(rs.getString("email"));
                busqueda.setTelephone(rs.getString("telephone"));
                busqueda.setMovil(rs.getString("movil"));
                busqueda.setRfc(rs.getString("rfc"));
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
            }
            } catch (SQLException ex) {
            System.out.println("Erro al consultar un Cliente: "+ex);
        }
        return null;
    }
}
