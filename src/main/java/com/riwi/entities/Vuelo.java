package com.riwi.entities;
import java.sql.Time;
import java.sql.Date;

public class Vuelo {
    private int id;
    private String destino;
    private Date fechaSalida;
    private Time horaSalida;
    private int idAvion;

    public Vuelo() {
    }

    public Vuelo(int id, String destino, Date fechaSalida, Time horaSalida, int idAvion) {
        this.id = id;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.idAvion = idAvion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", destino='" + destino + '\'' +
                ", fechaSalida=" + fechaSalida +
                ", horaSalida=" + horaSalida +
                ", idAvion=" + idAvion +
                '}';
    }
}
