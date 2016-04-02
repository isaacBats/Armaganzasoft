package armaganzasoft.components;
  
/**
 *
 * @author Rodrigo
 */

public class Valvula {  
    private String code;    
    private String name;
    private int status = 0;

    public Valvula(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Valvula() {
    
    }
      
    public void open(){
        
        if( this.status == 0 ){
            
            this.status = 1;
            System.out.println("La valvula "+this.getName()+" se ha abierto");
            
        }
    }
    
    public void close(){
        if( this.status == 1 ){
            this.status = 0;
            System.out.println("Se ha cerrado la valvula "+this.getName());
        }
        
    }
    
    public int getStatus(){
        
        return this.status;
    }
   
    public String getCode() {
        
        return this.code;
    }
    
    public String getName(){
        
        return this.name;
    }

}
    
