import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class App {

    public void crearArray() {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de nodos"));

        Random numeroAleatorio = new Random();
        int[] arrayGenerado = new int[cantidad];
        int[] arrayGenerado2 = new int[cantidad];
        int numero;
        for (int i = 0; i < cantidad; i++) {
            numero = numeroAleatorio.nextInt(100);
            arrayGenerado[i] = numero;
            arrayGenerado2[i] = numero;
            System.out.println(arrayGenerado[i]);
        }


        ArrayList<Integer> sliceArray = new ArrayList<>();

        System.out.println("Lista sin ordenar");
        System.out.println(Arrays.toString(arrayGenerado));
        System.out.println("Lista ordenada");
        Arrays.sort(arrayGenerado);
        System.out.println(Arrays.toString(arrayGenerado));

        int inicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique desde que numero quiere mostrar"));

        for (int k : arrayGenerado) {
            if (k > inicio) {
                sliceArray.add(k);
            }
        }

        if (sliceArray.size() > 0) {
            System.out.println("Mostrar > " + inicio);
            System.out.println(sliceArray);
        } else {
            System.out.println(inicio + " este número no se encuentra en la lista");
        }

        System.out.println("Generando nueva lista");

        Random otrosNumerosAleatorios = new Random();
        int[] nuevoArrayGenerado = new int[cantidad];
        int nuevoNumero;
        for (int i = cantidad - 1; i >= 0; i--) {
            nuevoNumero = otrosNumerosAleatorios.nextInt(100);
            nuevoArrayGenerado[i] = nuevoNumero;
            System.out.println(nuevoArrayGenerado[i]);
        }

        System.out.println("Primer lista");
        System.out.println(Arrays.toString(arrayGenerado2));
        System.out.println("Nueva lista");
        System.out.println(Arrays.toString(nuevoArrayGenerado));

        System.out.println("Lista concatenada");

        int primerArrayLenght = arrayGenerado.length;
        int nuevoArraylenght = nuevoArrayGenerado.length;

        int[] arrayFinalDesordenado = new int[nuevoArraylenght + primerArrayLenght];
        System.arraycopy(nuevoArrayGenerado, 0, arrayFinalDesordenado, 0, nuevoArraylenght);
        System.arraycopy(arrayGenerado2, 0, arrayFinalDesordenado, nuevoArraylenght, primerArrayLenght);
        System.out.println(Arrays.toString(arrayFinalDesordenado));
        Arrays.sort(arrayFinalDesordenado);
        System.out.println("Lista ordenada");
        System.out.println(Arrays.toString(arrayFinalDesordenado));
    }

}
