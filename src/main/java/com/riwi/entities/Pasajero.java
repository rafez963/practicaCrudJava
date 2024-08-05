package com.riwi.entities;

public class Pasajero {
    private int id;
    private String nombre;
    private String apellido;
    private String documentoIdentida;

    public Pasajero() {
    }

    public Pasajero(int id, String nombre, String apellido, String documentoIdentida) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoIdentida = documentoIdentida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumentoIdentida() {
        return documentoIdentida;
    }

    public void setDocumentoIdentida(String documentoIdentida) {
        this.documentoIdentida = documentoIdentida;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DocumentoIdentida='" + documentoIdentida + '\'' +
                '}';
    }
}
