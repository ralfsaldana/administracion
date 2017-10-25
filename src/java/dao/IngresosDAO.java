/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Ingreso;
import comun.Conexion;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rsaldana
 */
public class IngresosDAO {
    
    
     public ArrayList<Ingreso> obtenerIngresosPorIdPropietario(Long idPropietario, Long anio) throws Exception {
        Connection c = null;
        Statement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new Conexion().getConexion();            
            st = c.createStatement();
            rs = st.executeQuery("select idIngreso, idTipoIngreso, monto, fechaPago, voucher, "
                    + " nroOperacion, nroCuenta, idPropietario, mes, anio, nombreArchivoVoucher"
                    + " from ingresos where idPropietario = "+idPropietario+" and anio = "+anio+";");
            ArrayList<Ingreso> items = new ArrayList<Ingreso>();
            Ingreso pro = null;
            while(rs.next()){
               pro = new Ingreso();
               pro.setIdIngreso(rs.getLong("idIngreso"));
               pro.setIdTipoIngreso(rs.getLong("idTipoIngreso"));
               pro.setMonto(rs.getBigDecimal("monto"));               
               pro.setVoucher(rs.getBytes("voucher")); 
               pro.setNroOperacion(rs.getString("nroOperacion"));
               pro.setNroCuenta(rs.getString("nroCuenta"));
               pro.setIdPropietario(rs.getLong("idPropietario"));                      
               pro.setFechaPago(rs.getDate("fechaPago"));
               pro.setAnio(rs.getLong("anio"));
               pro.setMes(rs.getLong("mes"));
               pro.setNombreArchivoVoucher(rs.getString("nombreArchivoVoucher")); 
               items.add(pro);
            }
            return items;
        } catch (Exception e) {     
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(rs!=null)rs.close();
            if(st!=null)st.close();           
        }                   
    }
    
    public void actualizarIngreso(Ingreso ing) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new Conexion().getConexion();       
            st = c.prepareStatement("update ingresos set monto=?, fechaPago=?, voucher=?, nroOperacion=?, "
                    + "nroCuenta=?, idPropietario=?, mes=?, anio=?, nombreArchivoVoucher=? where idIngreso=?;");            
            st.setBigDecimal(1, ing.getMonto());             
            st.setDate(2, new java.sql.Date(ing.getFechaPago().getTime())); 
            InputStream inputStream = new ByteArrayInputStream(ing.getVoucher());            
            st.setBlob(3, inputStream);             
            st.setString(4, ing.getNroOperacion());
            st.setString(5, ing.getNroCuenta());
            st.setLong(6, ing.getIdPropietario());
            st.setLong(7, ing.getMes());
            st.setLong(8, 2017);
            st.setString(9, ing.getNombreArchivoVoucher());
            st.setLong(10, ing.getIdIngreso());
            st.executeUpdate();  
            System.out.println(st.toString());
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    } 
    
    public void insertarIngreso(Ingreso ing) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new Conexion().getConexion();       
            st = c.prepareStatement("insert into ingresos (monto, fechaPago, voucher, nroOperacion, "
                    + "nroCuenta, idPropietario, mes, anio, nombreArchivoVoucher )"
                    + " values (?,?,?,?,?,?,?,?,?);");            
            st.setBigDecimal(1, ing.getMonto());             
            st.setDate(2, new java.sql.Date(new java.util.Date().getTime())); 
            InputStream inputStream = new ByteArrayInputStream(ing.getVoucher());            
            st.setBlob(3, inputStream);             
            st.setString(4, ing.getNroOperacion());
            st.setString(5, ing.getNroCuenta());
            st.setLong(6, ing.getIdPropietario());
            st.setLong(7, ing.getMes());
            st.setLong(8, 2017L);
            st.setString(9, ing.getNombreArchivoVoucher());           
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    } 
     
    
    public Ingreso obtenerIngresoPorIdIngreso(Long idIngreso) throws Exception {
        Connection c = null;
        Statement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new Conexion().getConexion();            
            st = c.createStatement();
            rs = st.executeQuery("select * from ingresos where idIngreso = "+idIngreso+";");            
            Ingreso pro = null;
            while(rs.next()){
               pro = new Ingreso();
               pro.setVoucher(rs.getBytes("voucher"));              
               pro.setIdIngreso(rs.getLong("idIngreso"));
               pro.setIdTipoIngreso(rs.getLong("idTipoIngreso"));
               pro.setMonto(rs.getBigDecimal("monto"));               
               pro.setVoucher(rs.getBytes("voucher")); 
               pro.setNroOperacion(rs.getString("nroOperacion"));
               pro.setNroCuenta(rs.getString("nroCuenta"));
               pro.setIdPropietario(rs.getLong("idPropietario"));                      
               pro.setFechaPago(rs.getDate("fechaPago"));
               pro.setAnio(rs.getLong("anio"));
               pro.setMes(rs.getLong("mes"));
               pro.setNombreArchivoVoucher(rs.getString("nombreArchivoVoucher")); 
            }
            return pro;
        } catch (Exception e) {     
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(rs!=null)rs.close();
            if(st!=null)st.close();           
        }                   
    }
    
     
}
