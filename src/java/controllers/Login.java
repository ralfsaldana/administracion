/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rsaldana
 */
@ManagedBean(name = "login")
public class Login {
    
    private String usuario;
    private String password;
    
    public void login(){
        try {
            if (getUsuario() != null && getPassword() != null) {
                if (getUsuario().equals("i801") && getPassword().equals("i801")) {
                    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                    HttpSession session = (HttpSession) ec.getSession(true);
                    session.setAttribute("usuario", usuario);
                    session.setAttribute("idPropietario", 1L);
                    ec.redirect(ec.getRequestContextPath() + "/faces/home.xhtml");
                }else{
                    setUsuario(null);
                    setPassword(null);
                    FacesContext.getCurrentInstance().addMessage(null, 
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales Inválidas"));
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cerrarSesion(){
        try {     
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession session = (HttpSession) ec.getSession(false);
            session.invalidate();
            ec.redirect(ec.getRequestContextPath() + "/faces/login.xhtml");            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
