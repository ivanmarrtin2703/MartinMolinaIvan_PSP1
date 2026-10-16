package org.example;

import java.io.*;

// Ejecuta dos comandos en tubería:

public class Tuberia {

    public static void main(String[] args) {
        try {
            // Primer hijo: "DIR"
            Process proceso1 = new ProcessBuilder("CMD", "/C", "DIR").start();
            // Segundo hijo: "FINDSTR" y busca "gradle"
            Process proceso2 = new ProcessBuilder("CMD", "/C", "FINDSTR", "/I", "gradle").start();

            // Tubería salida del proceso 1 hacemos un buffer reader para el proceso 2
            BufferedReader lectorProceso1 = new BufferedReader(
                    new InputStreamReader(proceso1.getInputStream()));
            PrintWriter escritorProceso2 = new PrintWriter(
                    proceso2.getOutputStream(), true);

            String linea;
            while ((linea = lectorProceso1.readLine()) != null) {
                escritorProceso2.println(linea);
            }
            lectorProceso1.close();
            escritorProceso2.close();

            // Mostrar en pantalla la salida del segundo
            BufferedReader lectorProceso2 = new BufferedReader(
                    new InputStreamReader(proceso2.getInputStream()));
            while ((linea = lectorProceso2.readLine()) != null) {
                System.out.println(linea);
            }
            lectorProceso2.close();

            // Esperar fin y mostramos el mensaje de que ha terminado
            proceso1.waitFor();
            proceso2.waitFor();
            System.out.println("Fin de ejecución");

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error...");
        }
    }
}
