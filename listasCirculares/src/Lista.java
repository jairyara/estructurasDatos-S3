import javax.swing.JOptionPane;

public class Lista {
    public Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }

    public void insertarFinal(int info) {
        Nodo indice;
        indice = cabeza;
        if (indice == null) {
            cabeza = new Nodo(info);
        } else {
            while (indice.siguiente != null) {
                indice = indice.siguiente;
            }
            indice.siguiente = new Nodo(info);
        }

    }

    public void insertarInicio(int info) { //porque recibe el valor que va dentro del nodo
        Nodo a = new Nodo(info);
        a.siguiente = cabeza;
        cabeza = a;
        a = null;
    }

    public void eliminarCabeza() {
        Nodo aux;
        aux = cabeza;
        cabeza = cabeza.siguiente;
        aux.siguiente = null;
    }

    public void Mostrar() {
        Nodo indice;
        indice = cabeza;
        while (indice != null) {
            System.out.print("\n" + "Soldado " + indice.dato);
            indice = indice.siguiente;
        }
    }

}


