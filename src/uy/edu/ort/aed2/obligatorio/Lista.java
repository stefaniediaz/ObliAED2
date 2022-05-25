package uy.edu.ort.aed2.obligatorio;

public class Lista {//implements ILista
    NodoPasajero primero;
    NodoPasajero ultimo;
    int cantidadElementos;


    public Lista() {
        this.primero = null;
        this.ultimo = null;
        this.cantidadElementos = 0;
    }

    public NodoPasajero getPrimero() {
        return primero;
    }

    public void setPrimero(NodoPasajero primero) {
        this.primero = primero;
    }

  //  @Override
    public boolean esVacia() {
        return (this.getPrimero()== null);
    }

    public NodoPasajero getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoPasajero ultimo) {
        this.ultimo = ultimo;
    }
    public int getCantidadElementos() {
        return cantidadElementos;
    }
    public void setCantidadElementos(int cantidadElementos) {
        this.cantidadElementos = cantidadElementos;
    }

    
   // @Override
    public void agregarFinal(Pasajero p) {
        NodoPasajero nuevo = new NodoPasajero(p);
        if(this.esVacia()){
            this.setPrimero(nuevo);
        }
        else{
            ultimo.setSiguiente(nuevo);
            this.setUltimo(nuevo);
        }
    }

    public NodoPasajero obtenerelemento(Sistema.Categoria categoria) {
        NodoPasajero aux= this.getPrimero();
        while (aux!=null){
            if (aux.getPasajero().getCategoria()==categoria){
                return aux;
            }
            aux=aux.getSiguiente();
        }
        return aux;
    }

    public void mostrar() {
        NodoPasajero aux=this.getPrimero();
        if (aux!=null){
            while (aux!=null){
                System.out.print(aux.getPasajero()+ " - ");
                aux=aux.getSiguiente();
            }
        }
        else
        {
            System.out.println("La lista esta vacia :");

        }
    }
}
