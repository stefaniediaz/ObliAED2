package uy.edu.ort.aed2.obligatorio;

public class GrafoMatriz {
    private Conexion[][] conexiones; //aristas del grafo

    private Conexion conexion;
    private NodoAeropuerto[] aeropuertos; //vertices

    private Vuelo[][] vuelos;
    private final int maximo; //tope
    private int largo;
    protected  boolean esDirigido;

    public GrafoMatriz(int largoMaximo) {//, boolean esDirigido
        this.maximo = largoMaximo;
        this.conexiones = new Conexion[maximo][maximo]; //largoMaximo
        for (int i = 0; i < maximo; i++) {
            for (int j = 0; j < maximo; j++) {
                this.conexiones[i][j] = new Conexion();
            }
        }
      //  this.esDirigido = esDirigido;
        this.aeropuertos = new NodoAeropuerto[maximo];
        this.largo = 0;

    }

    public Conexion[][] getConexiones() {
        return conexiones;
    }

    public void setConexiones(Conexion[][] conexiones) {
        this.conexiones = conexiones;
    }

    public NodoAeropuerto[] getAeropuertos() {
        return aeropuertos;
    }

    public void setAeropuertos(NodoAeropuerto[] aeropuertos) {
        this.aeropuertos = aeropuertos;
    }


    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    //verificar los retornos porque el test me devuelve error en verificar campos invalidos
    public Retorno registrarAeropuerto(String codigo, String nombre) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoAeropuerto nuevoAeropuerto = new NodoAeropuerto(codigo);
        nuevoAeropuerto.setNombre(nombre);
        nuevoAeropuerto.setCantAeropuertos(largo);

        if (this.aeropuertos[0] != null) {
            for (NodoAeropuerto a : aeropuertos) {
                if (a == null) {
                    break;
                }
                if (a.getCodigo() == nuevoAeropuerto.getCodigo()) {
                    ret.resultado = Retorno.Resultado.ERROR_3;
                    ret.valorString = "Ya existe un aeropuerto con este codigo";
                    return ret;
                }
            }
        }
         if(nuevoAeropuerto.getCantAeropuertos() >= maximo) {
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Se alcanzo la cantidad maxima de aeropuertos";
        }else {
            this.aeropuertos[largo] = nuevoAeropuerto;
            largo++;
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Registrado exitosamente";
        }
        if(nuevoAeropuerto.getCodigo() == null || nuevoAeropuerto.getCodigo() == ""
                || nuevoAeropuerto.getNombre() == null || nuevoAeropuerto.getNombre() == ""){
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "El codigo o nombre estan vacios";

        }
        return ret;
    }

    public Retorno registrarConexion(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, double kilometros) {
        Retorno ret = new Retorno(Retorno.Resultado.OK, 0, "");

        NodoAeropuerto origen = buscarAeropuerto(codigoAeropuertoOrigen) ;
        NodoAeropuerto destino = buscarAeropuerto(codigoAeropuertoDestino);

        int codAeropOrigen = obtenerPos(origen);
        int codAeropDestino = obtenerPos(destino);

        if(kilometros <= 0){
            ret.valorString = "El kilometraje debe ser mayor a 0";
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        else if(origen == null){
            ret.valorString = "No existe el aeropuerto de origen";
            ret.resultado = Retorno.Resultado.ERROR_2;
        }
        else if(destino == null){
            ret.valorString = "No existe el aeropuerto de destino";
            ret.resultado = Retorno.Resultado.ERROR_3;

        }
        else if (this.conexiones[codAeropOrigen][codAeropDestino].isExiste()) {
            ret.resultado = Retorno.Resultado.ERROR_4;
            ret.valorString = "Ya existe una conexion entre el origen y el destino";
        }
        else{

            this.conexiones[codAeropOrigen][codAeropDestino].setExiste(true);
            this.conexiones[codAeropOrigen][codAeropDestino].setKilometros(kilometros);

        }
        return ret;
    }

    //hay que hacer un buscarConexion entre origen y destino


   /* private Conexion buscarConexion(String origen, String destino, double kilometros){
        for(Conexion[] c: conexiones){
            if(c != null && c.getCodigoAeropuertoOrigen().equals(origen) && c.getCodigoAeropuertoDestino().equals(destino)
            && c.getKilometros() == kilometros){
                return c;
            }
        }return null;
    }*/


    public Retorno registrarVuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        NodoAeropuerto origen = buscarAeropuerto(codigoAeropuertoOrigen) ;
        NodoAeropuerto destino = buscarAeropuerto(codigoAeropuertoDestino);

        int codAeropOrigen = obtenerPos(origen);
        int codAeropDestino = obtenerPos(destino);

        if(combustible <= 0 || minutos <= 0 || costoEnDolares <= 0){
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "combustible|minutos|costo en dolares debe ser mayor a 0";
        }
        else if(origen == null || destino == null || codigoDeVuelo == null ){ //falta vacio
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "codigoAeropuertoOrigen|codigoAeropuertoDestino|codigoDeVuelo no puede ser vacio";
        }
        else if(!origen.isExiste() || origen.getCodigo().equals(codigoAeropuertoOrigen)){
            ret.resultado = Retorno.Resultado.ERROR_3;
            ret.valorString = "No existe el aeropuerto de origen";

        }
        else if(!destino.isExiste() || !destino.getCodigo().equals(codigoAeropuertoDestino)){
            ret.resultado = Retorno.Resultado.ERROR_3;
            ret.valorString = "No existe el aeropuerto de destino";
        }
        else if(this.conexiones[codAeropOrigen][codAeropDestino].isExiste()){ //this.conexiones[codAeropOrigen][codAeropDestino].isExiste()
            ret.resultado = Retorno.Resultado.ERROR_5;
            ret.valorString = "No existe una conexion entre origen y destino";
        }else if(buscarVuelo(codigoDeVuelo).equals(true)){
            ret.resultado = Retorno.Resultado.ERROR_6;
            ret.valorString = "Ya existe un vuelo con ese codigo en esa conexion";
        }
        else{
            this.conexiones[codAeropOrigen][codAeropDestino].setExiste(true);
            this.conexiones[codAeropOrigen][codAeropDestino].setCodigoDeVuelo(codigoDeVuelo);
            this.conexiones[codAeropOrigen][codAeropDestino].setCombustible(combustible);
            this.conexiones[codAeropOrigen][codAeropDestino].setMinutos(minutos);
            this.conexiones[codAeropOrigen][codAeropDestino].setCostoEnDolares(costoEnDolares);
        }

        return ret;
    }

    public Retorno actualizarVuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        NodoAeropuerto aeropuertoOrigen = buscarAeropuerto(codigoAeropuertoOrigen);
        NodoAeropuerto aeropuertoDestino = buscarAeropuerto(codigoAeropuertoDestino);

        if(combustible <= 0 || minutos <= 0 || costoEnDolares <= 0){
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "combustible|minutos|costo debe ser mayor a 0";
        }
        else if(codigoAeropuertoOrigen.equals(null) || codigoAeropuertoOrigen.equals("") || codigoAeropuertoDestino.equals(null) ||
            codigoAeropuertoDestino.equals("") || codigoDeVuelo.equals(null) || codigoDeVuelo.equals("")){
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "los codigos no pueden ser valores vacios o nulos";
        }
        else if(aeropuertoOrigen == null){
            ret.resultado = Retorno.Resultado.ERROR_3;
            ret.valorString = "No existe aeropuerto de origen con ese codigo";
        }
        else if(aeropuertoDestino == null){
            ret.resultado = Retorno.Resultado.ERROR_4;
            ret.valorString = "No existe aeropuerto de destino con ese codigo";
        }
        return ret;
        /*else if(conexiones.codigoAeropuertoOrigen != codigoAeropuertoOrigen && conexiones.codigoAeropuertoDestino ! = codigoAeropuertoDestino){
            ret.resultado = Retorno.Resultado.ERROR_5;
            ret.valorString = "No existe conexion entre origen y destino";
        }
        else if(si no existe un vuelo con ese codigo en esa conexion){
            ret.resultado = Retorno.Resultado.ERROR_6;
            ret.valorString = "No existe un vuelo con ese codigo para esa conexion";
        }
        else if (this.vuelos[this.vuelos[aeropuertoOrigen.getCodigo()]][aeropuertoDestino.getCodigo()].isExiste() ||
            this.vuelos[this.vuelos[aeropuertoDestino.getCodigo()]][aeropuertoOrigen.getCodigo()].isExiste()){

            this.vuelos[this.vuelos[aeropuertoDestino.getCodigo()]][aeropuertoOrigen.getCodigo()].setCombustible(combustible);
            this.vuelos[this.vuelos[aeropuertoDestino.getCodigo()]][aeropuertoOrigen.getCodigo()].setMinutos(minutos);
            this.vuelos[this.vuelos[aeropuertoDestino.getCodigo()]][aeropuertoOrigen.getCodigo()].setCostoEnDolares(costoEnDolares);
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Vuelo actualizado con exito";
            else{
                // no existe conexion entre origen y destino
            }*/





        }

    private NodoAeropuerto buscarAeropuerto(String codigo){
        for (NodoAeropuerto a : aeropuertos) {
            if (a != null && a.getCodigo() == codigo) {
                return a;
            }
        }

        return null;
    }

    private boolean isAdyacente(int vOrigen, int vDestino) {
        return this.vuelos[vOrigen][vDestino].isExiste() || this.vuelos[vDestino][vOrigen].isExiste();
    }

    private Conexion[] buscarVuelo(String codigo){
        for (Conexion[] c : conexiones) {
            if (c == null  && c.equals(codigo)) {
                return c;
            }
        }

        return null;
    }

    /*
    public Lista<String> verticesAdyacentes(String vert){
        Lista<String> retorno = new ListaImp();
        return retorno;

    }*/

    private int obtenerPosLibre(){
        //implementar..
        return -1;
    }


    private int obtenerPos(NodoAeropuerto vertice){
        for(int i=0; i<maximo; i++){
            if(aeropuertos[i] != null && aeropuertos[i].equals(vertice))
                return i;
        }
        return -1;
    }
}







