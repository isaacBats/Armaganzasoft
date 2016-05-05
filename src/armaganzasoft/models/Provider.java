package armaganzasoft.models;



import armaganzasoft.services.BaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author ErwinValle
 */
public class Provider {
    
/**
 * @author ErwinValle
 */
    
    private int     id;
    private String  contact_name;
    private String  company;
    private String  email;
    private String  telephone;
    private String  fax;
    private String  movil_1;
    private String  notes;
    private boolean active;
   
   private Statement stm;
   private ResultSet rs;
   private Statement stmt;
   
      private String sql;
      private BaseDatos db;
      private Connection conn= null;
      
      /**
       * Default Construct 
       */
      public Provider(){
      
      }
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
   public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMovil_1() {
        return movil_1;
    }

    public void setMovil_1(String movil_1) {
        this.movil_1 = movil_1;
    }
    
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

   
    private boolean conectar() {
        this.db = new BaseDatos();
        this.conn = db.getConnection();
        if(this.conn != null){
            return true;
        }else{
            return false;
        }}

    
      
}
    

