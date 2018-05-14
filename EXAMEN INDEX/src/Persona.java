import java.io.Serializable;
import java.util.Scanner;

public class Persona implements Serializable{
    int edad;
    String nombre;


    public Persona(){

    }
    public Persona(Scanner sc) {
        System.out.println("nombre de la persona");
        nombre=sc.nextLine();
        System.out.println("edad de la persona");
        edad=Integer.parseInt(sc.nextLine());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object a) {

        Persona aux= (Persona) a;
        if (nombre.compareTo(aux.nombre)== 0){
            return true;
        }
        else{
            return false;
        }
    }

}

