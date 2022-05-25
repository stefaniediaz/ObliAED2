package uy.edu.ort.aed2.obligatorio;

public class NodoLista {
    int datoInt;
    NodoLista siguiente;

    public NodoLista(int dato) {
        this.datoInt = dato;
        this.siguiente = null;
    }

    public int getDatoInt() {
        return datoInt;
    }

    public void setDatoInt(int dato) {
        this.datoInt = dato;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}
