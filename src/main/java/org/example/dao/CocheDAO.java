package org.example.dao;

import org.example.model.Coche;

import java.util.List;

public interface CocheDAO {

    void insertar(Coche coche);

    List<Coche> listar();
}