package uy.edu.ort.aed2.obligatorio;



public class ArbolPasajero {
    public NodoPasajero raiz;

    public Lista listaPasajeros;
   // public String datosPasajeros ="";

   // public ArbolPasajero(NodoPasajero nodo) {}

    public NodoPasajero getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoPasajero raiz) {
        this.raiz = raiz;
    }

    public ArbolPasajero() {
        this.raiz = null;
    }

    private boolean esVacio() {
        return (raiz == null);
    }

    public void insertar(Pasajero pasajero) {
        try {
            if (esVacio()) {
                raiz = new NodoPasajero(pasajero);
            } else {
                insertarRec(raiz, pasajero);

            }
        } catch (Exception e) {
            System.out.println("error al insertar pasajero");
        }

    }

    public void insertarRec(NodoPasajero nodo, Pasajero p) {

        if (p.esMayor(nodo.getPasajero())) {
            if (nodo.getDerecho() == null) {
                nodo.setDerecho(new NodoPasajero(p));
            } else {
                insertarRec(nodo.getDerecho(), p);
            }
        }

        else {
            if (nodo.getIzquierdo() == null) {

                nodo.setIzquierdo(new NodoPasajero(p));
            } else {
                insertarRec(nodo.getIzquierdo(), p);
            }
        }
    }

    public Retorno buscar(String cedula) {
        return buscar(cedula, raiz, 0);
    }

    public Retorno buscar(String cedula, NodoPasajero nodo, int contador) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        String ced = cedula.replace("-", "");
        ced = ced.replace(".", "");

        if (nodo == null) {
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "No existe un pasajero registrado con esa cedula";

        } else if (nodo.getPasajero().validar()==-1) {
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "la cedula no tiene formato valido";
        } else if (cedula.equals(nodo.getPasajero().getCedula())) {
            ret.resultado = Retorno.Resultado.OK;
            contador++;
            ret.valorString = nodo.getPasajero().toString();

        } else if (Integer.parseInt(ced) > nodo.getPasajero().cedulaInt()) {
            contador++;
            return buscar(cedula, nodo.getDerecho(),contador);
        } else {
            contador++;
            return buscar(cedula, nodo.getIzquierdo(),contador);
        }

        ret.valorEntero = contador;
        return ret;
    }



    public void recorrerInorder(NodoPasajero nodo) {

        if (nodo == null)
            return;

        recorrerInorder(nodo.getIzquierdo());

        if (nodo.pasajero != null) {
            String mostrarPasajero = "";
            mostrarPasajero += nodo.pasajero.toString() + "|";
        }
        recorrerInorder(nodo.derecho);

    }

    public void mostrarInOrder(){
        mostrarInOrder(this.raiz);
    }
    public void mostrarInOrder(NodoPasajero a){
        if (a!=null){
            mostrarInOrder(a.getIzquierdo());
            System.out.println(a.getPasajero().getCedula()+ ";" + a.getPasajero().getNombre() + ";" +
                    a.getPasajero().getTelefono() + ";" + a.getPasajero().getCategoria() + "|");
            mostrarInOrder(a.getDerecho());
        }
    }

    public void recorrerInorderInvertido(){
        recorrerInorderInvertido(this.raiz);
    }

    public void recorrerInorderInvertido(NodoPasajero a)
    {
        if (a!=null){
            recorrerInorderInvertido(a.getDerecho());
            System.out.println(a.getPasajero().getCedula()+ ";" + a.getPasajero().getNombre() + ";" +
                    a.getPasajero().getTelefono() + ";" + a.getPasajero().getCategoria() + "|");
            recorrerInorderInvertido(a.getIzquierdo());
        }
    }


    public boolean existeElemento(int e){
        NodoPasajero nodo = obtenerElemento(e, raiz);

        if(nodo ==null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existe(int e, NodoPasajero a) {
        boolean existe;
        if(a == null)
            existe = false;
        else
        {
            if( e == a.getPasajero().cedulaInt() )
                existe=true;
            else if( e < a.getPasajero().cedulaInt() )
                existe = existe(e, a.getIzquierdo());
            else
                existe = existe(e, a.getDerecho());
        }
        return existe;
    }



    public NodoPasajero obtenerElemento(int n, NodoPasajero nodo) {
        if(nodo == null) {
            return nodo;
        } else {
            if(n == nodo.getPasajero().cedulaInt()) {
                return nodo;
            } else if( n < nodo.getPasajero().cedulaInt() ) {
                return obtenerElemento(n, nodo.getIzquierdo());
            } else {
                return obtenerElemento(n, nodo.getDerecho());
            }
        }
    }

    public int contarHojas(NodoPasajero p)
    {
        int cuenta = 0;
        if(this.getRaiz().izquierdo == null && this.getRaiz().derecho == null)
        {
            cuenta = 1;
        }
        else
        {
            if (this.getRaiz().izquierdo  != null)
            {
                cuenta += contarHojas(this.raiz.getDerecho());
            }
            if (this.raiz.getDerecho()!= null)
            {
                cuenta += contarHojas(this.raiz.getDerecho());
            }
        }
        return cuenta;
    }

    public NodoPasajero obtenerelemento2(Sistema.Categoria categoria) {
        NodoPasajero aux= this.getRaiz();
        while (aux!=null){
            if (aux.getPasajero().getCategoria()==categoria){
                return aux;
            }
            aux=aux.getSiguiente();
        }
        return aux;
    }

    public NodoPasajero listarPasajerosPorCategoría(Sistema.Categoria categoria){

       /* for(NodoPasajero p: raiz ) {
            if (p.getPasajero().getCategoria() == categoria) {
                return p;
            }
        }*/


        return null;
    }




}
