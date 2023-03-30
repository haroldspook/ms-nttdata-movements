package com.presentacion.products.util;

import com.presentacion.products.model.dto.request.MovementsRequest;
import com.presentacion.products.model.dto.response.MovementsResponse;
import com.presentacion.products.model.entity.Movements;

public class MovementsBuilder {
    public final static Movements movementsRequestToMovementsEntity (MovementsRequest request){
        return Movements.builder()
                .id(request.getId())
                .numberDocument(request.getNumberDocument())
                .typeMovements(request.getTypeMovements())
                .amount(request.getAmount())
                .createAt(request.getCreateAt())
                .build();
    }

    public static MovementsResponse movementsEntityToMovementsResponse(Movements model){
        return MovementsResponse.builder()
                .id(model.getId())
                .numberDocument(model.getNumberDocument())
                .typeMovements(model.getTypeMovements())
                .amount(model.getAmount())
                .createAt(model.getCreateAt())
                .build();
    }
}
