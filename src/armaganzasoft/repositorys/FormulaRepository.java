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
import armaganzasoft.models.Forms;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FormulaRepository extends BaseRepository {
    private PreparedStatement query;
        
    
    public FormulaRepository() {
        
    }
    
     public boolean addFrm(Forms forms){
        
        try {
            
            query = con.prepareStatement("INSERT INTO forms (code, "
                                        +"name,"
                                        + "material,"
                                        + "descripcion,"
                                        + "valor,"
                                        + "material1,"
                                        + "descripcion1,"
                                        + "valor1,"
                                        + "material2,"
                                        + "descripcion2,"
                                        + "valor2,"
                                        + "material3,"
                                        + "descripcion3,"
                                        + "valor3,"
                                        + "material4,"
                                        + "descripcion4,"
                                        + "valor4,"
                                        + "material5,"
                                        + "descripcion5,"
                                        + "valor5,"
                                        + "material6,"
                                        + "descripcion6,"
                                        + "valor6,"
                                        + "material7,"
                                        + "descripcion7,"
                                        + "valor7,"
                                        + "material8,"
                                        + "descripcion8,"
                                        + "valor8,"
                                        + "material9,"
                                        + "descripcion9,"
                                        + "valor9,"
                                        + "material10,"
                                        + "descripcion10,"
                                        + "valor10,"
                                        + "material11,"
                                        + "descripcion11,"
                                        + "valor11)"
                                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?);");
            
            query.setString(1, forms.getCode());
            query.setString(2, forms.getName());
            query.setString(3, forms.getMaterial_id());
            query.setString(4, forms.getDescripcion());
            query.setString(5, forms.getValor());
            query.setString(6, forms.getMaterial_id1());
            query.setString(7, forms.getDescripcion1());
            query.setString(8, forms.getValor1());
            query.setString(9, forms.getMaterial_id2());
            query.setString(10, forms.getDescripcion2());
            query.setString(11, forms.getValor2());
            query.setString(12, forms.getMaterial_id3());
            query.setString(13, forms.getDescripcion3());
            query.setString(14, forms.getValor3());
            query.setString(15, forms.getMaterial_id4());
            query.setString(16, forms.getDescripcion4());
            query.setString(17, forms.getValor4());
            query.setString(18, forms.getMaterial_id5());
            query.setString(19, forms.getDescripcion5());
            query.setString(20, forms.getValor5());
            query.setString(21, forms.getMaterial_id6());
            query.setString(22, forms.getDescripcion6());
            query.setString(23, forms.getValor6());
            query.setString(24, forms.getMaterial_id7());
            query.setString(25, forms.getDescripcion7());
            query.setString(26, forms.getValor7());
            query.setString(27, forms.getMaterial_id8());
            query.setString(28, forms.getDescripcion8());
            query.setString(29, forms.getValor8());
            query.setString(30, forms.getMaterial_id9());
            query.setString(31, forms.getDescripcion9());
            query.setString(32, forms.getValor9());
            query.setString(33, forms.getMaterial_id10());
            query.setString(34, forms.getDescripcion10());
            query.setString(35, forms.getValor10());
            query.setString(36, forms.getMaterial_id11());
            query.setString(37, forms.getDescripcion11());
            query.setString(38, forms.getValor11());
            
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

   public Forms buscarFormula(String identified){
        String where ="";
        ResultSet rs;
        Forms busqueda = new Forms();
        if(identified != null || identified != ""){
        where = "WHERE code LIKE '"+identified+"' OR name LIKE '"+identified+"';";
        }
            try {
            query = con.prepareStatement("SELECT * FROM forms "+where);
            rs = query.executeQuery();
          
                while(rs.next()){
                
                busqueda.setCode(rs.getString("code"));
                busqueda.setName(rs.getString("name"));
                busqueda.setMaterial_id(rs.getString("material"));
                busqueda.setDescripcion(rs.getString("descripcion"));
                busqueda.setValor(rs.getString("valor"));
                busqueda.setMaterial_id1(rs.getString("material1"));
                busqueda.setDescripcion1(rs.getString("descripcion1"));
                busqueda.setValor1(rs.getString("valor1"));
                busqueda.setMaterial_id2(rs.getString("material2"));
                busqueda.setDescripcion2(rs.getString("descripcion2"));
                busqueda.setValor2(rs.getString("valor2"));
                busqueda.setMaterial_id3(rs.getString("material3"));
                busqueda.setDescripcion3(rs.getString("descripcion3"));
                busqueda.setValor3(rs.getString("valor3"));
                busqueda.setMaterial_id4(rs.getString("material4"));
                busqueda.setDescripcion4(rs.getString("descripcion4"));
                busqueda.setValor4(rs.getString("valor4"));
                busqueda.setMaterial_id5(rs.getString("material5"));
                busqueda.setDescripcion5(rs.getString("descripcion5"));
                busqueda.setValor5(rs.getString("valor5"));
                busqueda.setMaterial_id6(rs.getString("material6"));
                busqueda.setDescripcion6(rs.getString("descripcion6"));
                busqueda.setValor6(rs.getString("valor6"));
                busqueda.setMaterial_id7(rs.getString("material7"));
                busqueda.setDescripcion7(rs.getString("descripcion7"));
                busqueda.setValor7(rs.getString("valor7"));
                busqueda.setMaterial_id8(rs.getString("material8"));
                busqueda.setDescripcion8(rs.getString("descripcion8"));
                busqueda.setValor8(rs.getString("valor8"));
                busqueda.setMaterial_id9(rs.getString("material9"));
                busqueda.setDescripcion9(rs.getString("descripcion9"));
                busqueda.setValor9(rs.getString("valor9"));
                busqueda.setMaterial_id10(rs.getString("material10"));
                busqueda.setDescripcion10(rs.getString("descripcion10"));
                busqueda.setValor10(rs.getString("valor10"));
                busqueda.setMaterial_id11(rs.getString("material11"));
                busqueda.setDescripcion11(rs.getString("descripcion11"));
                busqueda.setValor11(rs.getString("valor11"));
                busqueda.setId(rs.getInt("id"));
                }             
                
                //aqui aun pueden incluir mas campos de la tabla costumers
                return busqueda;
//                  System.out.println(rs.getString("name")+ " y su correo es "+rs.getString("email"));  
            
            } catch (SQLException ex) {
            System.out.println("Erro al consultar Formula: "+ex);
        }
        return null;
    }
    
    public boolean edit(Forms forms){
        
        try {
            
            query = con.prepareStatement("UPDATE forms SET  code =?,"
                                                          + "name =?, "
                                                          + "material =?,"
                                                          + "descripcion=?, "
                                                          + "valor =?, "
                                                          + "material1=?,"
                                                          + "descripcion1=?,"
                                                          + "valor1=?,"
                                                          + "material2=?,"
                                                          + "descripcion2=?,"
                                                          + "valor2=?,"
                                                          + "material3=?,"
                                                          + "descripcion3=?,"
                                                          + "valor3=?,"
                                                          + "material4=?,"
                                                          + "descripcion4=?,"
                                                          + "valor4=?,"
                                                          + "material5=?,"
                                                          + "descripcion5=?,"
                                                          + "valor5=?,"
                                                          + "material6=?,"
                                                          + "descripcion6=?,"
                                                          + "valor6=?,"
                                                          + "material7=?,"
                                                          + "descripcion7=?,"
                                                          + "valor7=?,"
                                                          + "material8=?,"
                                                          + "descripcion8=?,"
                                                          + "valor8=?,"
                                                          + "material9=?,"
                                                          + "descripcion9=?,"
                                                          + "valor9=?,"
                                                          + "material10=?,"
                                                          + "descripcion10=?,"
                                                          + "valor10=?,"
                                                          + "material11=?,"
                                                          + "descripcion11=?,"
                                                          + "valor11=?"
                                                          + "WHERE id=?");
            
          
            query.setString(1, forms.getCode());
            query.setString(2, forms.getName());
            query.setString(3, forms.getMaterial_id());
            query.setString(4, forms.getDescripcion());
            query.setString(5, forms.getValor());
            query.setString(6, forms.getMaterial_id1());
            query.setString(7, forms.getDescripcion1());
            query.setString(8, forms.getValor1());
            query.setString(9, forms.getMaterial_id2());
            query.setString(10, forms.getDescripcion2());
            query.setString(11, forms.getValor2());
            query.setString(12, forms.getMaterial_id3());
            query.setString(13, forms.getDescripcion3());
            query.setString(14, forms.getValor3());
            query.setString(15, forms.getMaterial_id4());
            query.setString(16, forms.getDescripcion4());
            query.setString(17, forms.getValor4());
            query.setString(18, forms.getMaterial_id5());
            query.setString(19, forms.getDescripcion5());
            query.setString(20, forms.getValor5());
            query.setString(21, forms.getMaterial_id6());
            query.setString(22, forms.getDescripcion6());
            query.setString(23, forms.getValor6());
            query.setString(24, forms.getMaterial_id7());
            query.setString(25, forms.getDescripcion7());
            query.setString(26, forms.getValor7());
            query.setString(27, forms.getMaterial_id8());
            query.setString(28, forms.getDescripcion8());
            query.setString(29, forms.getValor8());
            query.setString(30, forms.getMaterial_id9());
            query.setString(31, forms.getDescripcion9());
            query.setString(32, forms.getValor9());
            query.setString(33, forms.getMaterial_id10());
            query.setString(34, forms.getDescripcion10());
            query.setString(35, forms.getValor10());
            query.setString(36, forms.getMaterial_id11());
            query.setString(37, forms.getDescripcion11());
            query.setString(38, forms.getValor11());
            query.setInt(39, forms.getId());
            
            if( !query.execute() ){
                System.out.println("Se edito la formula correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al editar la formula: "+ ex);
        }
        
        return false;
    }


public boolean eliminar(Forms forms){
        
        try {
            
           query = con.prepareStatement("DELETE  FROM forms WHERE   id = "+forms.getId());
            
       
            
            
                               
            if( !query.execute() ){
                System.out.println("Se elimino la formula correctamente");
                return true;
            }
            
            query.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la formula: "+ ex);
        }
        
        return false;
    }

    public ResultSet getAllForms(){
    
        Statement stmt;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM forms";
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery( sql );
            
        } catch (SQLException e) {
            System.out.println("No se ejecuto el query "+ e);
            System.out.println(sql);
        }
        
        return rs;
    }
}
     
