/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

/**
 *
 * @author Rodrigo
 */
import armaganzasoft.interfaces.Receta;
import armaganzasoft.models.Recipe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeRepository extends BaseRepository {
    
     private PreparedStatement query;
    
    public RecipeRepository() {
        
    }
    
     public boolean addRece(Recipe recipe){
        
        try {
            
            query = con.prepareStatement("INSERT INTO receta (code,"
                    + "name,"
                    + "arena,"
                    + "agua,"
                    + "grava,"
                    + "cemento,"
                    + "aditivo,"
                    + "operacion) "
                                        + "VALUES(?,?,?,?,?,?,?,?);"
                                        );
            
            
            query.setString(1, recipe.getCode());
            query.setString(2, recipe.getName());
            query.setString(3, recipe.getArena());            
            query.setString(4, recipe.getAgua());
            query.setString(5, recipe.getGrava());
            query.setString(6, recipe.getCemento());            
            query.setString(7, recipe.getAditivo());
            query.setString(8, recipe.getOperacion());
  
            
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
public Recipe buscarReceta(String identified){
        String where ="";
        ResultSet rs;
        Recipe busqueda = new Recipe ();
        if(identified != null || identified != ""){
        where = "WHERE name LIKE '"+identified+"' OR code LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM receta "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setCode(rs.getString("code"));
                busqueda.setName(rs.getString("name"));
                busqueda.setArena(rs.getString("arena"));
                busqueda.setAgua(rs.getString("agua"));
                busqueda.setGrava(rs.getString("grava"));
                busqueda.setCemento(rs.getString("cemento"));
                busqueda.setAditivo(rs.getString("aditivo"));
                busqueda.setOperacion(rs.getString("operacion"));
                busqueda.setId(rs.getInt("id"));
                
                }   
  return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar una Receta: "+ex);
        }
        return null;
    }

public boolean edit (Recipe recipe) {
      try{
           query = con.prepareStatement("UPDATE receta SET code=?,"
                                                        + "name=?,"
                                                        + "arena=?,"
                                                        + "agua=?,"
                                                        + "grava=?,"
                                                        + "cemento=?,"
                                                        + "aditivo=?,"
                                                        + "operacion=? "
                                                        + "WHERE id=?;"
                                                                                   );
            query.setString(1, recipe.getCode());
            query.setString(2, recipe.getName());
            query.setString(3, recipe.getArena());            
            query.setString(4, recipe.getAgua());
            query.setString(5, recipe.getGrava());
            query.setString(6, recipe.getCemento());            
            query.setString(7, recipe.getAditivo());
            query.setString(8, recipe.getOperacion());
             query.setInt(9, recipe.getId());
            
            if( !query.execute() ){
               System.out.println("Se edito la Receta correctamente");
                return true;
           }
           
           
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar Receta: "+ ex);
        }
        
        return false;
    }

 public boolean eliminar(Recipe recipe){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM receta WHERE   id = "+recipe.getId());
            
       
            
            
                               
            if( !query.execute() ){
                System.out.println("Se elimino la receta correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar receta: "+ ex);
        }
        
        return false;
    }
      }
          
          

                
        