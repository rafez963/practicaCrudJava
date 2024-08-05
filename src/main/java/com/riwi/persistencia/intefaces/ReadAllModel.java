package com.riwi.persistencia.intefaces;

import java.util.List;

public interface ReadAllModel <Entity>{
    public List<Entity> readAll(int id);
}
