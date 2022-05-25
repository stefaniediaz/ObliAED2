package uy.edu.ort.aed2.obligatorio;

public class Pasajero {
    private String cedula;
    private String nombre;
    private String telefono;
    private Sistema.Categoria categoria;


    public Pasajero(String cedula,String nombre, String telefono, Sistema.Categoria categoria) {
        super();
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.categoria = categoria;
    }





    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Sistema.Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Sistema.Categoria categoria) {
        this.categoria = categoria;
    }

    public int cedulaInt() {
        String ced = cedula.replace("-", "");
        ced = ced.replace(".", "");

        return Integer.parseInt(ced);
    }

    public boolean esMayor(Pasajero pasajero) {
        String ced1 = this.cedula.replace("-", "");
        ced1 = ced1.replace(".", "");

        String ced2 = pasajero.cedula.replace("-", "");
        ced2 = ced2.replace(".", "");

        return Integer.parseInt(ced1)>Integer.parseInt(ced2);
    }

    public int validar() {
        if (cedula == null)
            return -1;

        String validacion1 = "^[1-9](\\.[0-9]{3}){2}\\-[0-9]$";
        String validacion2 = "^([1-9])([0-9]{2})\\.([0-9]{3})\\-[0-9]$";

        if(cedula.matches(validacion1))
            return 1;
        else if(cedula.matches(validacion2)) {
            return 0;
        }
        else
            return -1;
    }

    public int validarDatos(){
        if(nombre == null || nombre.equals("") || telefono == null || telefono.equals("")  || categoria == null
                || cedula == null || cedula.equals(""))
            return -1;
        else
            return 1;
    }




}

