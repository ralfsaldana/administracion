/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bean.Ingreso;
import comun.FechaUtil;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import servicio.IngresosService;

/**
 *
 * @author rsaldana
 */

@ManagedBean(name = "ingresos")
@SessionScoped
public class IngresosController implements Serializable{
    
    private List<Ingreso> listaIngresos = new ArrayList<Ingreso>();
    private Ingreso ingreso = new Ingreso();
    private UploadedFile file;
    private StreamedContent fileDownload;
    private Boolean mostrarContenido = false;
    private String anioSeleccionado;

    public IngresosController(){
          //listarIngresosPorPropietario();
          mostrarContenido = false;
    }
    
    public void listarIngresosPorPropietario(){  
            if(anioSeleccionado!=null){
                ingreso = new Ingreso();
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                HttpSession session = (HttpSession) ec.getSession(false);
                Long idPropietario = (Long) session.getAttribute("idPropietario");
                listaIngresos = new IngresosService().obtenerListaIngresos(idPropietario, new Long(anioSeleccionado));    
                mostrarContenido = true;   
            }                     
    }
    
   public void updateRow() {
       try {          
            Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();   
            Long idIngreso = 0L;
            boolean esEdicion = false;
            if(params.get("idIngreso")!=null){
                esEdicion = true;
                idIngreso = new Long(params.get("idIngreso"));                        
                Ingreso temp = new IngresosService().obtenerIngresoPorIdIngreso(idIngreso);
                if(temp!=null){
                     this.ingreso = temp;                     
                }else{
                    this.ingreso = new Ingreso();
                }    
            }              
            this.ingreso.setIdIngreso(idIngreso);
            this.ingreso.setMes(new Long(params.get("mes"))); 
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession session = (HttpSession) ec.getSession(true);
            this.ingreso.setIdPropietario((Long)session.getAttribute("idPropietario")); 
            
            if(esEdicion){
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('editDialog').show();");
            }else{
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('insertDialog').show();");
            }
           
            
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
   
   public void grabarPago(ActionEvent e){  
       try {
           System.out.println("grabarPago");
           //solamente si se ha adjuntado un nuevo voucher
           if(file!=null){
               ingreso.setVoucher(file.getContents()); 
               ingreso.setNombreArchivoVoucher(file.getFileName()); 
           }
           new IngresosService().grabarIngreso(ingreso);
           listarIngresosPorPropietario();    
           FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "El pago se grabó correctamente");
                                                FacesContext.getCurrentInstance().addMessage(null, msg);                                          
       } catch (Exception ex) {
           FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error y no se completó la operación");
                                                FacesContext.getCurrentInstance().addMessage(null, msg);
           ex.printStackTrace();
       }
   }
   
    public void grabarPago2(){  
       try {
           //solamente si se ha adjuntado un nuevo voucher
           if(file!=null){
               ingreso.setVoucher(file.getContents()); 
               ingreso.setNombreArchivoVoucher(file.getFileName()); 
           }
           new IngresosService().grabarIngreso(ingreso);
           listarIngresosPorPropietario();    
           FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "El pago se grabó correctamente");
                                                FacesContext.getCurrentInstance().addMessage(null, msg);                                          
       } catch (Exception ex) {
           FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error y no se completó la operación");
                                                FacesContext.getCurrentInstance().addMessage(null, msg);
           ex.printStackTrace();
       }
   }
   
   public void descargarArchivo(){
       try {
           Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();               
           Long idIngresoTemp = new Long(params.get("idIngreso"));
           Ingreso ingresoTemp = new IngresosService().obtenerIngresoPorIdIngreso(idIngresoTemp);
           fileDownload = new DefaultStreamedContent(new ByteArrayInputStream(ingresoTemp.getVoucher()), 
                                                    "image/jpg", ingresoTemp.getNombreArchivoVoucher());
           
//           HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//           response.setContentType("application/octet-stream");
//           response.setHeader("Content-Disposition", "attachment;filename="+ingresoTemp.getNombreArchivoVoucher());
//           response.getOutputStream().write(ingresoTemp.getVoucher()); 
//           response.getOutputStream().flush();
//           response.getOutputStream().close();
//           FacesContext.getCurrentInstance().responseComplete();
           
       } catch (Exception e) {
           e.printStackTrace();
       }      
   }
   
    public String obtenerNombreMes(Long nroMes){
       return FechaUtil.obtenerNombreMes(nroMes);
    }
    
    /**
     * @return the listaIngresos
     */
    public List<Ingreso> getListaIngresos() {
        return listaIngresos;
    }

    /**
     * @param listaIngresos the listaIngresos to set
     */
    public void setListaIngresos(List<Ingreso> listaIngresos) {
        this.listaIngresos = listaIngresos;
    }

    /**
     * @return the ingreso
     */
    public Ingreso getIngreso() {
        return ingreso;
    }

    /**
     * @param ingreso the ingreso to set
     */
    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /**
     * @return the fileDownload
     */
    public StreamedContent getFileDownload() {
        return fileDownload;
    }

    /**
     * @param fileDownload the fileDownload to set
     */
    public void setFileDownload(StreamedContent fileDownload) {
        this.fileDownload = fileDownload;
    }

    /**
     * @return the mostrarContenido
     */
    public Boolean getMostrarContenido() {
        return mostrarContenido;
    }

    /**
     * @param mostrarContenido the mostrarContenido to set
     */
    public void setMostrarContenido(Boolean mostrarContenido) {
        this.mostrarContenido = mostrarContenido;
    }

    /**
     * @return the anioSeleccionado
     */
    public String getAnioSeleccionado() {
        return anioSeleccionado;
    }

    /**
     * @param anioSeleccionado the anioSeleccionado to set
     */
    public void setAnioSeleccionado(String anioSeleccionado) {
        this.anioSeleccionado = anioSeleccionado;
    }
    
    
}
