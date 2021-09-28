import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UltimoSoldado {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k, contk = 0, n, soldvivo;
        Lista miLista = new Lista();
        Nodo ind1;
        Nodo ind2;
        Nodo cabeza;
        System.out.print("Digite la Cantidad de soldados :");
        n = Integer.parseInt(br.readLine());
        System.out.println();
        System.out.print("Indique cada cuanto va a morir un Soldado : ");
        k = Integer.parseInt(br.readLine());
        System.out.println();
        for (int i = 0; i < n; i++) {
            miLista.insertarFinal(i + 1);
        }

        System.out.println("-----------------------");
        System.out.println("Lista de soldados");
        miLista.Mostrar();

        soldvivo = n;
        cabeza = miLista.cabeza;
        ind1 = cabeza;
        ind2 = cabeza;

        System.out.println("\n -----------------------");
        System.out.println("Eliminando soldados ");

        System.out.println();

        if (k == 1) {
            while (soldvivo > 1) {
                miLista.eliminarCabeza();
                soldvivo--;
            }
        } else {
            while (soldvivo > 1) {
                contk++;
                if (contk == k) {
                    if (ind1 == cabeza) {
                        cabeza = cabeza.siguiente;
                        ind1.siguiente = null;
                        ind1 = cabeza;
                        ind2 = cabeza;
                        contk = 1;

                    } else {
                        while (ind2.siguiente != ind1) {
                            ind2 = ind2.siguiente;
                        }
                        ind2.siguiente = ind1.siguiente;
                        ind1.siguiente = null;
                        ind1 = ind2;
                        contk = 0;
                    }
                    soldvivo--;
                }
                if (soldvivo != 1) {
                    ind1 = ind1.siguiente;
                    if (ind1.siguiente == null) {
                        contk++;
                        if (contk == k) {
                            while (ind2.siguiente != ind1) {
                                ind2 = ind2.siguiente;
                            }
                            ind2.siguiente = null;
                            soldvivo--;
                            contk = 0;
                        }
                        ind1 = cabeza;
                        ind2 = cabeza;
                    }
                }
            }
        }
        System.out.println();
        System.out.print("Soldado Sobreviviente:");
        System.out.print(cabeza.dato);
        System.out.println();
    }
}
