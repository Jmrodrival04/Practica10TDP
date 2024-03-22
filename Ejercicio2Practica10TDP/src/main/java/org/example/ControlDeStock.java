package org.example;

import java.util.Scanner;

public class ControlDeStock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introducir el ISBN del libro:");
        String ISBN = scanner.nextLine();
        Libro libro = new Libro(ISBN);

        while (true) {
            System.out.println("ISBN " + ISBN + " ¿Acción? (añadir, quitar, consultar, salir)");
            String accion = scanner.nextLine();

            switch (accion) {
                case "añadir":
                    System.out.println("Introducir cantidad a añadir:");
                    int cantidadAñadir = Integer.parseInt(scanner.nextLine());
                    try {
                        libro.añadirStock(cantidadAñadir);
                    } catch (ExcepcionStockDesbordado e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "quitar":
                    System.out.println("Introducir cantidad a quitar:");
                    int cantidadQuitar = Integer.parseInt(scanner.nextLine());
                    try {
                        libro.quitarStock(cantidadQuitar);
                    } catch (ExcepcionStockDesbordado e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "consultar":
                    System.out.println("Stock actual: " + libro.consultarStock());
                    break;
                case "salir":
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Acción no reconocida.");
                    break;
            }
        }
    }
}
