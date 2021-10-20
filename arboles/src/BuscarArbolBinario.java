/**
 *
 * @author Brayan Oviedo
 */
public class BuscarArbolBinario<T extends Comparable<T>> {

    private NodoArbolBinario<T> raiz;
    String[] niveles;
    int altura;

    /**
     * Indica si el arbol esta vacio
     *
     * @return true si esta vacio
     */
    public boolean isEmpty() {
        return raiz == null;
    }

    /**
     * Devuelve el nodo raiz
     *
     * @return nodo raiz
     */
    public NodoArbolBinario<T> getRoot() {
        return raiz;
    }

    /**
     * Indica si el nodo pasado es el raiz
     *
     * @param nodo
     * @return true si el nodo es el raiz
     */
    public boolean isRoot(NodoArbolBinario<T> nodo) {
        return raiz == nodo;
    }

    /**
     * Indica si es una hoja el nodo pasado como parametro
     *
     * @param nodo
     * @return true si es una hoja
     */
    public boolean isLeaf(NodoArbolBinario<T> nodo) {
        return nodo.getLeft() == null && nodo.getRight() == null;
    }

    /**
     * Indica si el nodo pasado como parametro tiene nodos hijos
     *
     * @param nodo
     * @return
     */
    public boolean isInternal(NodoArbolBinario<T> nodo) {
        return !isLeaf(nodo);
    }

    /**
     * Añade un nodo de forma recursiva
     *
     * @param origen
     * @param elemento
     * @return nodo añadido
     */
    public NodoArbolBinario<T> add(NodoArbolBinario<T> origen, T elemento) {

        NodoArbolBinario<T> nodo = null;
        //Si el raiz es nulo, lo añade el primero
        if (raiz == null) {
            nodo = new NodoArbolBinario<>(elemento);
            raiz = nodo;
        } else if (origen == null) { //el parametro pasado es invalido
            System.out.println("El origen es nulo");
        } else {

            //Comparamos los elementos
            //Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
            if (origen.getElement().compareTo(elemento) > 0) {

                //Si tiene nodo izquierdo, hago la llamada recursiva
                if (origen.getLeft() != null) {
                    nodo = add(origen.getLeft(), elemento);
                } else {
                    //Creo el nodo
                    nodo = new NodoArbolBinario<>(elemento);
                    //Indico que el padre del nodo creado
                    nodo.setParent(origen);
                    //Indico que el nodo es el nodo izquierdo del origen
                    origen.setLeft(nodo);
                }

            } else { //sino pasa a la derecha

                //Si tiene nodo derecho, hago la llamada recursiva
                if (origen.getRight() != null) {
                    nodo = add(origen.getRight(), elemento);
                } else {
                    //Creo el nodo
                    nodo = new NodoArbolBinario<>(elemento);
                    //Indico que el padre del nodo creado
                    nodo.setParent(origen);
                    //Indico que el nodo es el nodo izquierdo del origen
                    origen.setRight(nodo);
                }

            }

        }

        return nodo;

    }

    /**
     * Añade un nodo de forma iterativa
     *
     * @param elemento
     * @return nodo añadido
     */
    public NodoArbolBinario<T> add(T elemento) {

        NodoArbolBinario<T> nodo = null;
        //Si el raiz es nulo, lo añade el primero
        if (raiz == null) {
            nodo = new NodoArbolBinario<>(elemento);
            raiz = nodo;
        } else {

            //Creo un nodo auxuliar
            NodoArbolBinario<T> aux = raiz;
            boolean insertado = false;
            //No salgo hasta que este insertado
            while (!insertado) {

                //Comparamos los elementos
                //Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
                if (aux.getElement().compareTo(elemento) > 0) {

                    //Si tiene nodo izquierdo, actualizo el aux
                    if (aux.getLeft() != null) {
                        aux = aux.getLeft();
                    } else {
                        //Creo el nodo
                        nodo = new NodoArbolBinario<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setParent(aux);
                        aux.setLeft(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                } else {

                    if (aux.getRight() != null) {
                        aux = aux.getRight();
                    } else {
                        //Creo el nodo
                        nodo = new NodoArbolBinario<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setParent(aux);
                        aux.setRight(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                }

            }

        }

        return nodo;

    }

    /**
     * Recorre los nodos, primero el padre y despues los hijos
     *
     * @param nodo
     */
    public void preorden(NodoArbolBinario<T> nodo) {

        System.out.print("["+(nodo.getElement().toString())+"]");

        if (nodo.getLeft() != null) {
            preorden(nodo.getLeft());
        }

        if (nodo.getRight() != null) {
            preorden(nodo.getRight());
        }

    }

    /**
     * Recorre los nodos, lo recorre de izquierda a derecha
     *
     * @param nodo
     */
    public void inorden(NodoArbolBinario<T> nodo) {

        if (nodo.getLeft() != null) {
            inorden(nodo.getLeft());
        }

        System.out.print("["+(nodo.getElement().toString())+"]");

        if (nodo.getRight() != null) {
            inorden(nodo.getRight());
        }

    }

    /**
     * Recorre los nodos, primero los hijos y luego el padre
     *
     * @param nodo
     */
    public void postorden(NodoArbolBinario<T> nodo) {

        if (nodo.getLeft() != null) {
            postorden(nodo.getLeft());
        }

        if (nodo.getRight() != null) {
            postorden(nodo.getRight());
        }

        System.out.print("["+(nodo.getElement().toString())+"]");

    }
    
    
    public int height(NodoArbolBinario<T> nodo) {

        int height = 0;

        if (isInternal(nodo)) {

            if (nodo.getLeft() != null) {
                height = Math.max(height, height(nodo.getLeft()));
            }

            if (nodo.getRight() != null) {
                height = Math.max(height, height(nodo.getRight()));
            }

            height++;
        }

        return height;

    }
    
    
     public   int retornarAltura() {
        altura = 0;
        retornarAltura(raiz, 1);
        return altura;
    }
     
     private void retornarAltura(NodoArbolBinario<T> nodo, int nivel) {
        if (nodo != null) {
            retornarAltura(nodo.getLeft(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(nodo.getRight(), nivel + 1);
        }
    }
    
    
    public void imprimirnivel() {
        niveles = new String[altura + 1];

        imprimirNivel(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            System.out.println(niveles[i] + " En nivel: " + i);
        }
    }

    private void imprimirNivel(NodoArbolBinario<T> nodo, int nivel2) {
        if (nodo != null) {
            niveles[nivel2] = "["+ nodo.getElement().toString()+ "] " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(nodo.getRight(), nivel2 + 1);
            imprimirNivel(nodo.getLeft(), nivel2 + 1);
        }
    }
    
   

}
