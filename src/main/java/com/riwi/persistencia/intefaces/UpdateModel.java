package com.riwi.persistencia.intefaces;

public interface UpdateModel <Entity>{
    public Entity update(Entity request, int id);
}
