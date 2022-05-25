package uy.edu.ort.aed2.obligatorio.Utilidades;
import java.util.Comparator;

public class ComparatorUtil {
    public static <T> boolean esMayor(T a, T b,
                                      Comparator<T> comp){
        return comp.compare(a,b)>0;
    }
    public static <T> boolean esMayorOIgual(T a, T b,
                                            Comparator<T> comp){
        return comp.compare(a,b)>=0;
    }
    public static <T> boolean esMenor(T a, T b,
                                      Comparator<T> comp){
        return comp.compare(a,b)<0;
    }
    public static <T> boolean esMenorOIgual(T a, T b,
                                            Comparator<T> comp){
        return comp.compare(a,b)<=0;
    }
    public static <T> boolean esIgual(T a, T b,
                                      Comparator<T> comp){
        return comp.compare(a,b)==0;
    }
}
