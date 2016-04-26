package armaganzasoft.repositorys;

import armaganzasoft.models.Customer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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
            
            query = con.prepareStatement("INSERT INTO customers (identified, name, "
                                                          + "last_name, "
                                                          + "email, "
                                                          + "telephone, "
                                                          + "movil, "
                                                          + "rfc, "
                                                          + "address, "
                                                          + "city, "
                                                          + "zip_code, " 
                                                          + "sub_customer, "
                                                          + "costumer_id) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            customer.setIdentified("CL00");
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
            System.out.println(customer.getCustomer_id());
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
     
    public Customer buscarCliente(String identified){
        String where ="";
        ResultSet rs;
        Customer busqueda = new Customer();
        if(identified != null || identified != ""){
        where = "WHERE email LIKE '"+identified+"' OR name LIKE '"+identified+"' OR last_name LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM customers "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                busqueda.setCustomer_id(rs.getString("costumer_id"));
                busqueda.setName(rs.getString("name"));
                busqueda.setLast_name(rs.getString("last_name"));
                busqueda.setEmail(rs.getString("email"));
                busqueda.setTelephone(rs.getString("telephone"));
                busqueda.setMovil(rs.getString("movil"));
                busqueda.setRfc(rs.getString("rfc"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar un Cliente: "+ex);
        }
        return null;
    }
    
    public boolean edit(Customer cliente){
        
        try {
            
            query = con.prepareStatement("UPDATE customers SET   identified   = ?, "
                                                           +"    name         = ?, "
                                                           +"    last_name    = ?, "
                                                           +"    email        = ?, "
                                                           +"    telephone    = ?, "
                                                           +"    movil        = ?, "
                                                           +"    rfc          = ?, "
                                                           +"    address      = ?, "
                                                           +"    city         = ?, "
                                                           +"    zip_code     = ?, "
                                                           +"    sub_customer = ?, "
                                                           +"    costumer_id  = ? "
                                                           +" WHERE id = ?;");
            query.setString(1, cliente.getIdentified());
            query.setString(2, cliente.getName());
            query.setString(3, cliente.getLast_name());
            query.setString(4, cliente.getEmail());
            query.setString(5, cliente.getTelephone());
            query.setString(6, cliente.getMovil());
            query.setString(7, cliente.getRfc());
            query.setString(8, cliente.getAdress());
            query.setString(9, cliente.getCity());
            query.setString(10, cliente.getZip_code());
            query.setString(11, cliente.getSub_customer());
            query.setString(12, cliente.getCustomer_id());
            query.setInt(13, cliente.getId());
            
            if( !query.execute() ){
                System.out.println("Se edito el cliente correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar el cliente: "+ ex);
        }
        
        return false;
    }
}
