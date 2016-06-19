package armaganzasoft.models;
/**
 *
 * @author ErwinValle
 */
public class Customer {
    
/**
 * @author ErwinValle
 */
    
    private int     id;
    private String  identified;
    private String  name;
    private String  last_name;
    private String  email;
    private String  telephone;
    private String  movil;
    private String  rfc;
    private String  address;
    private String  city;
    private String  zip_code;
    private String sub_customer;
    private String  customer_id;
   
   
      /**
       * Default Construct 
       */
     public Customer(){
      
      }

   

  //ingreso datos  
    public int getId() {
        return id;
    }
   
     public void setId(int id) {
        this.id = id;
    }

    public String getIdentified() {
        return identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified;
    }
  
    
  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
     public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
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

    public String getSub_customer() {
        return sub_customer;
    }

    public void setSub_customer(String sub_customer) {
        this.sub_customer = sub_customer;
    }
   
    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
   
}
