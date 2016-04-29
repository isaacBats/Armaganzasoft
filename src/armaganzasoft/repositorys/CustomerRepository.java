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
    
     public boolean addCostum(Costumer costumer){
        
        try {
            
            query = con.prepareStatement("INSERT INTO costumers (name, "
                                                          + "last_name, "
                                                          + "email, "
                                                          + "telephone, "
                                                          + "movil, "
                                                          + "rfc, "
                                                          + "address, "
                                                          + "city, "
                                                          + "zip_code, " 
                                                          + "sub_costumer, "
                                                          + "costumer_id) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            
            query.setString(1, costumer.getName());
            query.setString(2, costumer.getLast_name());
            query.setString(3, costumer.getEmail());
            query.setString(4, costumer.getTelephone());
            query.setString(5, costumer.getMovil());
            query.setString(6, costumer.getRfc());
            query.setString(7, costumer.getAddress());
            query.setString(8, costumer.getCity());
            query.setString(9, costumer.getZip_code());
            query.setString(10, costumer.getSub_costumer());
            query.setString(11, costumer.getCostumer_id());
            
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
     
     public Costumer buscarCliente(String identified){
        String where ="";
        ResultSet rs;
        Costumer busqueda = new Costumer ();
        if(identified != null || identified != ""){
        where = "WHERE email LIKE '"+identified+"' OR rfc LIKE '"+identified+"' OR costumer_id LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM costumers "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setSub_costumer(rs.getString("sub_costumer"));
                busqueda.setCostumer_id(rs.getString("costumer_id"));
                busqueda.setName(rs.getString("name"));
                busqueda.setLast_name(rs.getString("last_name"));
                busqueda.setEmail(rs.getString("email"));
                busqueda.setTelephone(rs.getString("telephone"));
                busqueda.setMovil(rs.getString("movil"));
                busqueda.setRfc(rs.getString("rfc"));
                busqueda.setAddress(rs.getString("address"));
                busqueda.setCity(rs.getString("city"));
                busqueda.setZip_code(rs.getString("zip_code"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar un Cliente: "+ex);
        }
        return null;
    }
    
    public boolean edit(Costumer costumer){
        
        try {
            
            query = con.prepareStatement("UPDATE costumers SET     name         = ?, "
                                                           +"    last_name    = ?, "
                                                           +"    email        = ?, "
                                                           +"    telephone    = ?, "
                                                           +"    movil        = ?, "
                                                           +"    rfc          = ?, "
                                                           +"    address      = ?, "
                                                           +"    city         = ?, "
                                                           +"    zip_code     = ?, "
                                                           +"    sub_costumer = ?, "
                                                           +"    costumer_id  = ? "
                                                           +" WHERE id = ?;");
            
            query.setString(1, costumer.getName());
            query.setString(2, costumer.getLast_name());
            query.setString(3, costumer.getEmail());
            query.setString(4, costumer.getTelephone());
            query.setString(5, costumer.getMovil());
            query.setString(6, costumer.getRfc());
            query.setString(7, costumer.getAddress());
            query.setString(8, costumer.getCity());
            query.setString(9, costumer.getZip_code());
            query.setString(10, costumer.getSub_costumer());
            query.setString(11, costumer.getCostumer_id());
            query.setInt(12, costumer.getId());
            
            if( !query.execute() ){
                System.out.println("Se modifico el cliente correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modifico el cliente: "+ ex);
        }
        
        return false;
    }
    public boolean eliminar(Costumer costumer){
        
        try {
            
            query = con.prepareStatement("REMOVE costumers SET name=?, "
                                                          + "last_name=?, "
                                                          + "telephone=?, "
                                                          + "movil=?, "
                                                          + "address=?, "
                                                          + "city=?, "
                                                          + "zip_code=?, " 
                                                          + "sub_costumer=? "
                                                          );
                                                          
            
            query.setString(1, costumer.getName());
            query.setString(2, costumer.getLast_name());
            query.setString(3, costumer.getTelephone());
            query.setString(4, costumer.getMovil());
            query.setString(5, costumer.getAddress());
            query.setString(6, costumer.getCity());
            query.setString(7, costumer.getZip_code());
            query.setString(8, costumer.getSub_costumer());
            
          
            
            if( !query.execute() ){
                System.out.println("Se modifico el cliente correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modifico el cliente: "+ ex);
        }
        
        return false;
 
    }
 
}
}
