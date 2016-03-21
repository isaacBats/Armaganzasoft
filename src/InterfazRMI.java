/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author user
 */
public interface InterfazRMI extends Remote{
    
     public String validarUsuario(String login, String password, int indice) throws RemoteException;
    
}
