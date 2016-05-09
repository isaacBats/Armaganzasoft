package armaganzasoft.models;
/**
 *
 * @author ErwinValle
 */
public class Operation {
    
/**
 * @author ErwinOrlando
 */
    
    private int     id;
    private String  code;
    private String  name;
    
      
      /**
       * Default Construct 
       */
      public Operation(){
      
      }
    
    
    public int getId() {
        return id;
    }
    
   public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        
}
    

