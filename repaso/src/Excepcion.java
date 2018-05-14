public class Excepcion extends Exception {

    String nombre;

    public Excepcion(String o){
        nombre=o;
    }

    @Override
    public String getMessage() {
        return "La persona" + nombre + "ya se encuentra en el registro";
    }
}
