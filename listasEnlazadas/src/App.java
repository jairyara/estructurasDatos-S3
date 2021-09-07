import javax.swing.*;
import java.sql.Array;
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
        for (int i = cantidad - 1; i >= 0; i--) {
            numero = numeroAleatorio.nextInt(cantidad);
            arrayGenerado[i] = numero;
            arrayGenerado2[i] = numero;
            System.out.println(arrayGenerado[i]);
        }

        int inicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique desde que numero quiere mostrar"));

        ArrayList<Integer> sliceArray = new ArrayList<>();
        ArrayList<Integer> exceptions = new ArrayList<>();

        System.out.println("Array sin ordenar");
        System.out.println(Arrays.toString(arrayGenerado));
        System.out.println("Array ordenado");
        Arrays.sort(arrayGenerado);
        System.out.println(Arrays.toString(arrayGenerado));

        for (int j = 0; j < arrayGenerado.length; j++) {
            if (arrayGenerado[j] > inicio) {
                sliceArray.add(arrayGenerado[j]);
            } else {
                exceptions.add(arrayGenerado[j]);
            }
        }

        System.out.println("Mostrar > " + inicio);
        System.out.println(sliceArray);
        System.out.println("Excepciones");
        System.out.println(exceptions);

        int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique numero de nodos"));

        Random otrosNumerosAleatorios = new Random();
        int[] nuevoArrayGenerado = new int[nuevaCantidad];
        int nuevoNumero;
        for (int i = nuevaCantidad - 1; i >= 0; i--) {
            nuevoNumero = otrosNumerosAleatorios.nextInt(nuevaCantidad);
            nuevoArrayGenerado[i] = nuevoNumero;
            System.out.println(nuevoArrayGenerado[i]);
        }

        System.out.println("Primer array");
        System.out.println(Arrays.toString(arrayGenerado2));
        System.out.println("Nuevo arrray");
        System.out.println(Arrays.toString(nuevoArrayGenerado));

        System.out.println("Arrray concatenado");

        int primerArrayLenght = arrayGenerado.length;
        int nuevoArraylenght = nuevoArrayGenerado.length;

        int[] arrayFinalDesordenado = new int[nuevoArraylenght + primerArrayLenght];
        System.arraycopy(nuevoArrayGenerado, 0, arrayFinalDesordenado, 0, nuevoArraylenght);
        System.arraycopy(arrayGenerado2, 0, arrayFinalDesordenado, nuevoArraylenght, primerArrayLenght);
        System.out.println(Arrays.toString(arrayFinalDesordenado));
        Arrays.sort(arrayFinalDesordenado);
        System.out.println("Array ordenado");
        System.out.println(Arrays.toString(arrayFinalDesordenado));
    }

}
