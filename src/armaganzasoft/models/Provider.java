/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.models;
/**
 *
 * @author daniel
 */
public class Provider {
    
/**
 * @author Isaac Daniel
 */
    
    private int     id;
    private String code;
    private String  contact_name;
    private String  company;
    private String  email;
    private String  telephone;
    private String  fax;
    private String  movil_1;
    private String  notes;
    private String active;
   
        
      /**
       * Default Construct 
       */
      public Provider(){
      
      }
  
    public int getId() {
        return id;
    }
    
    public void setId (int id){
        this.id = id;
    }
    
     public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
      
}
  
