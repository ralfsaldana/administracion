/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comun;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rsaldana
 */
public class Conexion {
      
    public Connection getConexion() {
        Connection con = null;
         try {                  
            Class.forName(PropiedadesConexionBD.DRIVER_BD);
            con = DriverManager.getConnection(PropiedadesConexionBD.CADENA_BD, 
                                              PropiedadesConexionBD.USER_BD, 
                                              PropiedadesConexionBD.PASSWORD_BD);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return con;        
    }

}
