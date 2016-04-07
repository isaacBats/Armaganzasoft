/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft;

//import temporal.Valvula;
import armaganzasoft.interfaces.Botones;
import armaganzasoft.interfaces.Bienvenida;
//import armaganzasoft.repositorys.ValvulaRepository;
import armaganzasoft.components.Valvula;
//import armaganzasoft.interfaces.Botones;
import armaganzasoft.repositorys.ValvulaRepository;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author isaac daniel
 */
//prueba comentario
public class ArmaganzaSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
               
        
        Valvula valvulaAgua;
        
        ValvulaRepository vr;                
        vr = new ValvulaRepository();
//        ResultSet rs;
        
        valvulaAgua = new Valvula("V002", "Valvula Dosificador");
        
        vr.all();
        
        
        
//        try {
//            while (rs.next())
//            {
//                System.out.println("codigo = "+rs.getString("name") );
//            }           
//        } catch (SQLException ex) {
//            System.out.println("Error: "+ ex);
//        }
                
//        vr = new ValvulaRepository();
//        vr.addValvula(valvulaAgua);

//        if(valvulaAgua.getStatus() == 0){
//            System.out.println("La valvula "+valvulaAgua.getName()+" se encuentra Cerrada");
//        }        
//        System.out.println("Abriendo valvula "+valvulaAgua.getName());
//        valvulaAgua.open();
        
        Botones p = new Botones();
            p.setValvula(valvulaAgua);
            p.show();

            p.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent evt){
                            System.exit(0);
                    }
            });
        
    }
    
}