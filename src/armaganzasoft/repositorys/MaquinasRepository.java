/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

/**
 *
 * @author rodri
 */

import armaganzasoft.models.Machines;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MaquinasRepository extends BaseRepository {
    private PreparedStatement query;
    
    public MaquinasRepository() {
        
    }
    
     public boolean addMaq(Machines machines){
         
        
        try {
            
            query = con.prepareStatement("INSERT INTO machines (name, "
                                        +"code,"
                                        +"material_uso,"
                                        +"estado,"
                                        + "u_medida,"
                                        + "alarma,"
                                        +"atributo)"
                                        + "VALUES(?,?,?,?,?,?,?);"
                                        );
                      
            
            query.setString(1, machines.getName());
            query.setString(2, machines.getCode());
            query.setString(3, machines.getMaterial_uso());
            query.setString(4, machines.getEstado());
            query.setString(5, machines.getU_medida());
            query.setString(6, machines.getAlarma());
            query.setString(7, machines.getAtributo());
            

  
            
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

   public Machines buscarMaquina(String identified){
        String where ="";
        ResultSet rs;
        Machines busqueda = new Machines();
        if(identified != null || identified != ""){
        where = "WHERE code LIKE '"+identified+"' OR name LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM machines "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setName(rs.getString("name"));
                busqueda.setCode(rs.getString("code"));
                busqueda.setMaterial_uso(rs.getString("material_uso"));
                busqueda.setEstado(rs.getString("estado"));
                busqueda.setU_medida(rs.getString("u_medida"));
                busqueda.setAlarma(rs.getString("alarma"));
                busqueda.setAtributo(rs.getString("atributo"));
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
    
    public boolean edit(Machines machines){
        
        try {
            
            query = con.prepareStatement("UPDATE machines SET name=?, "
                                        +"code=?,"
                                        +"material_uso=?,"
                                        +"estado=?,"
                                        + "u_medida=?,"
                                        + "alarma=?,"
                                        +"atributo=?"
                                        + "WHERE id =?" );
                      
            
            query.setString(1, machines.getName());
            query.setString(2, machines.getCode());
            query.setString(3, machines.getMaterial_uso());
            query.setString(4, machines.getEstado());
            query.setString(5, machines.getU_medida());
            query.setString(6, machines.getAlarma());
            query.setString(7, machines.getAtributo());
            query.setInt(8, machines.getId());

  
            
            if( !query.execute() ){
                return true;
            }
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }
            return false;
        }
    
public boolean eliminar(Machines machines){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM machines WHERE   id = "+machines.getId());
            
       
            
            
                               
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
     
    


