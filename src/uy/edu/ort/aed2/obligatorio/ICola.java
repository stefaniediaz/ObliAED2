package uy.edu.ort.aed2.obligatorio;

public interface ICola {
    public void Encolar(NodoCola nodo);
    public NodoCola desencolar() ;
    public boolean esVacia();
    public int  cantelementos();
    public Object  frente();
    public boolean buscar(NodoCola n);
}
