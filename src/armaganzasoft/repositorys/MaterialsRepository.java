package armaganzasoft.repositorys;

/**
 *
 * @author ErwinValle
 */


import armaganzasoft.models.Materials;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialsRepository extends BaseRepository {
    private PreparedStatement query;
    
    public MaterialsRepository() {
        
    }
    
     public boolean addMat(Materials materials){
        
        try {
            
            query = con.prepareStatement("INSERT INTO materials (name, "
                                        +"code,"
                                        +"atributo,"
                                        +"tipo,"
                                        + "valor)"
                                        + "VALUES(?,?,?,?,?);"
                                        );
                       
            
            query.setString(1, materials.getName());
            query.setString(2, materials.getCode());
            query.setString(3, materials.getAtributo());
            query.setString(4, materials.getTipo());
            query.setString(5, materials.getValor());
  
            
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

    public Materials buscarMaterial(String identified){
        String where ="";
        ResultSet rs;
        Materials busqueda = new Materials ();
        if(identified != null || identified != ""){
        where = "WHERE name LIKE  '"+identified+"' OR code LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM materials "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setName(rs.getString("name"));
                busqueda.setCode(rs.getString("code"));
                busqueda.setAtributo(rs.getString("atributo"));
                busqueda.setAtributo(rs.getString("tipo"));
                busqueda.setAtributo(rs.getString("valor"));
                busqueda.setId(rs.getInt("id"));
                
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar un Material: "+ex);
        }
        return null;
    }
    
    public boolean edit(Materials materials){
        
        try {
            
            query = con.prepareStatement("UPDATE materials SET     name         = ?, "
                                                           +"    code    = ?, "
                                                           +"    atributo        = ?, "
                                                           +"    tipo        = ?, "
                                                           + "valor=?"
                                                           +" WHERE id = ?");
            
            query.setString(1, materials.getName());
            query.setString(2, materials.getCode());
            query.setString(3, materials.getAtributo());
            query.setString(4, materials.getTipo());
            query.setString(5, materials.getValor());
            query.setInt(6, materials.getId());
            
            if( !query.execute() ){
                System.out.println("Se modifico el material correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar material: "+ ex);
        }
        
        return false;
    }
     public boolean eliminar(Materials materials){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM materials WHERE   id = "+materials.getId());
            
       
            
            
                               
            if( !query.execute() ){
                System.out.println("Se elimino el material correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar material: "+ ex);
        }
        
        return false;
    }
}
