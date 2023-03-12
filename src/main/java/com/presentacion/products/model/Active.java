package com.presentacion.products.model;

import lombok.Data;

/**
 * Modelo con tipos de cuentas Actios (créditos): personal, empresarial, tarjeta de credito.
 */
@Data
public class Active {
    private boolean personal;
    private boolean entreprise;
    private boolean tc;
}
