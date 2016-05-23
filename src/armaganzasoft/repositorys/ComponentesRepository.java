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

import armaganzasoft.models.Components;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ComponentesRepository extends BaseRepository {
    private PreparedStatement query;
    
    public ComponentesRepository() {
        
    }
    
     public boolean addMaq(Components machines){
         
        
        try {
            
            query = con.prepareStatement("INSERT INTO components (name, "
                                        +"code,"
                                        +"material_uso,"
                                        +"estado,"
                                        + "u_medida,"
                                        +"atributo,"
                                        + "valor,"
                                        + "atributo1,"
                                        + "valor1,"
                                        + "atributo2,"
                                        + "valor2,"
                                        + "atributo3,"
                                        + "valor3,"
                                        + "atributo4,"
                                        + "valor4)"
                                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);"
                                        );
                      
            
            query.setString(1, machines.getName());
            query.setString(2, machines.getCode());
            query.setString(3, machines.getMaterial_uso());
            query.setString(4, machines.getEstado());
            query.setString(5, machines.getU_medida());
            query.setString(6, machines.getAtributo());
            query.setString(7, machines.getValor());
            query.setString(8, machines.getAtributo1());
            query.setString(9, machines.getValor1());
            query.setString(10, machines.getAtributo2());
            query.setString(11, machines.getValor2());
            query.setString(12, machines.getAtributo3());
            query.setString(13, machines.getValor3());
            query.setString(14, machines.getAtributo4());
            query.setString(15, machines.getValor4());
                        
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

   public Components buscarMaquina(String identified){
        String where ="";
        ResultSet rs;
        Components busqueda = new Components();
        if(identified != null || identified != ""){
        where = "WHERE code LIKE '"+identified+"' OR name LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM components "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setName(rs.getString("name"));
                busqueda.setCode(rs.getString("code"));
                busqueda.setMaterial_uso(rs.getString("material_uso"));
                busqueda.setEstado(rs.getString("estado"));
                busqueda.setU_medida(rs.getString("u_medida"));
                busqueda.setAtributo(rs.getString("atributo"));
                busqueda.setValor(rs.getString("valor"));
                busqueda.setAtributo1(rs.getString("atributo1"));
                busqueda.setValor1(rs.getString("valor1"));
                busqueda.setAtributo2(rs.getString("atributo2"));
                busqueda.setValor2(rs.getString("valor2"));
                busqueda.setAtributo3(rs.getString("atributo3"));
                busqueda.setValor3(rs.getString("valor3"));
                busqueda.setAtributo4(rs.getString("atributo4"));
                busqueda.setValor4(rs.getString("valor4"));
                busqueda.setId(rs.getInt("id"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar una maquina: "+ex);
        }
        return null;
    }
   
    
   
    public boolean edit(Components machines){
        
        try {
            
            query = con.prepareStatement("UPDATE components SET name=?, "
                                        +"code=?,"
                                        +"material_uso=?,"
                                        +"estado=?,"
                                        + "u_medida=?,"
                                        +"atributo=?,"
                                        + "valor=?,"
                                        + "atributo1=?,"
                                        + "valor1=?,"
                                        + "atributo2=?,"
                                        + "valor2=?,"
                                        + "atributo3=?,"
                                        + "valor3=?,"
                                        + "atributo4=?,"
                                        + "valor4=?"
                                        + "WHERE id =?" );
                      
            
            query.setString(1, machines.getName());
            query.setString(2, machines.getCode());
            query.setString(3, machines.getMaterial_uso());
            query.setString(4, machines.getEstado());
            query.setString(5, machines.getU_medida());
            query.setString(6, machines.getAtributo());
            query.setString(7, machines.getValor());
            query.setString(8, machines.getAtributo1());
            query.setString(9, machines.getValor1());
            query.setString(10, machines.getAtributo2());
            query.setString(11, machines.getValor2());
            query.setString(12, machines.getAtributo3());
            query.setString(13, machines.getValor3());
            query.setString(14, machines.getAtributo4());
            query.setString(15, machines.getValor4());
            query.setInt(16, machines.getId());

  
            
            if( !query.execute() ){
                return true;
            }
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex);
        }
            return false;
        }
    
public boolean eliminar(Components machines){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM components WHERE   id = "+machines.getId());
            
       
            
            
                               
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
     
    


