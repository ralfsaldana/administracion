/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bean.Propietario;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import servicio.PropietarioService;

/**
 *
 * @author rsaldana
 */
@ManagedBean(name = "profile")
public class Profile {
    
    private Propietario propietario;

    
    public Profile(){
        try {
            System.out.println("profile");
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession session = (HttpSession) ec.getSession(false);
            String usuario = (String) session.getAttribute("usuario");
            System.out.println(usuario);
            propietario = new PropietarioService().obtenerPropietarioPorUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    /**
     * @return the propietario
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
    
}
