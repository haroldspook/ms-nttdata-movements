package com.presentacion.products.service;


import com.presentacion.products.documents.Movements;

import java.util.List;

/**
 * Interfaz donde definimos los métodos a implementar
 */
public interface MovementsService {
    List<Movements> findAll();
    List<Movements> findAllById(Integer numberDocument);
    Movements save(Movements customer);
    void delete();
}
