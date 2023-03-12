package com.presentacion.products.repository;

import com.presentacion.products.documents.Movements;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovementsRepository extends MongoRepository<Movements,String> {

}
