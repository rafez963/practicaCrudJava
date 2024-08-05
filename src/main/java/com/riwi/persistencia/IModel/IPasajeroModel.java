package com.riwi.persistencia.IModel;

import com.riwi.entities.Pasajero;
import com.riwi.persistencia.intefaces.*;

public interface IPasajeroModel extends
        CreateModel<Pasajero>,
        ReadNameModel<Pasajero>,
        UpdateModel<Pasajero>,
        DeleteModel<Integer> {

}

