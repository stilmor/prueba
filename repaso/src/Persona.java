import java.util.Scanner;

public class Persona implements Comparable {
    String nombre;

    public Persona(){
        Scanner sc=new Scanner(System.in);
        System.out.println("nombre de la persona");
        nombre=sc.nextLine();
    }

    @Override
    public boolean equals(Object o) {
        Persona aux;
        aux= (Persona) o;
        if (((Persona) o).nombre==nombre){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }
}
