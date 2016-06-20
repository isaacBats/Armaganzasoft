/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;
import armaganzasoft.models.Obasicas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodri
 */
public class BasicasRepository extends BaseRepository{
    private PreparedStatement query;
    
    
    

    public BasicasRepository() {
        
    }
    
    /**
     * Insert a new User in data Base
     
     * @return Boolean   True if I was inserted into the Data Base
     */
    public boolean addOperacion(Obasicas obasicas){
        
        try {
            
            query = con.prepareStatement("INSERT INTO operations (code,"
                                                                + "descripcion) "
                                        + "VALUES(?, ?);"
                                        );
            
            
            query.setString(1, obasicas.getCode());
            query.setString(2, obasicas.getDescripcion());
                        
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
    
   public Obasicas buscarOperacion(String identified){
        String where ="";
        ResultSet rs;
        Obasicas busqueda = new Obasicas();
        if(identified != null || identified != ""){
        where = "WHERE code LIKE '"+identified+"' OR descripcion LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM operations "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setCode(rs.getString("code"));
                busqueda.setDescripcion(rs.getString("descripcion"));
                busqueda.setId(rs.getInt("id"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar la OPB: "+ex);
        }
        return null;
    }
  
    
    public boolean edit(Obasicas obasicas){
        
        try {
            
            query = con.prepareStatement("UPDATE operations SET   code   = ?, "
                                                           + " descripcion   = ?"
                                                           + "WHERE id =?"      );
            query.setString(1, obasicas.getCode());
            query.setString(2, obasicas.getDescripcion());
            query.setInt(3, obasicas.getId());
            
            if( !query.execute() ){
                System.out.println("Se edito la opb correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar la opb: "+ ex);
        }
        
        return false;
    }


public boolean eliminar(Obasicas obasicas){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM operations WHERE   id = "+obasicas.getId());
             
            
                               
            if( !query.execute() ){
                System.out.println("Se elimino la opb correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la opb: "+ ex);
        }
        
        return false;
    }


/*public DefaultTableModel restornarDatos(String sentenciaSQL){

DefaultTableModel modelo= new DefaultTableModel();
{ try {
    ResultSet rsOpb= consultar (sentenciaSQL);
    ResultSetMetaData metadatos=rsOpb.getMetaData();
    int numeroColumnas=metadatos.getColumnCount();
    Object[] etiquetas=new Object [numeroColumnas];
    for (int i=0; i < numeroColumnas; i++){
        etiquetas [i] = metadatos.getColumnLabel(i+1);
        
    }
    modelo.setColumnIdentifiers(etiquetas);
    while (rsOpb.next()){
        Object[] datosFila=new Object [modelo.getColumnCount()];
        
        
        for (int i=0; i < modelo.getColumnCount(); i++){
            datosFila[i]=rs.getObject(i+1);
        }
        modelo.addRow(datosFila);        
         }
    
} catch (Exception e){
    System.out.println(e.getMessage());
}
return modelo;

    
    
    
}*/
      public Obasicas buscarDescripcion(String identified){
        String where ="";
        ResultSet rs;
        Obasicas busqueda = new Obasicas();
        if(identified != null || identified != ""){
        where = "WHERE code LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT descripcion FROM operations "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setDescripcion(rs.getString("descripcion"));
                }             
            
                return busqueda;
//                          
            } catch (SQLException ex) {
            System.out.println("Error al consultar la Descripcion: "+ex);
        }
        return null;
    }
      
 
}



 
    

   
   
    




     
    
   

