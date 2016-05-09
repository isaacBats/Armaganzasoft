/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

import armaganzasoft.models.Provider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rodri
 */
public class ProveedoresRepository extends BaseRepository {
    
    private PreparedStatement query;
    
    public ProveedoresRepository() {
        
    }
    
     public boolean addProv(Provider provider){
        
        try {
            
            query = con.prepareStatement("INSERT INTO providers (code,"
                                                          + "contact_name, "
                                                          + "company, "
                                                          + "email, "
                                                          + "telephone, "
                                                          + "fax, "
                                                          + "movil_1, "
                                                          + "notes, "
                                                          + "active) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);"
                                        );
            
            
            query.setString(1, provider.getCode());
            query.setString(2, provider.getContact_name());
            query.setString(3, provider.getCompany());
            query.setString(4, provider.getEmail());
            query.setString(5, provider.getTelephone());
            query.setString(6, provider.getFax());
            query.setString(7, provider.getMovil_1());
            query.setString(8, provider.getNotes());
            query.setString(9, provider.getActive());
            
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
     public Provider buscarProveedor(String identified){
        String where ="";
        ResultSet rs;
        Provider busqueda = new Provider ();
        if(identified != null || identified != ""){
        where = "WHERE contact_name LIKE '"+identified+"' OR code LIKE '"+identified+"' OR email LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM providers "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setCode(rs.getString("code"));
                busqueda.setContact_name(rs.getString("contact_name"));
                busqueda.setCompany(rs.getString("company"));
                busqueda.setEmail(rs.getString("email"));
                busqueda.setTelephone(rs.getString("telephone"));
                busqueda.setFax(rs.getString("fax"));
                busqueda.setMovil_1(rs.getString("movil_1"));
                busqueda.setNotes(rs.getString("notes"));
                busqueda.setActive(rs.getString("active"));
                busqueda.setId(rs.getInt("id"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar un Proveedor: "+ex);
        }
        return null;
    }
    
    public boolean edit(Provider provider){
        
        try {
            
            query = con.prepareStatement("UPDATE providers SET  code =?,"
                                                          + "contact_name =?, "
                                                          + "company =?, "
                                                          + "email =?, "
                                                          + "telephone=?, "
                                                          + "fax=?, "
                                                          + "movil_1=?, "
                                                          + "notes=?, "
                                                          + "active=? "
                                                          + "WHERE id=?");
            
            query.setString(1, provider.getCode());
            query.setString(2, provider.getContact_name());
            query.setString(3, provider.getCompany());
            query.setString(4, provider.getEmail());
            query.setString(5, provider.getTelephone());
            query.setString(6, provider.getFax());
            query.setString(7, provider.getMovil_1());
            query.setString(8, provider.getNotes());
            query.setString(9, provider.getActive());
            query.setInt(10, provider.getId());
            
            if( !query.execute() ){
                System.out.println("Se edito el proveedor correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar el proveedor: "+ ex);
        }
        
        return false;
    }


public boolean eliminar(Provider provider){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM providers WHERE   id = "+provider.getId());
            
       
            
            
                               
            if( !query.execute() ){
                System.out.println("Se elimino el proveedor correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el proveedor: "+ ex);
        }
        
        return false;
    }
}
     
    



    

