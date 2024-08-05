package com.riwi.controller;

import com.riwi.model.AvionModel;
import com.riwi.entities.Avion;
import javax.swing.*;

public class AvionController {
    AvionModel avionModel;

    public AvionController(){
        this.avionModel = new AvionModel();
    }

    public void create(){
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del avion: ");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad del avion: "));

        Avion avion;
        avion = new Avion(0,modelo, capacidad);
        System.out.println("Creacion");
    }

    public void delete(){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese le id del avion que desea eliminar: "));
        avionModel.delete(id);
    }
}
