package com.riwi.persistencia.intefaces;

import java.util.List;

public interface ReadDestinoModel <Entity>{
    public List<Entity> readByDestinoModel(String destino);
}
