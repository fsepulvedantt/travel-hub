package com.ntt.travelhub.reserva.rest.dto;

import java.util.Date;

public class ReservaDTO {
    
    private long reservaId;
    private String origen;
    private String destino;
    private Date fechaSalida;
    private Date fechaLlegada;
    private String mail;
    private String dni;
    private String nombre;
    private String codigoReserva;
    private long idViajeIda;
    private long idViajeVuelta;
    private String tipoReserva; // "IDA" o "IDA_VUELTA"

    public ReservaDTO() {
    }

    public long getReservaId() {
        return reservaId;
    }

    public void setReservaId(long reservaId) {
        this.reservaId = reservaId;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public long getIdViajeIda() {
        return idViajeIda;
    }

    public void setIdViajeIda(long idViajeIda) {
        this.idViajeIda = idViajeIda;
    }

    public long getIdViajeVuelta() {
        return idViajeVuelta;
    }

    public void setIdViajeVuelta(long idViajeVuelta) {
        this.idViajeVuelta = idViajeVuelta;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }
}
