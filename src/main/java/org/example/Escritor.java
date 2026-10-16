package org.example;

import java.io.*;

// Proceso hijo recibe un numero y muestra los 10 siguientes 
public class Escritor {
    public static void main(String[] args) {
        try {
            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            String linea = lector.readLine();
            int numero = Integer.parseInt(linea);

            for (int i = 1; i <= 10; i++) {
                System.out.println(numero + i);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}