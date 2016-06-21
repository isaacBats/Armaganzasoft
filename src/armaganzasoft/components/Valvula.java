package armaganzasoft.components;

  
/**
 *
 * @author Rodrigo
 */

public class Valvula{

   
    private String code;    
    private String name;

    public Valvula(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Valvula() {
    
    }
        
    public String getCode() {
        
        return this.code;
    }
    
    public String getName(){
        
        return this.name;
    }
    
    public void open(){
        System.out.println("Se ha habierto la Valvula");
    }
    
    public void close(){
        System.out.println("Se ha cerrado la Valvula");
    }

    private void finish() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
