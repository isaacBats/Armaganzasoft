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
                                                          + "address, "
                                                          + "telephone, "
                                                          + "city, "
                                                          + "zip_code, "
                                                          + "rfc, "
                                                          + "email) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            query.setString(1, branch.getName());
            query.setString(2, branch.getAddress());
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
                busqueda.setAddress(rs.getString("address"));
                busqueda.setTelephone(rs.getString("telephone"));
                busqueda.setCity(rs.getString("city"));
                busqueda.setZip_code(rs.getString("zip_code"));
                busqueda.setRfc(rs.getString("rfc"));
                busqueda.setEmail(rs.getString("email"));
                busqueda.setId(rs.getInt("id"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar un Cliente: "+ex);
        }
        return null;
    }
    
    public boolean edit(Branch branch){
        
        try {
            
            query = con.prepareStatement("UPDATE branches SET   name         = ?, "
                                                           +"    address    = ?, "
                                                           +"    telephone        = ?, "
                                                           +"    city    = ?, "
                                                           +"    zip_code        = ?, "
                                                           +"    rfc          = ?, "
                                                           +"    email      = ?, "
                                                           );
            
            query.setString(1, branch.getName());
            query.setString(2, branch.getAddress());
            query.setString(3, branch.getTelephone());
            query.setString(4, branch.getCity());
            query.setString(5, branch.getZip_code());
            query.setString(6, branch.getRfc());           
            query.setString(7, branch.getEmail());
           
                               
            if( !query.execute() ){
                System.out.println("Se editar Planta correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar Planta: "+ ex);
        }
        
        return false;
    }



      public boolean eliminar(Branch branch){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM branches WHERE   rfc = '"+branch.getRfc()+"'");
            
       
            
            
                               
            if( !query.execute() ){
                System.out.println("Se elimino la planta correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la planta: "+ ex);
        }
        
        return false;
    }
}
     
    

