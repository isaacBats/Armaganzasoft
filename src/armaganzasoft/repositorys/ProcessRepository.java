/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;


import armaganzasoft.models.Process;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class ProcessRepository extends BaseRepository {
    


 private PreparedStatement query;


    public ProcessRepository() {
        
    }
     public boolean addProceso(Process process){
        
        try {
            
            query = con.prepareStatement("INSERT INTO process (producto, "
                                                          + "operacion, "
                                                          + "des_operacion, "
                                                          + "material1, "
                                                          + "valor1,"
                                                          + "tipop1) "
                                                          
                                        + "VALUES(?, ?, ?, ?, ?, ?);"
                                        );
            
           
            query.setString(1, process.getFormula());
            query.setString(2, process.getOperacion());
            query.setString(3, process.getDes_operacion());
            query.setString(4, process.getMaterial1());
            query.setString(5, process.getValor1());
            query.setString(6, process.getTipop1());
                     
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
    
   public Process buscarProceso(String identified){
        String where ="";
        ResultSet rs;
        Process busqueda = new Process();
        if(identified != null || identified != ""){
        where = "WHERE producto LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM process "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                               
                busqueda.setFormula(rs.getString("producto"));
                busqueda.setOperacion(rs.getString("operacion"));
                busqueda.setDes_operacion(rs.getString("des_operacion"));
                busqueda.setMaterial1(rs.getString("material1"));
                busqueda.setValor1(rs.getString("valor1"));
                busqueda.setTipop1(rs.getString("tipop1"));
                busqueda.setId(rs.getInt("id"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Error al consultar la operacion: "+ex);
        }
        return null;
    }
    
    public boolean edit(Process process){
        
        try {
            
            query = con.prepareStatement("UPDATE process SET producto=?, "
                                                          + "operacion=?, "
                                                          + "des_operacion=?, "
                                                          + "material1=?, "
                                                          + "valor1=?,"
                                                          + "tipop1=? "
                                                           + "WHERE id =?"      );
                        
            query.setString(1, process.getFormula());
            query.setString(2, process.getOperacion());
            query.setString(3, process.getDes_operacion());
            query.setString(4, process.getMaterial1());
            query.setString(5, process.getValor1());
            query.setString(6, process.getTipop1());
            query.setInt(7, process.getId());
            
            if( !query.execute() ){
                System.out.println("Se edito la operacion correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar la operacion: "+ ex);
        }
        
        return false;
    }


public boolean eliminar(Process process){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM process WHERE   id = "+process.getId());
             
            
                               
            if( !query.execute() ){
                System.out.println("Se elimino la operacion correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la operacion: "+ ex);
        }
        
        return false;
}
}