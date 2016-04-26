package armaganzasoft;

import armaganzasoft.interfaces.Login;
import armaganzasoft.models.User;
import armaganzasoft.repositorys.UserRepository;
import java.util.Date;

/**
 * @author isaac daniel
 */
public class ArmaganzaSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
          
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new Login().setVisible(true);
           }
       });
    }
}
