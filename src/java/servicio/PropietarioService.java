/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import bean.Propietario;
import dao.PropietarioDAO;

/**
 *
 * @author rsaldana
 */
public class PropietarioService {
    
     public Propietario obtenerPropietarioPorUsuario(String usuario) throws Exception{
         return new PropietarioDAO().obtenerPropietarioPorUsuario(usuario);
     }
    
    
}
