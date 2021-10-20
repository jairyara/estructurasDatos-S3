/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Brayan Oviedo
 */
public class MainArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BuscarArbolBinario<Integer> arbol = new BuscarArbolBinario<>();
        int opcion = 0, elemento = 0;
        /**
         * arbol.add(8);
         *
         * arbol.add(4); arbol.add(arbol.getRoot(), 10);
         * arbol.add(arbol.getRoot(), 12); arbol.add(1);
         *
         * System.out.println(arbol);
         */

        // TODO code application logic here
        do {
            try {
                System.out.println("");
                System.out.println(
                        """
                                1. Generar Arbol Binario
                                2. Recorrido en Inorden
                                3. Recorrido en Preorden
                                4. Recorrido en Postorden
                                5. Recorrido en Inorden, preorden, postorden
                                6. Salir
                                """);
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1 -> {
                        System.out.println("");
                        int raiz = 55;
                        System.out.println("INGRESE EL NUMERO DE NODOS PARA CREAR EL ARBOL : ");
                        int n_nodos = Integer.parseInt(br.readLine());
                        for (int i = 1; i <= n_nodos; i++) {
                            elemento = raiz;
                            elemento = (int) (Math.random() * 100);
                            System.out.print("[" + elemento + "]" + "");
                            arbol.add(elemento);
                        }
                        System.out.println("");
                    }
                    case 2 -> {
                        System.out.println("");
                        arbol.inorden(arbol.getRoot());
                        System.out.println("");
                    }
                    case 3 -> {
                        System.out.println("");
                        System.out.println("");
                        arbol.preorden(arbol.getRoot());
                        System.out.println("");
                    }
                    case 4 -> {
                        System.out.println("");
                        System.out.println("");
                        arbol.postorden(arbol.getRoot());
                        System.out.println("");
                    }
                    case 5 -> {
                        System.out.println("Inorden:");
                        System.out.println("");
                        arbol.inorden(arbol.getRoot());
                        System.out.println("");
                        System.out.println("");
                        System.out.println("preorden:");
                        System.out.println("");
                        arbol.preorden(arbol.getRoot());
                        System.out.println("");
                        System.out.println("");
                        System.out.println("postorden:");
                        System.out.println("");
                        arbol.postorden(arbol.getRoot());
                        System.out.println("");
                        System.out.println("");
                    }
                    case 6 -> System.out.println("Fin del programa");
                    default -> System.out.println("No existe opción");
                }
            } catch (NumberFormatException n) {
                System.out.println("No existe opción" + n.getMessage());
            }
        } while (opcion != 6);

    }

}
