package uy.edu.ort.aed2.obligatorio;

public class Conexion {
    private String codigoAeropuertoOrigen;
    private String codigoAeropuertoDestino;
    private double kilometros; //seria el peso

    //atributos de la clase vuelo

    private String codigoDeVuelo;

    private double combustible;

    private double minutos;

    private double costoEnDolares;

    private boolean existe;

    public String getCodigoAeropuertoOrigen() {
        return codigoAeropuertoOrigen;
    }

    public void setCodigoAeropuertoOrigen(String codigoAeropuertoOrigen) {
        this.codigoAeropuertoOrigen = codigoAeropuertoOrigen;
    }

    public String getCodigoAeropuertoDestino() {
        return codigoAeropuertoDestino;
    }

    public void setCodigoAeropuertoDestino(String codigoAeropuertoDestino) {
        this.codigoAeropuertoDestino = codigoAeropuertoDestino;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public String getCodigoDeVuelo() {
        return codigoDeVuelo;
    }

    public void setCodigoDeVuelo(String codigoDeVuelo) {
        this.codigoDeVuelo = codigoDeVuelo;
    }

    public double getCombustible() {
        return combustible;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

    public double getMinutos() {
        return minutos;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public double getCostoEnDolares() {
        return costoEnDolares;
    }

    public void setCostoEnDolares(double costoEnDolares) {
        this.costoEnDolares = costoEnDolares;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
}


