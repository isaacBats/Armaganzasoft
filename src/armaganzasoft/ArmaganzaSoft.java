/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft;

import armaganzasoft.components.Valvula;
import armaganzasoft.repositorys.ValvulaRepository;


/**
 *
 * @author isaac daniel
 */
public class ArmaganzaSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
               
        
//        Valvula valvulaAgua;
//        Valvula valvulaAditivo;
        Valvula valvulaAditivo2;
        Valvula valvulaAditivo3;
        
        ValvulaRepository vr;        
        
//        valvulaAgua = new Valvula("V002", "Valvula Agua 2");
//        valvulaAditivo = new Valvula("V003", "Valvula Aditivo 1");
        
//        valvulaAditivo2 = new Valvula("V006", "Valvula Aditivo HP");
        valvulaAditivo3 = new Valvula("V009", "Valvula Aditivo nueve");
        
        
        vr = new ValvulaRepository();
        
//        vr.addValvula(valvulaAgua);
//        vr.addValvula(valvulaAditivo);
        
//          vr.addValvula(valvulaAditivo2);
          if(vr.addValvula(valvulaAditivo3) == true){
          
              System.out.println(valvulaAditivo3.getName());
          }
    }
    
}