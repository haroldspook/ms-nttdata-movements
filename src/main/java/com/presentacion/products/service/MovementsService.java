package com.presentacion.products.service;


import com.presentacion.products.model.dto.request.MovementsRequest;
import com.presentacion.products.model.dto.response.MovementsResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;


/**
 * Interfaz donde definimos los métodos a implementar
 */
public interface MovementsService {
    Observable<MovementsResponse> findAll();
    Observable<MovementsResponse> findAllByNumberDocument(Integer numberDocument);
    Single<MovementsResponse> save(MovementsRequest request);
    Completable delete();
}
