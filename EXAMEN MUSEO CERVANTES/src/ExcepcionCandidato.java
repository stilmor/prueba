public class ExcepcionCandidato extends Exception{
    String nombre;

    public ExcepcionCandidato(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getMessage() {
        return nombre+" No se encuentra en los candidatos";
    }
}
