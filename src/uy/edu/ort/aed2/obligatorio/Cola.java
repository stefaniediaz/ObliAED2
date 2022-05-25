package uy.edu.ort.aed2.obligatorio;

public class Cola implements ICola{

    int maximo = Integer.MAX_VALUE;
    int cantelementos;
    NodoCola primero;
    NodoCola ultimo;

    public Cola() {

    }

    public int getCantelementos() {
        return cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    public NodoCola getPrimero() {
        return primero;
    }

    public void setPrimero(NodoCola primero) {
        this.primero = primero;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public void Encolar(NodoCola nodo) {

        if (this.esVacia()) {
            this.setPrimero(nodo);
            this.setUltimo(nodo);
        } else {
            this.getUltimo().setSiguiente(nodo);
            this.setUltimo(nodo);
        }
        cantelementos++;
    }

    @Override
    public NodoCola desencolar() {
        NodoCola p = this.primero;
        if (!this.esVacia()) {
            if (cantelementos == 1) {
                setPrimero(null);
                setUltimo(null);
            }
            else {
                primero = primero.getSiguiente();
            }
            this.cantelementos--;
        }
        return p;
    }

    @Override
    public boolean esVacia() {
        return cantelementos == 0;

    }

    @Override
    public int cantelementos() {
        // cambiars
        return 1;
    }

    @Override
    public Object frente() {
        return this.primero;
    }
    @Override
    public boolean buscar(NodoCola n) {
        NodoCola actual = primero;

        while(actual != null) {
            if(actual.dato == n.dato) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
}
