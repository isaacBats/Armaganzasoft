package armaganzasoft.repositorys;

import armaganzasoft.models.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author rodri
 */
public class UserRepository extends BaseRepository {
     
    /**
     * Sentence to execute in database
     */
    private PreparedStatement query;
    
    
    

    public UserRepository() {
        
    }
    
    /**
     * Insert a new User in data Base
     * @param user
     * @return Boolean   True if I was inserted into the Data Base
     */
    public boolean addUsuario(User user){
        
        try {
            
            query = con.prepareStatement("INSERT INTO users (num_employee, "
                                                          + "name, "
                                                          + "last_name, "
                                                          + "email, "
                                                          + "password,"
                                                          + "usuario, "
                                                          + "position, "
                                                          + "roll, "
                                                          + "active) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?,?);"
                                        );
            
            
            query.setString(1, user.getNum_employee());
            query.setString(2, user.getName());
            query.setString(3, user.getLast_name());
            query.setString(4, user.getEmail());
            query.setString(5, user.getPassword());
            query.setString(6, user.getUsuario());
            query.setString(7, user.getPosition());
            query.setString(8, user.getRoll());
            query.setString(9, user.getActive());
            
            
            
            
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
    
   public User buscarUsuario(String identified){
        String where ="";
        ResultSet rs;
        User busqueda = new User();
        if(identified != null || identified != ""){
        where = "WHERE email LIKE '"+identified+"' OR usuario LIKE '"+identified+"' OR num_employee LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM users "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setNum_employee(rs.getString("num_employee"));
                busqueda.setName(rs.getString("name"));
                busqueda.setLast_name(rs.getString("last_name"));
                busqueda.setEmail(rs.getString("email"));
                busqueda.setPassword(rs.getString("password"));
                busqueda.setUsuario(rs.getString("usuario"));
                busqueda.setPosition(rs.getString("position"));
                busqueda.setRoll(rs.getString("roll"));
                busqueda.setActive(rs.getString("active"));
                busqueda.setId(rs.getInt("id"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar el usuario: "+ex);
        }
        return null;
    }
    
    public boolean edit(User usuario){
        
        try {
            
            query = con.prepareStatement("UPDATE users SET   num_employee   = ?, "
                                                           +"    name         = ?, "
                                                           +"    last_name    = ?, "
                                                           +"    email        = ?, "
                                                           +"    password    = ?, "
                                                           +"    usuario        = ?, "
                                                           +"    position      = ?, "
                                                           +"    roll      = ?, "
                                                           +"    active         = ?"
                                                           + "WHERE id =?"      );
            query.setString(1, usuario.getNum_employee());
            query.setString(2, usuario.getName());
            query.setString(3, usuario.getLast_name());
            query.setString(4, usuario.getEmail());
            query.setString(5, usuario.getPassword());
            query.setString(6, usuario.getUsuario());
            query.setString(7, usuario.getPosition());
            query.setString(8, usuario.getRoll());
            query.setString(9, usuario.getActive());
             query.setInt(10, usuario.getId());
            
            if( !query.execute() ){
                System.out.println("Se edito el usuario correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar el usuario: "+ ex);
        }
        
        return false;
    }


public boolean eliminar(User user){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM users WHERE   id = "+user.getId());
             
            
                               
            if( !query.execute() ){
                System.out.println("Se elimino el usuario correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el usuario: "+ ex);
        }
        
        return false;
    }}
     
    


