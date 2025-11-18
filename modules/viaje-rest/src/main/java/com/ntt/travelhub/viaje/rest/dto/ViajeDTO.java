package com.ntt.travelhub.viaje.rest.dto;

import java.util.Date;

public class ViajeDTO {
    
    private long viajeId;
    private String origen;
    private String destino;
    private Date fechaSalida;
    private Date fechaLlegada;
    private String empresa;
    private double precio;
    private int asientosDisponibles;

    public ViajeDTO() {
    }

    public long getViajeId() {
        return viajeId;
    }

    public void setViajeId(long viajeId) {
        this.viajeId = viajeId;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }
}
