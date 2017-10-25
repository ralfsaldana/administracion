/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import bean.Ingreso;
import dao.IngresosDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rsaldana
 */
public class IngresosService {
    
    public List<Ingreso> obtenerListaIngresos(Long idPropietario, Long anio){
        List<Ingreso> listaIngresos = new ArrayList<Ingreso>();
        try {            
            List<Ingreso> pagosPropietario = new IngresosDAO().obtenerIngresosPorIdPropietario(idPropietario, anio);
            boolean existe;
            for(long i=1; i<13;i++){
                existe = false;
                for(Ingreso temp  : pagosPropietario){
                    if(temp.getMes().intValue() == i){
                        listaIngresos.add(temp);
                        existe =true;
                        break;
                    }
                }
                if(!existe){
                    Ingreso ingresoVacio = new Ingreso();                    
                    ingresoVacio.setMes(i);
                    ingresoVacio.setMonto(new BigDecimal("0.00"));
                    listaIngresos.add(ingresoVacio);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return listaIngresos;
    }
    
    public void grabarIngreso(Ingreso ing) throws Exception{
        if(ing.getIdIngreso()!=null && ing.getIdIngreso() != 0L){
            new IngresosDAO().actualizarIngreso(ing); 
        }else{
            new IngresosDAO().insertarIngreso(ing); 
        }        
    }
        
    public Ingreso obtenerIngresoPorIdIngreso(Long idIngreso) throws Exception{
        return new IngresosDAO().obtenerIngresoPorIdIngreso(idIngreso);
    }
    
}
