
package armaganzasoft.models;


/**
 *
 * @author ErwinValle
 */
public class Branch {
     private int     id;
    private String  name;
    private String  address;
    private String  telephone;
    private String  city;
    private String  zip_code;
    private String  rfc;
    private String email;
    
    
      

      
      public Branch(){
      
      }     
           public int getid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

     public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
   

      }

