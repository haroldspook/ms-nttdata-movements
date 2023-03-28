package com.presentacion.web.expose;

import com.presentacion.products.model.dto.request.MovementsRequest;
import com.presentacion.products.model.dto.response.MovementsResponse;
import com.presentacion.products.service.MovementsService;
import com.presentacion.products.util.Constants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Clase que representa al controllador
 */
@RestController
@RequestMapping(Constants.MAIN_PATH)
@Api(tags = "MICROSERVICIO MOVEMENTS", description = "Microservicio desarrollado para Administrar los Movimientos")
@Slf4j
public class MovementsController {

    /**
     * Inyectamos la clase ProductServiceImpl
     */
    @Autowired
    private MovementsService movementsService;

    /**
     * Método que listará los Product (Product)
     * @return Lista de Product Product
     */
    @GetMapping
    @ApiOperation(value = Constants.GET_ALL_VALUE, notes = Constants.GET_ALL_NOTE)
    public Observable<MovementsResponse> getAllCustomer(){
        log.info("Obtencion de datos ");
        return movementsService.findAll();
    }

    /**
     * Metodo que eliminará todos los Movements (Movements)
     */
    @DeleteMapping
    @ApiOperation(value = Constants.DELETE_VALUE, notes = Constants.DELETE_NOTE)
    public Completable deleteListCustomer(){
        log.info("Eliminar todos los datos");
        return movementsService.delete();
    }

    /**
     * Método que registrará los Movements
     * @param request
     * @return El mismo Movements para ver su inserción
     */
    @PostMapping
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Single<MovementsResponse> saveCustomer(@RequestBody MovementsRequest request){
        log.info("Envio de parametros");
        return movementsService.save(request);
    }

}
