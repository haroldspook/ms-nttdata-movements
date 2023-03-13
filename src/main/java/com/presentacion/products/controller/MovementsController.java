package com.presentacion.products.controller;

import com.presentacion.products.documents.Movements;
import com.presentacion.products.service.impl.MovementsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que representa al controllador
 */
@RestController
@RequestMapping(path = "api/v1/movements")
public class MovementsController {

    /**
     * Inyectamos la clase ProductServiceImpl
     */
    @Autowired
    private MovementsServiceImpl customerService;

    /**
     * Método que listará los Product (Product)
     * @return Lista de Product Product
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Movements>> getMovements(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    /**
     * Metodo que eliminará todos los Movements (Movements)
     */
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<HttpStatus>deleteListCustomer(){
        customerService.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Método que registrará los Movements
     * @param Movements
     * @return El mismo Movements para ver su inserción
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Movements>saveCustomer(@RequestBody Movements movements){
        return new ResponseEntity<Movements>(customerService.save(movements), HttpStatus.OK);

    }

}
