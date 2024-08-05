package com.riwi.persistencia.intefaces;

import java.util.List;

public interface ReadNameModel <Entity>{
    public List<Entity> readByNameModel(String nombre);
}
