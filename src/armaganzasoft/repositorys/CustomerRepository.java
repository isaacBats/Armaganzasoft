package armaganzasoft.repositorys;

import armaganzasoft.models.Customer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

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
            
            query = con.prepareStatement("INSERT INTO customers (name, "
                                                          + "last_name, "
                                                          + "email, "
                                                          + "telephone, "
                                                          + "movil, "
                                                          + "rfc, "
                                                          + "address, "
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
            query.setString(7, customer.getAddress());
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
     
     public Customer buscarCliente(String identified){
        String where ="";
        ResultSet rs;
        Customer busqueda = new Customer ();
        if(identified != null || identified != ""){
        where = "WHERE email LIKE '"+identified+"' OR rfc LIKE '"+identified+"' OR customer_id LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM customers "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setSub_customer(rs.getString("sub_customer"));
                busqueda.setCustomer_id(rs.getString("customer_id"));
                busqueda.setName(rs.getString("name"));
                busqueda.setLast_name(rs.getString("last_name"));
                busqueda.setEmail(rs.getString("email"));
                busqueda.setTelephone(rs.getString("telephone"));
                busqueda.setMovil(rs.getString("movil"));
                busqueda.setRfc(rs.getString("rfc"));
                busqueda.setAddress(rs.getString("address"));
                busqueda.setCity(rs.getString("city"));
                busqueda.setZip_code(rs.getString("zip_code"));
                busqueda.setId(rs.getInt("id"));
                }             
                
                
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar un Cliente: "+ex);
        }
        return null;
    }
    
  public boolean edit (Customer customer) {
      try{
          
          query=con.prepareStatement("UPDATE customers SET name=?,"
                                                       +" last_name=?,"
                                                       +" email=?,"
                                                       +"telephone=?,"
                                                       +"movil=?,"
                                                       +"rfc=?,"
                                                       +"address=?,"
                                                       +"city=?,"
                                                       +"zip_code=?,"
                                                       +"sub_customer=?,"
                                                       +"customer_id=?"
                                                        +"WHERE id=?"     );
            query.setString(1, customer.getName());
            query.setString(2, customer.getLast_name());
            query.setString(3, customer.getEmail());
            query.setString(4, customer.getTelephone());
            query.setString(5, customer.getMovil());
            query.setString(6, customer.getRfc());
            query.setString(7, customer.getAddress());
            query.setString(8, customer.getCity());
            query.setString(9, customer.getZip_code());
            query.setString(10, customer.getSub_customer());
            query.setString(11, customer.getCustomer_id());
            query.setInt(12, customer.getId());
          
            
            
           if( !query.execute() ){
               System.out.println("Se edito el Cliente correctamente");
                return true;
           }
           
           
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar Cliente: "+ ex);
        }
        
        return false;
    }
    public boolean eliminar(Customer customer){
         try {
             query = con.prepareStatement("DELETE  FROM customers WHERE   id = "+customer.getId());
             if( !query.execute() ){
                 System.out.println("Se elimino el cliente correctamente");
                 return true;
             }            
             query.close();            
         } catch (SQLException ex) {
             System.out.println("Error al eliminar cliente: "+ ex);
         }        
         return false;
    }
    
    public ResultSet getallCostumers(){
    
        Statement stmt;       
        
        String sql = "SELECT * FROM customers";
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
     
    