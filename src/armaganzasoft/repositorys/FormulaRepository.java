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
import armaganzasoft.interfaces.Formulas;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FormulaRepository extends BaseRepository {
    private PreparedStatement query;
        
    
    public FormulaRepository() {
        
    }
    
     public boolean addFrm(Forms forms){
        
        try {
            
            query = con.prepareStatement("INSERT INTO forms (code, "
                                        +"name,"
                                        + "receta,"
                                        + "operacion," 
                                        + "material_id,"
                                        + "valor,"
                                        + "taraje,"
                                        +"tolerancia,"
                                        +"velocidad,"
                                        + "habilitado)"
                                        + "VALUES(?,?,?,?,?,?,?,?,?,?);"
                                        );
            
            
            query.setString(1, forms.getCode());
            query.setString(2, forms.getName());
            query.setString(3, forms.getReceta());        
            query.setString(4, forms.getOperacion());
            query.setString(5, forms.getMaterial_id());
            query.setString(6, forms.getValor());
            query.setString(7, forms.getTaraje());
            query.setString(8, forms.getTolerancia());
            query.setString(9, forms.getVelocidad());
            query.setString(10,forms.getHabilitado());
            
            
              
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

    
}
