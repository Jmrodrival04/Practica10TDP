package org.example;

class ExcepcionStockDesbordado extends Exception {
    public ExcepcionStockDesbordado(String mensaje) {
        super(mensaje);
    }
}