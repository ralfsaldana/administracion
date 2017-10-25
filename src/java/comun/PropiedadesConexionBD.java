/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comun;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author rsaldana
 */
public class PropiedadesConexionBD {
    
       public static String DRIVER_BD = "com.mysql.jdbc.Driver";
       public static String CADENA_BD = "jdbc:mysql://localhost:3306/administracion";
       public static String USER_BD = "root";
       public static String PASSWORD_BD = "mysql";    
    
//    public static String DRIVER_BD = null;
//    public static String CADENA_BD = null;
//    public static String USER_BD = null;
//    public static String PASSWORD_BD = null;
//    private final String SEP_ARCHIVOS = System.getProperty("file.separator");
//    private final String RUTA_PROPERTIES = System.getProperty("user.home")+SEP_ARCHIVOS+"sio"+SEP_ARCHIVOS+"conexion.properties";
//    
//    public PropiedadesConexionBD(){       
//    }
//    
//    public void inicializarPropiedades(){
//        try {           
//            //Properties propiedades = new Properties();            
//            //propiedades.load(new FileInputStream(RUTA_PROPERTIES));
//            
//            DRIVER_BD = propiedades.getProperty("conexion.driver");
//            CADENA_BD = propiedades.getProperty("conexion.cadena");
//            USER_BD = propiedades.getProperty("conexion.user");
//            PASSWORD_BD = propiedades.getProperty("conexion.password");            
//            
//        } catch (Exception e) {
//            e.printStackTrace();            
//        }
//    }
}
