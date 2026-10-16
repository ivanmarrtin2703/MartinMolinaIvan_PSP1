package org.example;

import java.io.*;

// Proceso padre pide un número, lo envía a Escritor que es el hijo

public class Lector {

    public static void main(String[] args) {
        try {
            System.out.print("Introduzca un número: ");
            int numero = ES.leerEntero();

            ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"),
                    "org.example.Escritor");

            Process procesoEscritor = pb.start();

            // Enviamos el número al hijo
            PrintWriter escritor = new PrintWriter(procesoEscritor.getOutputStream(), true);
            escritor.println(numero);
            escritor.close();

            // Leemos y mostramos la salida del hijo
            BufferedReader lector = new BufferedReader(new InputStreamReader(procesoEscritor.getInputStream()));

            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}