package com.presentacion.products.repository;

import com.presentacion.products.model.entity.Movements;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementsRepository extends MongoRepository<Movements,Long> {

}
