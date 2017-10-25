/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author rsaldana
 */
@ManagedBean(name = "menu")
@SessionScoped
public class Menu {
    
    
    public void redireccionar(){         
        try {            
            Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();          
            String destino = params.get("destino");
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();      
            if(destino!=null){
                if(destino.equals("profile")){
                     ec.redirect(ec.getRequestContextPath() + "/faces/profile.xhtml");
                }else if(destino.equals("cuotaMensual")){
                    ec.redirect(ec.getRequestContextPath() + "/faces/cuotasMensuales.xhtml");
                }
            }else{
                ec.redirect(ec.getRequestContextPath() + "/faces/home.xhtml");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
