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
                                        + "valor,"
                                        + "atributo1,"
                                        + "valor1,"
                                        + "atributo2,"
                                        + "valor2,"
                                        + "atributo3,"
                                        + "valor3,"
                                        + "atributo4,"
                                        + "valor4)"
                                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);"
                                        );
                       
            
            query.setString(1, materials.getName());
            query.setString(2, materials.getCode());
            query.setString(3, materials.getAtributo());
            query.setString(4, materials.getTipo());
            query.setString(5, materials.getValor());
            query.setString(6, materials.getAtributo1());
            query.setString(7, materials.getValor1());
            query.setString(8, materials.getAtributo2());
            query.setString(9, materials.getValor2());
            query.setString(10, materials.getAtributo3());
            query.setString(11, materials.getValor3());
            query.setString(12, materials.getAtributo4());
            query.setString(13, materials.getValor4());
            
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
                busqueda.setTipo(rs.getString("tipo"));
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
                                                           + "valor=?,"
                                                           + "atributo1=?,"
                                                           + "valor1=?,"
                                                           + "atributo2=?,"
                                                           + "valor2=?,"
                                                           + "atributo3=?,"
                                                           + "valor3=?,"
                                                           + "atributo4=?,"
                                                           + "valor4=?"
                                                           +" WHERE id = ?");
            
            query.setString(1, materials.getName());
            query.setString(2, materials.getCode());
            query.setString(3, materials.getAtributo());
            query.setString(4, materials.getTipo());
            query.setString(5, materials.getValor());
            query.setString(6, materials.getAtributo1());
            query.setString(7, materials.getValor1());
            query.setString(8, materials.getAtributo2());
            query.setString(9, materials.getValor2());
            query.setString(10, materials.getAtributo3());
            query.setString(11, materials.getValor3());
            query.setString(12, materials.getAtributo4());
            query.setString(13, materials.getValor4());
            query.setInt(14, materials.getId());
            
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
     
     public Materials buscarDescripcion(String identified){
        String where ="";
        ResultSet rs;
        Materials busqueda = new Materials();
        if(identified != null || identified != ""){
        where = "WHERE code LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT name FROM materials "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setName(rs.getString("name"));
                }             
            
                return busqueda;
//                          
            } catch (SQLException ex) {
            System.out.println("Erro al consultar la Descripcion: "+ex);
        }
        return null;
    }
}
