package uy.edu.ort.aed2.obligatorio;

public class ListaDoble implements IListaDoble{
    NodoDoble inicio;
    NodoDoble ultimo;
    int cantidad;

    public ListaDoble() {
        this.inicio = null;
        this.ultimo = null;
        this.cantidad = 0;
    }

    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoDoble ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean esVacia() {
        return this.getCantidad() == 0;
    }
    @Override
    public void agregarFinalString(String dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (this.esVacia()) {
            this.setInicio(nuevo);
            this.setUltimo(nuevo);
        } else {
            nuevo.setAnterior(this.getUltimo());
            this.ultimo.setSiguiente(nuevo);
            this.getUltimo().setSiguiente(nuevo);
            this.setUltimo(nuevo);
        }

        this.cantidad = this.cantidad + 1;
    }

    @Override
    public void agregarFinal(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (this.esVacia()) {
            this.setInicio(nuevo);
            this.setUltimo(nuevo);
        } else {
            nuevo.setAnterior(this.getUltimo());
            this.ultimo.setSiguiente(nuevo);
            this.getUltimo().setSiguiente(nuevo);
            this.setUltimo(nuevo);
        }

        this.cantidad = this.cantidad + 1;
    }

    @Override
    public boolean buscarelemento(int dato) {

        NodoDoble aux = this.getInicio();
        boolean resultado = false;

        while (aux != null && aux.getDato() != dato) {
            aux = aux.getSiguiente();
        }
        if (aux != null && aux.getDato() == dato) {
            resultado = true;

        }
        return resultado;
    }

    @Override
    public boolean buscarElementoString(String dato) {

        NodoDoble aux = this.getInicio();
        boolean resultado = false;

        while (aux != null && !aux.getDatoString().equals(dato)) {
            aux = aux.getSiguiente();
        }
        if (aux != null && aux.getDatoString().equals(dato)) {
            resultado = true;

        }
        return resultado;
    }


}
