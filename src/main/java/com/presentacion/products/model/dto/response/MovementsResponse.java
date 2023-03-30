package com.presentacion.products.model.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Modelo de la clase que representa a la colección de mongo DB
 */
@Data
@ApiModel("Model MovementsResponse")
@Builder
public class MovementsResponse {

    @ApiModelProperty(value = "id" , position = 1, example = "1")
    private Long id;
    @ApiModelProperty(value = "numberDocument", required = true , position = 2, example = "77777777")
    private Integer numberDocument;
    @ApiModelProperty(value = "typeMovements", required = true , position = 3, example = "Deposito")
    private String typeMovements;
    @ApiModelProperty(value = "amount", required = true , position = 4, example = "100")
    private String amount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "createAt", required = true , position = 5)
    private Date createAt;


}
