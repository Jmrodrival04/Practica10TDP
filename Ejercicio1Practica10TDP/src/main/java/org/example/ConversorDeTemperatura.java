package org.example;

import java.util.Scanner;

public class ConversorDeTemperatura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Introduzca la temperatura y la escala de origen (C para Celsius, F para Fahrenheit). Ejemplo: 25 C");
            String entrada = scanner.nextLine();
            String[] partes = entrada.split(" ");

            if (partes.length != 2) {
                throw new IllegalArgumentException("Formato de entrada incorrecto.");
            }

            double temperatura = Double.parseDouble(partes[0]);
            String escala = partes[1].toUpperCase();

            switch (escala) {
                case "C":
                    System.out.println(temperatura + "°C = " + convertirCelsiusAFahrenheit(temperatura) + "°F");
                    break;
                case "F":
                    System.out.println(temperatura + "°F = " + convertirFahrenheitACelsius(temperatura) + "°C");
                    break;
                default:
                    System.out.println("Escala no reconocida. Utilice 'C' para Celsius o 'F' para Fahrenheit.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduzca un número válido para la temperatura.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public static double convertirCelsiusAFahrenheit(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("La temperatura está por debajo del cero absoluto.");
        }
        return celsius * 9 / 5 + 32;
    }

    public static double convertirFahrenheitACelsius(double fahrenheit) {
        if (fahrenheit < -459.67) {
            throw new IllegalArgumentException("La temperatura está por debajo del cero absoluto.");
        }
        return (fahrenheit - 32) * 5 / 9;
    }
}

