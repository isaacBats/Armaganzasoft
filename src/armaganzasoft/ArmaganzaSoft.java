package armaganzasoft;

import armaganzasoft.interfaces.Login;
import armaganzasoft.models.Branch;
import armaganzasoft.repositorys.BranchRepository;

/**
 * @author isaac daniel
 */
public class ArmaganzaSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
          
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
        
        Branch suc = new Branch();
        
        suc.setId(2);
        suc.setName("Cementera Tlalnepantla");
        suc.setAdress("Colonia San Isidro");
        suc.setCity("México");
        suc.setEmail("cemtlal@gmail.com");
        suc.setTelephone("0938947836");
        suc.setZip_code("87654");
        suc.setRfc("lskjhflidñldksfjñoiej");
        
        
        BranchRepository br = new BranchRepository();
        
        br.edit(suc);
                  
    }
}
