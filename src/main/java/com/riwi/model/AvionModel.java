package com.riwi.model;

import com.riwi.entities.Avion;
import com.riwi.persistencia.Conexion;
import com.riwi.persistencia.IModel.IAvionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AvionModel implements IAvionModel {
    @Override
    public Avion create(Avion request) {
        Avion avion = null;
        Connection connection = Conexion.openConnection();

        try {
            String SQLquery = "INSERT INTO Avion(modelo, capacidad) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getModelo());
            preparedStatement.setInt(2,request.getCapacidad());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1){
                return request;
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Conexion.closeConnection();
        return null;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = Conexion.openConnection();

        try{
            String SQLquery = "DELETE FROM Avion WHERE id_avion = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexion.closeConnection();

    }
}
