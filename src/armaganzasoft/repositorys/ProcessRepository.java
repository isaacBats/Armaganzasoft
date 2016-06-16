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
import javax.swing.table.DefaultTableModel;

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
            
            query = con.prepareStatement("INSERT INTO process (producto,"
                                                          + "code, "
                                                          + "consecutivo, "
                                                          + "operacion, "
                                                          + "des_operacion, "
                                                          + "material1, "
                                                          + "valor1,"
                                                          + "tipop1, "
                                                          + "material2, "
                                                          + "valor2, "
                                                          + "tipop2, "
                                                          + "material3,"
                                                          + "valor3, "
                                                          + "tipop3) "
                                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ? ,? ,?, ?, ?, ?, ?);"
                                        );
            
            
            query.setString(1, process.getProducto());
            query.setString(2, process.getCode());
            query.setString(3, process.getConsecutivo());
            query.setString(4, process.getOperacion());
            query.setString(5, process.getDes_operacion());
            query.setString(6, process.getMaterial1());
            query.setString(7, process.getValor1());
            query.setString(8, process.getTipop1());
            query.setString(9, process.getMaterial2());
            query.setString(10, process.getValor2());
            query.setString(11, process.getTipop2());
            query.setString(12, process.getMaterial3());
            query.setString(13, process.getValor3());
            query.setString(14, process.getTipop3());
            
            
            
            
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
        where = "WHERE producto LIKE '"+identified+"' OR code LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM process "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setProducto(rs.getString("producto"));
                busqueda.setCode(rs.getString("code"));
                busqueda.setConsecutivo(rs.getString("consecutivo"));
                busqueda.setOperacion(rs.getString("operacion"));
                busqueda.setDes_operacion(rs.getString("des_operacion"));
                busqueda.setMaterial1(rs.getString("material1"));
                busqueda.setValor1(rs.getString("valor1"));
                busqueda.setTipop1(rs.getString("tipop1"));
                busqueda.setMaterial2(rs.getString("material2"));
                busqueda.setValor2(rs.getString("valor2"));
                busqueda.setTipop2(rs.getString("tipop2"));
                busqueda.setMaterial3(rs.getString("material3"));
                busqueda.setValor3(rs.getString("valor3"));
                busqueda.setTipop3(rs.getString("tipop3"));
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
            
            query = con.prepareStatement("UPDATE process SET  producto=?,"
                                                          + "code=?, "
                                                          + "consecutivo=?, "
                                                          + "operacion=?, "
                                                          + "des_operacion=?, "
                                                          + "material1=?, "
                                                          + "valor1=?,"
                                                          + "tipop1=?, "
                                                          + "material2=?, "
                                                          + "valor2=?, "
                                                          + "tipop2=?, "
                                                          + "material3=?,"
                                                          + "valor3=?, "
                                                          + "tipop3=? "
                                                           + "WHERE id =?"      );
           query.setString(1, process.getProducto());
            query.setString(2, process.getCode());
            query.setString(3, process.getConsecutivo());
            query.setString(4, process.getOperacion());
            query.setString(5, process.getDes_operacion());
            query.setString(6, process.getMaterial1());
            query.setString(7, process.getValor1());
            query.setString(8, process.getTipop1());
            query.setString(9, process.getMaterial2());
            query.setString(10, process.getValor2());
            query.setString(11, process.getTipop2());
            query.setString(12, process.getMaterial3());
            query.setString(13, process.getValor3());
            query.setString(14, process.getTipop3());
            query.setInt(15, process.getId());
            
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

/*public DefaultTableModel restornarDatos(String sentenciaSQL){

DefaultTableModel modelo= new DefaultTableModel();
{ try
}

}*/

}