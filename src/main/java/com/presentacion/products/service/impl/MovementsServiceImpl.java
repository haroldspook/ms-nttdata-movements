package com.presentacion.products.service.impl;

import com.presentacion.products.documents.Movements;
import com.presentacion.products.repository.MovementsRepository;
import com.presentacion.products.service.MovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que contiene la lógica del cliente respecto al CRUD
 */
@Service
public class MovementsServiceImpl implements MovementsService {

    @Autowired
    private MovementsRepository customerRepository;

    /***
     * Este método listará todos los Products
     * @return lista de Produts (Produts)
     */
    @Override
    public List<Movements> findAll() {
       return customerRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    /***
     * Este método listará los Products
     * @return Lista de Products
    **/
    @Override
    public List<Movements> findAllById(Integer numberDocument) {
       return customerRepository.findAll()
               .stream()
               .collect(Collectors.toList());
    }

    /***
     * Este método listará los Produts
     * @return Produts (Produts)
     **/
    @Override
    public Movements save(Movements produts) {
        return customerRepository.save(produts);
    }

    /***
     * Este método eliminará a los Produts
     **/
    @Override
    public void delete() {
        customerRepository.deleteAll();
    }
}
