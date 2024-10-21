import urna.Urna;

import java.awt.*;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Por favor, ingrese el número de bolas blancas y negras como argumentos.");
            return;
        }

        // Convertir los argumentos de String a int usando parseInt
        int blancas = Integer.parseInt(args[0]);
        int negras = Integer.parseInt(args[1]);

        Urna urna = new Urna(blancas,negras);

        while (urna.totalBolas() > 1) {
            try {
                // Extraer dos bolas de la urna
                Urna.ColorBola bola1 = urna.extraerBola();
                Urna.ColorBola bola2 = urna.extraerBola();

                // Mostrar las bolas extraídas
                System.out.println("Bolas extraídas: " + bola1 + " y " + bola2);


                // Si ambas son del mismo color, se introduce una bola blanca
                if (bola1 == bola2) {
                    urna.ponerBlanca();
                    System.out.println("Se ha introducido una bola blanca en la urna.");
                }
                // Si son de distinto color, se introduce una bola negra
                else {
                    urna.ponerNegra();
                    System.out.println("Se ha introducido una bola negra en la urna.");
                }
                System.out.println(urna);

            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
        Urna.ColorBola bola = urna.extraerBola();

        // Mostrar las bolas extraídas
        System.out.println("Solo quedaba una bola y es de color " +  bola);

    }

}
