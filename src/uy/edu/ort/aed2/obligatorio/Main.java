package uy.edu.ort.aed2.obligatorio;

public class Main {

    public static void main(String[] args) {
        SistemaImp s = new SistemaImp();
        s.inicializarSistema(10);

        s.registrarPasajero("4.400.253-6", "aaaa","091846822", Sistema.Categoria.C);

        s.registrarPasajero("2.400.253-3", "stefanie","091846822", Sistema.Categoria.C);
        s.registrarPasajero("4.665.111-1", "Ana","091844844", Sistema.Categoria.D);
        s.registrarPasajero("1.551.555-2", "Victoria","091224844", Sistema.Categoria.A);
        s.registrarPasajero("6.500.555-3", "Victoria","099999999", Sistema.Categoria.D);

        s.buscarPasajero("4.400.253-6");
        s.buscarPasajero("6.551.555-1");

       // s.listarPasajerosAscendente();
        //s.listarPasajerosDescendente();
    //    s.listarPasajerosPorCategoría(Sistema.Categoria.C);
        s.listarPasajerosPorCategoría(Sistema.Categoria.D);
        s.registrarAeropuerto("MVD","Montevideo");
        s.registrarAeropuerto("MIA","Miami");
        s.registrarAeropuerto("MAD","Madrid");
        s.registrarAeropuerto("MDQ","Mar del plata");
        s.registrarConexion("MVD","MIA", 8000);
        s.registrarConexion("MVD","MAD", 12000);
        s.registrarConexion("MIA","MAD", 5000);
        s.registrarConexion("MDQ","MAD", 13500);
        s.registrarVuelo("MVD","MIA","MM11",10000,9800,700);
        s.registrarVuelo("MIA","MAD","MM22",5000,5000,500);
        s.registrarVuelo("MAD","MDQ","MM15",15000,13400,950);



    }
}
