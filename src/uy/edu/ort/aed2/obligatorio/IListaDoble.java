package uy.edu.ort.aed2.obligatorio;

public interface IListaDoble {
    public boolean esVacia();
    public void agregarFinal(int dato);
    public boolean buscarelemento(int dato);
    public void agregarFinalString(String dato);
    public boolean buscarElementoString(String dato);
}
