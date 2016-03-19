/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.repositorys;

import armaganzasoft.services.BaseDatos;
import java.sql.Connection;

/**
 *
 * @author Isaac Daniel <@codeisaac>
 */
public class BaseRepository {

    /**
     * To connect to Data Base
     */
    private BaseDatos baseDatos = new BaseDatos();
    
    /**
     * Get connection a data Base
     */
    protected  Connection con = baseDatos.getConnection();
}
