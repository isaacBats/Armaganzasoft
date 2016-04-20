package armaganzasoft.repositorys;

import armaganzasoft.models.Costumer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            query.setString(3, customer.getLastName());
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
     
    public Costumer buscarCliente(Costumer cliente){
    
        String where ="";
        ResultSet rs;
        Costumer busqueda = new Costumer();
        if(cliente.getIdentified() != null ||
           cliente.getIdentified() != ""   ||
           cliente.getName()       != null ||
           cliente.getName()       != ""   ||
           cliente.getEmail()      != null ||
           cliente.getEmail()      != ""){
        where = "WHERE identified LIKE '"+cliente.getIdentified()+"' OR "
              + "name       LIKE '"+cliente.getName()+"' OR "
              + "email      LIKE '"+cliente.getEmail()+"';";
        }
        
        try {
            query = con.prepareStatement("SELECT * FROM customers "+where);
            rs = query.executeQuery();
            if(rs.next()){
                //while(rs.next())
                busqueda.setIdentified(rs.getString("identified"));
                busqueda.setName(rs.getString("name"));
                busqueda.setLastName(rs.getString("last_name"));
                return busqueda;
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro al consultar un Cliente: "+ex);
        }
        return null;
    }

    
    
}
