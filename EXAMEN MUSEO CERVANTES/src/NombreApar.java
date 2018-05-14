import java.io.Serializable;

public class NombreApar implements Serializable, Comparable{
    String nombre;
    int apariciones;

    public NombreApar(String nombreCandidato, int frequency){
        nombre=nombreCandidato;
        apariciones=frequency;
    }

    public NombreApar() {

    }


    @Override
    public boolean equals(Object nOtro) {
        NombreApar aux= (NombreApar) nOtro;
        if (nombre.equals(((NombreApar) nOtro).nombre)){
            return true;
        }
        else {return false;}
    }

    @Override
    public int compareTo(Object o) {
        NombreApar nAux= (NombreApar) o;
        if (apariciones < nAux.apariciones) {
            return 1;
        }
        else if (apariciones> nAux.apariciones) {
            return -1;
        }
        else {
            return nombre.compareTo(nAux.nombre);
        }
    }
}

