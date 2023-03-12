package com.presentacion.products.documents;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.presentacion.products.model.Active;
import com.presentacion.products.model.Pasive;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Modelo de la clase que representa a la colección de mongo DB
 */
@Data
@Document(collection = "AccountBank")
public class Movements {

    @Id
    @JsonProperty("id")
    private String id;
    private Integer numberDocument;
    private Active active;
    private Pasive pasive;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;


}
