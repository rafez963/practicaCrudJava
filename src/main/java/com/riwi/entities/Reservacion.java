package com.riwi.entities;
import java.sql.Date;
public class Reservacion {
    private int id;
    private int idPasajero;
    private int idVuelo;
    private Date fechaReservacion;
    private String asiento;

    public Reservacion() {
    }

    public Reservacion(int id, int idPasajero, int idVuelo, Date fechaReservacion, String asiento) {
        this.id = id;
        this.idPasajero = idPasajero;
        this.idVuelo = idVuelo;
        this.fechaReservacion = fechaReservacion;
        this.asiento = asiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Date getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Reservacion{" +
                "id=" + id +
                ", idPasajero=" + idPasajero +
                ", idVuelo=" + idVuelo +
                ", fechaReservacion=" + fechaReservacion +
                ", asiento='" + asiento + '\'' +
                '}';
    }
}
