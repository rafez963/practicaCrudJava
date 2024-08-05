package com.riwi.persistencia.IModel;

import com.riwi.entities.Reservacion;
import com.riwi.persistencia.intefaces.*;

public interface IReservacionModel extends
        CreateModel<Reservacion>,
        ReadNameModel<Reservacion>,
        UpdateModel<Reservacion>,
        ReadAllModel<Reservacion>,
        DeleteModel<Integer> {

}
