package uy.edu.ort.aed2.obligatorio;

public class NodoDoble {
    int dato;
    String datoString;
    NodoDoble siguiente;
    NodoDoble anterior;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public NodoDoble(String dato) {
        this.datoString = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public String getDatoString() {
        return datoString;
    }

    public void setDatoString(String datoString) {
        this.datoString = datoString;
    }
}
