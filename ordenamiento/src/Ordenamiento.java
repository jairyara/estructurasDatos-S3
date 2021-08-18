import javax.swing.*;
import java.util.Arrays;

public class Ordenamiento {

    public void seleccion(int[] matrix) {
        JOptionPane.showMessageDialog(null, "Array inicial \n" +
                Arrays.toString(matrix));
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i] > matrix[j]) {
                    // ...intercambiarlos, es decir, mover el actual a la derecha y el de la derecha al actual
                    int temporal = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = temporal;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Array ordenado \n" +
                Arrays.toString(matrix));
    }

    public void insercion(int[] matrix) {
        JOptionPane.showMessageDialog(null, "Array inicial \n" +
                Arrays.toString(matrix));
        for (int i = 1; i < matrix.length; i++) {
            int aux = matrix[i];
            int j;
            for (j = i - 1; j >= 0 && matrix[j] > aux; j--) {
                matrix[j + 1] = matrix[j];
            }
            matrix[j + 1] = aux;
        }
        JOptionPane.showMessageDialog(null, "Array ordenado \n" +
                Arrays.toString(matrix));
    }

    public void burbuja(int[] matrix) {
        JOptionPane.showMessageDialog(null, "Array inicial \n" +
                Arrays.toString(matrix));
        int temp;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[j] > matrix[j + 1]) {
                    temp = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = temp;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Array ordenado \n" +
                Arrays.toString(matrix));
    }

    public void shellSort(int[] matrix) {
        JOptionPane.showMessageDialog(null, "Array inicial \n" +
                Arrays.toString(matrix));
        for (int increment = matrix.length / 2; increment > 0;
             increment = (increment == 2 ? 1 : (int) Math.round(increment / 2.2))) {
            for (int i = increment; i < matrix.length; i++) {
                for (int j = i; j >= increment && matrix[j - increment] > matrix[j]; j -= increment) {
                    int temp = matrix[j];
                    matrix[j] = matrix[j - increment];
                    matrix[j - increment] = temp;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Array ordenado \n" +
                Arrays.toString(matrix));
    }

    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva).
            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            //Une las mitades.
            merge(arr, left, middle, right);
        }
    }

    public void merge(int[] arr, int left, int middle, int right) {
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        //Vectores temporales.
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        //Copia los datos a los arrays temporales.
        System.arraycopy(arr, left, leftArray, 0, n1);
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }
        /* Une los vectorestemporales. */

        //Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

        //Índice inicial del sub-vector arr[].
        int k = left;

        //Ordenamiento.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }//Fin del while.

        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de leftArray[].
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        //Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
