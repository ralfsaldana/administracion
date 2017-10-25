/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import comun.Conexion;
import bean.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rsaldana
 */
public class PropietarioDAO {
    
    public ArrayList<Propietario> listarPropietarios() throws Exception {
        Connection c = null;
        Statement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new Conexion().getConexion();            
            st = c.createStatement();
            rs = st.executeQuery("select * from propietario;");
            ArrayList<Propietario> items = new ArrayList<Propietario>();
            Propietario pro = null;
            while(rs.next()){
               pro = new Propietario();
               pro.setIdPropietario(rs.getLong("idPropietario"));
               pro.setNombre(rs.getString("nombres"));
               pro.setApellidoPaterno(rs.getString("apellidoPaterno"));
               pro.setApellidoMaterno(rs.getString("apellidoMaterno"));
               pro.setCorreo(rs.getString("correo"));
               pro.setPassword(rs.getString("password"));
               pro.setUsuario(rs.getString("usuario"));
               pro.setTelefono(rs.getString("telefono"));
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
    
     
    public ArrayList<Propietario> filtrarPropietarios(String filtro) throws Exception {
        Connection c = null;
        Statement st =null;    
        ResultSet rs  =null;
        try {            
            c =  new Conexion().getConexion();            
            st = c.createStatement();
            rs = st.executeQuery("select * from propietario where nombres like '"+filtro+"%';");
            ArrayList<Propietario> items = new ArrayList<Propietario>();
            Propietario pro = null;
            while(rs.next()){
               pro = new Propietario();
               pro.setIdPropietario(rs.getLong("idPropietario"));
               pro.setNombre(rs.getString("nombres"));
               pro.setApellidoPaterno(rs.getString("apellidoPaterno"));
               pro.setApellidoMaterno(rs.getString("apellidoMaterno"));
               pro.setCorreo(rs.getString("correo"));
               pro.setPassword(rs.getString("password"));
               pro.setUsuario(rs.getString("usuario"));
               pro.setTelefono(rs.getString("telefono"));
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
    
    
    public void insertarPropietario(Propietario pro) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new Conexion().getConexion();       
            st = c.prepareStatement("insert into propietario(nombres,apellidoPaterno,apellidoMaterno,correo,telefono,usuario,password) values (?,?,?,?,?,?,?);");            
            st.setString(1, pro.getNombre()); 
            st.setString(2, pro.getApellidoPaterno()); 
            st.setString(3, pro.getApellidoMaterno());  
            st.setString(4, pro.getCorreo()); 
            st.setString(5, pro.getTelefono());
            st.setString(6, pro.getUsuario());
            st.setString(7, pro.getPassword());
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
     
    public void actualizarPropietario(Propietario cli) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new Conexion().getConexion();       
            st = c.prepareStatement("update propietario set nombres=?, apellidoPaterno=?, apellidoMaterno=?, correo=?, telefono=?, usuario=?, password=? where idPropietario=?;");            
            st.setString(1, cli.getNombre()); 
            st.setString(2, cli.getApellidoPaterno()); 
            st.setString(3, cli.getApellidoMaterno());  
            st.setString(4, cli.getCorreo()); 
            st.setString(5, cli.getTelefono());
            st.setString(6, cli.getUsuario());
            st.setString(7, cli.getPassword());
            st.setLong(8, cli.getIdPropietario());
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
    
    public void eliminarPropietario(Long idPropietario) throws Exception {
        Connection c = null;
        PreparedStatement st =null;           
        try {           
            c = new Conexion().getConexion();       
            st = c.prepareStatement("delete from propietario where idPropietario=?;");                        
            st.setLong(1, idPropietario);  
            st.executeUpdate();
        } catch (Exception e) {              
            throw new Exception(e.getMessage());
        }finally{
            if(c!=null)c.close();
            if(st!=null)st.close();           
        }                   
    }
    
    public Propietario obtenerPropietarioPorId(Long idPropietario) throws Exception {
        Connection c = null;
        PreparedStatement st =null;    
        ResultSet rs  =null;
        Propietario pro = null;
        try {            
            c =  new Conexion().getConexion();            
            st = c.prepareStatement("select * from propietario where idPropietario = ?;");
            st.setLong(1, idPropietario);
            rs = st.executeQuery();
            if(rs.next()){
               pro = new Propietario();
               pro.setIdPropietario(rs.getLong("idPropietario"));
               pro.setNombre(rs.getString("nombres"));
               pro.setApellidoPaterno(rs.getString("apellidoPaterno"));
               pro.setApellidoMaterno(rs.getString("apellidoMaterno"));
               pro.setCorreo(rs.getString("correo"));
               pro.setPassword(rs.getString("password"));
               pro.setUsuario(rs.getString("usuario"));
               pro.setTelefono(rs.getString("telefono"));
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
    
    public Propietario obtenerPropietarioPorUsuario(String usuario) throws Exception {
        Connection c = null;
        PreparedStatement st =null;    
        ResultSet rs  =null;
        Propietario pro = null;
        try {            
            c =  new Conexion().getConexion();            
            st = c.prepareStatement("select * from propietario where usuario = ?;");
            st.setString(1, usuario);
            rs = st.executeQuery();
            if(rs.next()){
               pro = new Propietario();
               pro.setIdPropietario(rs.getLong("idPropietario"));
               pro.setNombre(rs.getString("nombres"));
               pro.setApellidoPaterno(rs.getString("apellidoPaterno"));
               pro.setApellidoMaterno(rs.getString("apellidoMaterno"));
               pro.setCorreo(rs.getString("correo"));
               pro.setPassword(rs.getString("password"));
               pro.setUsuario(rs.getString("usuario"));
               pro.setTelefono(rs.getString("telefono"));
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
