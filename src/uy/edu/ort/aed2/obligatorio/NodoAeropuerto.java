package uy.edu.ort.aed2.obligatorio;

public class NodoAeropuerto {
    private String codigo;
    private String nombre;

    private int cantAeropuertos;

    private boolean existe;

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public NodoAeropuerto(String codigo) {
        this.codigo = codigo;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //validar que no sean vacios o null
    //validar aeropuerto comparar con otro codigo

    public int getCantAeropuertos() {
        return cantAeropuertos;
    }

    public void setCantAeropuertos(int cantAeropuertos) {
        this.cantAeropuertos = cantAeropuertos;
    }
}
