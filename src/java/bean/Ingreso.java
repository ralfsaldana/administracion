/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author rsaldana
 */
public class Ingreso {
    
    private Long idIngreso;
    private Long idTipoIngreso;
    private BigDecimal monto;
    private Date fechaPago;
    private byte[] voucher;
    private String nroOperacion;
    private String nroCuenta;
    private Long idPropietario;
    private Long mes;
    private Long anio;
    private String nombreArchivoVoucher;

    /**
     * @return the idIngreso
     */
    public Long getIdIngreso() {
        return idIngreso;
    }

    /**
     * @param idIngreso the idIngreso to set
     */
    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    /**
     * @return the idTipoIngreso
     */
    public Long getIdTipoIngreso() {
        return idTipoIngreso;
    }

    /**
     * @param idTipoIngreso the idTipoIngreso to set
     */
    public void setIdTipoIngreso(Long idTipoIngreso) {
        this.idTipoIngreso = idTipoIngreso;
    }

    /**
     * @return the monto
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    /**
     * @return the fechaPago
     */
    public Date getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * @return the voucher
     */
    public byte[] getVoucher() {
        return voucher;
    }

    /**
     * @param voucher the voucher to set
     */
    public void setVoucher(byte[] voucher) {
        this.voucher = voucher;
    }

    /**
     * @return the nroOperacion
     */
    public String getNroOperacion() {
        return nroOperacion;
    }

    /**
     * @param nroOperacion the nroOperacion to set
     */
    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    /**
     * @return the nroCuenta
     */
    public String getNroCuenta() {
        return nroCuenta;
    }

    /**
     * @param nroCuenta the nroCuenta to set
     */
    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    /**
     * @return the idPropietario
     */
    public Long getIdPropietario() {
        return idPropietario;
    }

    /**
     * @param idPropietario the idPropietario to set
     */
    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    /**
     * @return the mes
     */
    public Long getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(Long mes) {
        this.mes = mes;
    }

    /**
     * @return the anio
     */
    public Long getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Long anio) {
        this.anio = anio;
    }

    /**
     * @return the nombreArchivoVoucher
     */
    public String getNombreArchivoVoucher() {
        return nombreArchivoVoucher;
    }

    /**
     * @param nombreArchivoVoucher the nombreArchivoVoucher to set
     */
    public void setNombreArchivoVoucher(String nombreArchivoVoucher) {
        this.nombreArchivoVoucher = nombreArchivoVoucher;
    }
    
    
}
