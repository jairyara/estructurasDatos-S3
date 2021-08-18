import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class App {

    public int[] arrayParaMetodos;
    Ordenamiento ordenamiento = new Ordenamiento();


    public void seleccionarOpcion() {
        boolean exit = false;
        while (!exit) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Métodos de ordenamiento\s
                        Seleccione el método de ordenamiento a realizar:\s
                        1. Selección\s
                        2. Inserción\s
                        3. Burbuja\s
                        4. Shellsort\s
                        5. Mergesort\s
                        6. Salir"""));

                if (opcion != 6 && (opcion > 0 && opcion < 7)) {
                    arrayParaMetodos = crearArray(tamanoArray());
                }

                switch (opcion) {
                    case 1 -> {
                        JOptionPane.showMessageDialog(null, """
                                El metódo elegido es Selección y consiste en:\s
                                Repetir los siguientes pasos:\s
                                Se busca el elemento más pequeño del array y se coloca en la primera posición.\s
                                Entre los restantes, se busca el elemento más pequeño y se coloca en la segunda posición.""");
                        ordenamiento.seleccion(arrayParaMetodos);
                    }
                    case 2 -> {
                        JOptionPane.showMessageDialog(null, """
                                El metódo elegido es Inserción y consiste en:\s
                                Recorrer todo el array comenzando desde el segundo elemento hasta el final.\s
                                Para cada elemento, se trata de colocarlo en el lugar correcto entre todos los elementos \s
                                anteriores a él o sea entre los elementos a su izquierda en el array.""");
                        ordenamiento.insercion(arrayParaMetodos);
                    }
                    case 3 -> {
                        JOptionPane.showMessageDialog(null, """
                                El metódo elegido es Burbuja y consiste en:\s
                                Comparar pares de elementos adyacentes en un array y si están desordenanos intercambiarlos\s
                                hasta que estén todos ordenados""");
                        ordenamiento.burbuja(arrayParaMetodos);
                    }
                    case 4 -> {
                        JOptionPane.showMessageDialog(null, """
                                El metódo elegido es Shellsort y consiste en:\s
                                Dividir el arreglo (o la lista de elementos) en intervalos (o bloques) de varios elementos para\s
                                organizarlos después por medio del ordenamiento de inserción directa""");
                        ordenamiento.shellSort(arrayParaMetodos);
                    }
                    case 5 -> {
                        JOptionPane.showMessageDialog(null, """
                                El metódo elegido es Mergesort y :\s
                                Es un algoritmo de ordenación recursivo con un número de comparaciones entre elementos del array mínimo.
                                Su funcionamiento es similar al Quicksort, y está basado en la técnica divide y vencerás.
                                De forma resumida el funcionamiento del método MergeSort es el siguiente:
                                - Si la longitud del array es menor o igual a 1 entonces ya está ordenado.
                                - El array a ordenar se divide en dos mitades de tamaño similar.
                                - Cada mitad se ordena de forma recursiva aplicando el método MergeSort.
                                - A continuación las dos mitades ya ordenadas se mezclan formando una secuencia ordenada.""");
                        JOptionPane.showMessageDialog(null, "Array original: \n" +
                                Arrays.toString(arrayParaMetodos));
                        ordenamiento.sort(arrayParaMetodos, 0, arrayParaMetodos.length - 1);
                        JOptionPane.showMessageDialog(null, "Array ordenado: \n" +
                                Arrays.toString(arrayParaMetodos));
                    }
                    case 6 -> {
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        exit = true;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida, ingrese sólo números");
            }
        }
    }

    public int tamanoArray() {
        int arr = 0;
        boolean tamano = false;
        while (!tamano) {
            arr = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del array (máximo 10)"));
            if (arr > 10) {
                arr = 0;
                JOptionPane.showMessageDialog(null, "Maximo permitido 10 \n" +
                        "Intente de nuevo máximo permitido 10");
            } else {
                tamano = true;
            }
        }
        return arr;
    }

    public int[] crearArray(int cantidad) {
        int maximo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número máximo para los elementos del array"));
        Random numeroAleatorio = new Random();
        int[] arrayGenerado = new int[cantidad];
        int numero;
        for (int i = 0; i < cantidad; i++) {
            numero = numeroAleatorio.nextInt(maximo);
            arrayGenerado[i] = numero;
        }
        return arrayGenerado;
    }

}
