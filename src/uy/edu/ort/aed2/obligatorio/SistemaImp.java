package uy.edu.ort.aed2.obligatorio;

import uy.edu.ort.aed2.obligatorio.Retorno.Resultado;

public class SistemaImp implements Sistema {
    GrafoMatriz grafoMatriz;
    ArbolPasajero pasajeros;

    Lista listaPasajeros;

    public Lista getListaPasajeros() {
        return listaPasajeros;
    }

    @Override
    public Retorno inicializarSistema(int maxAeropuertos) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(maxAeropuertos <= 2){
            ret.resultado = Resultado.ERROR_1;
        }else{
            //aca inicializar grafo
            //inicializar arbol de pasajeros
            pasajeros = new ArbolPasajero();
            grafoMatriz = new GrafoMatriz(maxAeropuertos);//true
            listaPasajeros = new Lista();
            ret.valorString = "Inicializado con exito";
            ret.resultado = Resultado.OK;
        }

        return ret;
    }

    @Override
    public Retorno registrarPasajero(String cedula, String nombre, String telefono, Categoria categoria) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Pasajero nuevoPasajero = new Pasajero(cedula, nombre, telefono, categoria);

        //valido si nombre, telefono y categoria son null o vacios
        if(nuevoPasajero.validarDatos() == -1){
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Verifique no dejar ningun campo vacio|todos los datos son obligatorios";
        }//valido formato de cedula
        else if(nuevoPasajero.validar() ==-1){
            ret.valorString = "Formato de cedula NNN.NNN-N no valido";
            ret.resultado = Resultado.ERROR_2;

        }
        else if(pasajeros.buscar(cedula).equals(true)){ //buscarPasajero(cedula).resultado == Resultado.OK
            ret.resultado = Resultado.ERROR_3;
            ret.valorString = "Ya existe un pasajero registrado con esa cedula";
        }
        else{
            pasajeros.insertar(nuevoPasajero);
            ret.resultado = Resultado.OK;
        }

        return ret;
    }

    @Override
    public Retorno buscarPasajero(String cedula) {
     /*   Pasajero p = new Pasajero(cedula,"","",null);
      //  NodoPasajero nodo = new NodoPasajero(p);
        //int contador = 0;


        if(p.validar() == 1 && p.validarDatos() ==1){
            return pasajeros.buscar(cedula);
        }
        else if(p.validar() == 0) {
            return new Retorno(Resultado.ERROR_3);
        }
        else{
            return new Retorno(Resultado.ERROR_1);

        }*/

        Pasajero p = new Pasajero(cedula,"","",null);
        NodoPasajero nodo = new NodoPasajero(p);
        int contador = 0;

        if(p.validar()==-1){ //nodo.getPasajero().validar()==-1
            return new Retorno(Resultado.ERROR_1);
        }
        else if(pasajeros.buscar(cedula).equals(false)){
            return new Retorno(Resultado.ERROR_2) ;
        }
        else{
           // return new Retorno(Resultado.OK) ;
            return pasajeros.buscar(cedula,nodo,contador);

        }


    }

    @Override
    public Retorno listarPasajerosAscendente() {
       Retorno ret = new Retorno(Resultado.OK);
       pasajeros.mostrarInOrder(pasajeros.raiz);

       return ret;
    }



    @Override
    public Retorno listarPasajerosDescendente() {
        Retorno ret = new Retorno(Resultado.OK);
        pasajeros.recorrerInorderInvertido(pasajeros.raiz);
        //inOrder invertido

        return ret;
    }

    @Override
    public Retorno listarPasajerosPorCategoría(Categoria categoria) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        if (pasajeros.obtenerelemento2(categoria)!=null){
            System.out.println("Pasajeros de la categoria " + "<" + categoria + ">");
            pasajeros.obtenerelemento2(categoria).getPasajero().toString();

            System.out.println(pasajeros.obtenerelemento2(categoria).getPasajero().toString());
        }
        return ret;


    }

    @Override
    public Retorno registrarAeropuerto(String codigo, String nombre) {

        if(grafoMatriz !=null)
            return grafoMatriz.registrarAeropuerto(codigo, nombre);
       // return new Retorno();
        return new Retorno(Retorno.Resultado.OK);

    }

    @Override
    public Retorno registrarConexion(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, double kilometros) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(grafoMatriz !=null)
            return grafoMatriz.registrarConexion(codigoAeropuertoOrigen, codigoAeropuertoDestino,kilometros);
        //return new Retorno();
        return ret;
        }

    @Override
    public Retorno registrarVuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(grafoMatriz !=null)
            return grafoMatriz.registrarVuelo(codigoAeropuertoOrigen, codigoAeropuertoDestino,codigoDeVuelo,combustible,minutos, costoEnDolares);
       // return new Retorno();
        return ret;
    }

    @Override
    public Retorno actualizarVuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if(grafoMatriz !=null)
            return grafoMatriz.actualizarVuelo(codigoAeropuertoOrigen, codigoAeropuertoDestino,codigoDeVuelo,combustible,minutos, costoEnDolares);
       // return new Retorno();
        return ret;
    }

    @Override
    public Retorno listadoAeropuertosCantDeEscalas(String codigoAeropuertoDeOrigen, int cantidad) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno viajeCostoMinimoKilometros(String codigoAeropuertoOrigen, String codigoAeropuertoDestino) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno viajeCostoMinimoDolares(String codigoAeropuertoOrigen, String codigoAeropuertoDestino) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno consultaDisponibilidad(int[][] matriz, int cantidad, Clase unaClase) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }




}
