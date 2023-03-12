package com.presentacion.products.documents;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Modelo de la clase que representa a la colección de mongo DB
 */
@Data
@Document(collection = "Movements")
public class Movements {

    @Id
    @JsonProperty("id")
    private String id;
    private Integer numberDocument;
    private String typeMovements;
    private String amount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;


}
