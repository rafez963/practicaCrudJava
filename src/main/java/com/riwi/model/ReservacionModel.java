package com.riwi.model;

import com.riwi.entities.Reservacion;
import com.riwi.persistencia.Conexion;
import com.riwi.persistencia.IModel.IReservacionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservacionModel implements IReservacionModel {
    @Override

    public Reservacion create(Reservacion request) {
        Reservacion reservacion = null;
        Connection connection = Conexion.openConnection();

        try{

            String SQLquery = "INSERT INTO Reservacion(id_pasajero, id_vuelo, fecha_reservacion, asiento) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery, PreparedStatement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1,request.getIdPasajero());
            preparedStatement.setInt(2, request.getIdVuelo());
            preparedStatement.setDate(3, request.getFechaReservacion());
            preparedStatement.setString(4, request.getAsiento());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
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
            String SQLquery = "DELETE FROM Reservacion WHERE id_reservacion = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            preparedStatement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Conexion.closeConnection();
    }

    @Override
    public List<Reservacion> readAll(int id) {

        Connection connection = Conexion.openConnection();
        List<Reservacion> reservaciones = new ArrayList<>();

        try {
            String SQLquery =  "SELECT * FROM reservaciones";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Reservacion reservacion = new Reservacion(resultSet.getInt("id"),
                        resultSet.getInt("id_pasajero"),
                        resultSet.getInt("id_vuelo"),
                        resultSet.getDate("fecha_reservacion"),
                        resultSet.getString("asiento"));
                reservaciones.add(reservacion);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return reservaciones;
    }

    @Override
    public List<Reservacion> readByNameModel(String nombre) {
        Connection connection = Conexion.openConnection();
        List<Reservacion> reservaciones =  new ArrayList<>();

        try{
            String SQLquery = "SELECT * FROM Reservacion r JOIN Pasajero p ON p.id WHERE p.nombre =?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Reservacion reservacion = new Reservacion(
                        resultSet.getInt("id_reservacion"),
                        resultSet.getInt("id_pasajero"),
                        resultSet.getInt("id_vuelo"),
                        resultSet.getDate("fecha_reservacion"),
                        resultSet.getString("asiento")
                );

                reservaciones.add(reservacion);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return reservaciones;
    }

    @Override
    public Reservacion update(Reservacion request, int id) {

        Connection connection = Conexion.openConnection();
        try{
            String SQLquery ="UPDATE Reservacion SET id_pasajero = ?, id_vuelo = ?, fecha_reservacion = ?, asiento = ? WHERE id_reservacion = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setInt(1, request.getIdPasajero());
            preparedStatement.setInt(2, request.getIdVuelo());
            preparedStatement.setDate(3,request.getFechaReservacion());
            preparedStatement.setString(4, request.getAsiento());
            preparedStatement.setInt(5,id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1){
                return request;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            Conexion.closeConnection();
        }
        return null;
    }
}
