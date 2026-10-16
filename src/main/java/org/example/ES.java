package org.example;

import java.util.*;

// Clase para leer datos por teclado
public class ES {

    private static Scanner sc = new Scanner(System.in);

    public static int leerEntero() {
        int numero = sc.nextInt();
        return numero;
    }

    public static String leerString() {
        String texto = sc.nextLine();
        return texto;
    }
}
