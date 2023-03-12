package com.presentacion.products.model;

import lombok.Data;

/**
 * Modelo con tipos de cuentas pasivos: ahorros, cuentas corrientes, plazos fijos.
 */
@Data
public class Pasive {
    private Boolean saving;
    private Boolean currentAccount;
    private Boolean fixedTerm;
}
