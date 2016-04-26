/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;
import armaganzasoft.models.Branch;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author rodri
 */
public class BranchRepository extends BaseRepository {
    
    private PreparedStatement query;
    
    public BranchRepository() {
        
    }
    
     public boolean addBranch(Branch branch){
        
        try {
            
            query = con.prepareStatement("INSERT INTO branches (name, "
                                                          + "adress, "
                                                          + "telephone, "
                                                          + "city, "
                                                          + "zip_code, "
                                                          + "rfc, "
                                                          + "email) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            query.setString(1, branch.getName());
            query.setString(2, branch.getAdress());
            query.setString(3, branch.getTelephone());
            query.setString(4, branch.getCity());
            query.setString(5, branch.getZip_code());
            query.setString(6, branch.getRfc());
            query.setString(7, branch.getEmail());
            
            
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
   
      public Branch buscarPlanta(String identified){
        String where ="";
        ResultSet rs;
        Branch busqueda = new Branch();
        if(identified != null || identified != ""){
        where = "WHERE name LIKE '"+identified+"' OR rfc LIKE '"+identified+"' OR email LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM branches "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setName(rs.getString("name"));
                busqueda.setAdress(rs.getString("adress"));
                busqueda.setTelephone(rs.getString("telephone"));
                busqueda.setCity(rs.getString("city"));
                busqueda.setZip_code(rs.getString("zip_code"));
                busqueda.setRfc(rs.getString("rfc"));
                busqueda.setEmail(rs.getString("email"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar un Cliente: "+ex);
        }
        return null;
    }
    
    public boolean edit(Branch cliente){
        
        try {
            
            query = con.prepareStatement("UPDATE customers SET   name         = ?, "
                                                           +"    adress    = ?, "
                                                           +"    telephone        = ?, "
                                                           +"    city    = ?, "
                                                           +"    zip_code        = ?, "
                                                           +"    rfc          = ?, "
                                                           +"    email      = ?, "
                                                           +" WHERE id = ?;");
            
            query.setString(1, cliente.getName());
            query.setString(2, cliente.getAdress());
            query.setString(3, cliente.getTelephone());
            query.setString(4, cliente.getCity());
            query.setString(5, cliente.getZip_code());
            query.setString(5, cliente.getRfc());           
            query.setString(6, cliente.getEmail());
           
                               
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
     
    

