package uy.edu.ort.aed2.obligatorio;

public class NodoPasajero {
    public Pasajero pasajero;
    public NodoPasajero izquierdo;
    public NodoPasajero derecho;

    public NodoPasajero getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPasajero siguiente) {
        this.siguiente = siguiente;
    }

    //esto lo usamos para poder usar el TAD lista
    public NodoPasajero siguiente;

    public NodoPasajero(Pasajero pasajero) {

        this.pasajero = pasajero;
        this.izquierdo = derecho = null;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public NodoPasajero getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoPasajero izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoPasajero getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoPasajero derecho) {
        this.derecho = derecho;
    }

    public void imprimirPasajero(){
        System.out.println(this.getPasajero());
    }

    @Override
    public String toString() {
        if(pasajero != null){
            return pasajero.getCedula() + ";" + pasajero.getNombre() + ";" + pasajero.getTelefono() + ";" + pasajero.getCategoria();
        }else{
            return "";
        }
    }

    public static int cantidad(NodoPasajero raiz){
        if(raiz != null){
            return 1 + cantidad(raiz.izquierdo) + cantidad(raiz.derecho);
        }
        return 0;
    }
}
