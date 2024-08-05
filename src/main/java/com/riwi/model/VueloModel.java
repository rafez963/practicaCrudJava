package com.riwi.model;

import com.riwi.entities.Vuelo;
import com.riwi.persistencia.Conexion;
import com.riwi.persistencia.IModel.IVueloModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VueloModel implements IVueloModel {

    @Override
    public Vuelo create(Vuelo request) {
        Connection connection = Conexion.openConnection();
        Vuelo vuelo = null;

        try{
            String SQLquery = "INSERT INTO Vuelo(destino,fecha_salida,hora_salida,id_avion) VALUES(?, ?, ? ,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery, PreparedStatement.RETURN_GENERATED_KEYS) ;
            preparedStatement.setString(1, request.getDestino());
            preparedStatement.setDate(2, request.getFechaSalida());
            preparedStatement.setTime(3, request.getHoraSalida());
            preparedStatement.setInt(4, request.getIdAvion());
            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected == 1){
                return request;
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            Conexion.closeConnection();
        }
        return null;
    }

    @Override
    public List<Vuelo> readByDestinoModel(String destino) {

        Connection connection = Conexion.openConnection();
        Vuelo vuelo = null;
        List<Vuelo> vuelos = new ArrayList<>();

        try{
            String SQLquery =  "SELECT * FROM Vuelo WHERE destino = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);

            preparedStatement.setString(1, destino);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                vuelo = new Vuelo(
                        resultSet.getInt("id_vuelo"),
                        resultSet.getString("destino"),
                        resultSet.getDate("fecha_salida"),
                        resultSet.getTime("hora_salida"),
                        resultSet.getInt("id_avion")
                );
                vuelos.add(vuelo);
            }
            preparedStatement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return vuelos;
    }

    @Override
    public Vuelo update(Vuelo request, int id) {
        Connection connection = Conexion.openConnection();

        try{
            String SQLquery = "UPDATE Vuelo SET destino =?, fecha_salida=?, hora_salida =?, id_avion=? WHERE id_vuelo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQLquery);
            preparedStatement.setString(1, request.getDestino());
            preparedStatement.setDate(2, request.getFechaSalida());
            preparedStatement.setTime(3, request.getHoraSalida());
            preparedStatement.setInt(4, request.getIdAvion());
            preparedStatement.setInt(5, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                return request;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            Conexion.closeConnection();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = Conexion.openConnection();

        try{
            String SQLquery = "DELETE FROM Vuelo WHERE id_vuelo=?";
            PreparedStatement preparedStatement =connection.prepareStatement(SQLquery);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            Conexion.closeConnection();
        }
    }

}
