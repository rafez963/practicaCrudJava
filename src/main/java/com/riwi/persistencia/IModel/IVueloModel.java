package com.riwi.persistencia.IModel;

import com.riwi.entities.Vuelo;
import com.riwi.persistencia.intefaces.CreateModel;
import com.riwi.persistencia.intefaces.DeleteModel;
import com.riwi.persistencia.intefaces.ReadDestinoModel;
import com.riwi.persistencia.intefaces.UpdateModel;

public interface IVueloModel extends
        CreateModel<Vuelo>,
        ReadDestinoModel<Vuelo>,
        UpdateModel<Vuelo>,
        DeleteModel<Integer> {

}

