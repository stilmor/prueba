public class Excepcion extends Exception {
    String nombre;
    int aula;

    public Excepcion (String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getMessage() {
        return nombre+" El alumno esta repetido";
    }
}

