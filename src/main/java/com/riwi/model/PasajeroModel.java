package com.riwi.model;

import com.riwi.entities.Pasajero;
import com.riwi.persistencia.Conexion;
import com.riwi.persistencia.IModel.IPasajeroModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroModel implements IPasajeroModel {
    @Override
    public Pasajero create(Pasajero request) {
        Pasajero pasajero = null;
        Connection connection = Conexion.openConnection();

        try{
            String SQLquery = "INSERT INTO Pasajero(nombre, apellido, documento_identidad) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setString(1, request.getNombre());
            preparedStatement.setString(2, request.getApellido());
            preparedStatement.setString(3,request.getDocumentoIdentida());

            int rowsAffeted = preparedStatement.executeUpdate();
            if (rowsAffeted == 1){
                return request;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Conexion.closeConnection();
        return null;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = Conexion.openConnection();

        try{
            String SQLquery = "DELETE FROM Pasajero WHERE id_pasajero = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Conexion.closeConnection();
    }

    @Override
    public List<Pasajero> readByNameModel(String nombre) {
        Connection connection = Conexion.openConnection();
        List<Pasajero> pasajeros = new ArrayList<>();

        try{
            String SQLquery = "SELECT * FROM Pasajero WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setString(1, nombre);

            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next()){
                Pasajero pasajero = new Pasajero(resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("documento_identidad"));
                pasajeros.add(pasajero);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pasajeros;
    }

    @Override
    public Pasajero update(Pasajero request, int id) {
        Connection connection = Conexion.openConnection();

        try {
            String SQLquery = "UPDATE Pasajero SET nombre = ?, apellido = ?, documento_identidad = ? WHERE id_pasajero = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setString(1, request.getNombre());
            preparedStatement.setString(2, request.getApellido());
            preparedStatement.setString(3, request.getDocumentoIdentida());
            preparedStatement.setInt(4, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                return request;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conexion.closeConnection();
        }
        return null;
    }
}
