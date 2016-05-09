package armaganzasoft.models;
/**
 *
 * @author ErwinValle
 */
public class Measurement {
    
/**
 * @author ErwinOrlando
 */
    
    private int     id;
    private String  code;
    private String  name;
    private String agua;
    private String arena;
    private String grava;
    private String cemento;
    private String aditivo;
    
   
  
      /**
       * Default Construct 
       */
      public Measurement(){
      
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

    public String getAgua(){
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }
        
       
   public String getArena(){
        return agua;
    }
    public void setArena(String arena) {
        this.arena = arena;
    }
    
    public String getGrava(){
        return grava;
    }
    public void setGrava(String grava) {
        this.grava = grava;
    }
    public String getCemento(){
        return cemento;
    }
    public void setCemento(String cemento) {
        this.cemento = cemento;
    }
     
    public String getAditivo(){
        return aditivo;
    }
    public void setAditivo(String aditivo) {
        this.aditivo = aditivo;
    }
   
}
    

