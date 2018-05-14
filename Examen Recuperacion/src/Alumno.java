public class Alumno implements Comparable {
    String nombre;
    int aula;
    int apariciones;

    public Alumno(String nombre, int aul){
        this.nombre=nombre;
        this.aula=aul;
    }

    public Alumno() {

    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
         Alumno comp= (Alumno) o;
         if (this.nombre.equals(comp.nombre) && this.aula==comp.aula){
             return true;
         }

         else {
             return false;
         }
    }

    @Override
    public int compareTo(Object o) {
        Alumno cont= (Alumno) o;
        if (cont.aula>aula){
            return 1;
        }
        else if (cont.aula<aula){
            return -1;
        }
        else{
            return cont.nombre.compareTo(nombre);
        }
    }
}
