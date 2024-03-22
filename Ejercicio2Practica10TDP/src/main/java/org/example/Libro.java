package org.example;

class Libro {
    private String ISBN;
    private int stock;

    public Libro(String ISBN) {
        this.ISBN = ISBN;
        this.stock = 0;
    }

    public void añadirStock(int cantidad) throws ExcepcionStockDesbordado {
        long nuevoStock = (long) this.stock + cantidad;
        if (nuevoStock > Integer.MAX_VALUE || nuevoStock < Integer.MIN_VALUE) {
            throw new ExcepcionStockDesbordado("El stock del libro excede la capacidad de este sistema.");
        }
        this.stock = (int) nuevoStock;
    }

    public void quitarStock(int cantidad) throws ExcepcionStockDesbordado {
        int nuevoStock = this.stock - cantidad;
        if (nuevoStock < 0) {
            throw new ExcepcionStockDesbordado("El stock no puede ser negativo.");
        }
        this.stock = nuevoStock;
    }

    public int consultarStock() {
        return this.stock;
    }
}
