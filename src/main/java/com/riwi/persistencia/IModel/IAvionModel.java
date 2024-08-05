package com.riwi.persistencia.IModel;

import com.riwi.entities.Avion;
import com.riwi.persistencia.intefaces.CreateModel;
import com.riwi.persistencia.intefaces.DeleteModel;

public interface IAvionModel extends
        CreateModel <Avion>,
        DeleteModel<Integer> {
}
