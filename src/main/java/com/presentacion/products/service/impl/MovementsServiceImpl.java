package com.presentacion.products.service.impl;

import com.presentacion.products.model.dto.request.MovementsRequest;
import com.presentacion.products.model.dto.response.MovementsResponse;
import com.presentacion.products.repository.MovementsRepository;
import com.presentacion.products.service.MovementsService;
import com.presentacion.products.util.MovementsBuilder;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Clase que contiene la lógica del cliente respecto al CRUD
 */
@Service
@Slf4j
@AllArgsConstructor
public class MovementsServiceImpl implements MovementsService {

    @Autowired
    private MovementsRepository movementsRepository;

    /***
     * Este método listará todos los Products
     * @return lista de Produts (Produts)
     */
    @Override
    public Observable<MovementsResponse> findAll() {
        log.info("Obtener todos los registros de los movimientos");
       return Observable.fromIterable(movementsRepository.findAll())
                .map(movements -> MovementsBuilder.movementsEntityToMovementsResponse(movements))
                .subscribeOn(Schedulers.io());
    }

    /***
     * Este método listará los Products
     * @return Lista de Products
    **/
    @Override
    public Observable<MovementsResponse> findAllByNumberDocument(Integer numberDocument) {
        log.info("Obtener todos los registros de los movimientos acorde al numero de documento");
        return findAll()
               .filter(movementsResponse -> movementsResponse.getNumberDocument().equals(numberDocument))
               .subscribeOn(Schedulers.io());
    }

    /***
     * Este método listará los Produts
     * @return Produts (Produts)
     **/
    @Override
    public Single<MovementsResponse> save(MovementsRequest request) {
        log.info("Se guardan los parametros enviados");
        return Single.just(movementsRepository.save(MovementsBuilder.movementsRequestToMovementsEntity(request)))
                .map(movements -> MovementsBuilder.movementsEntityToMovementsResponse(movements));
    }

    /***
     * Este método eliminará a los Produts
     **/
    @Override
    public Completable delete() {
        log.info("Se eliminan todos los registros");
        movementsRepository.deleteAll();
        return Completable.complete();
    }
}
