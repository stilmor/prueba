import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Local {

    static ArrayList<Persona> arrayLista = new ArrayList<Persona>();
    static TreeSet<Persona> listaPersona = new TreeSet<Persona>();
    static Iterator<Persona> iter= listaPersona.iterator();


    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        menu();
        int opcion=Integer.parseInt(sc.nextLine());
        if (opcion==1){
            nuevaPer();
        }
        else if (opcion==2){

        }
    }

    private static void nuevaPer() throws Exception {
        Persona unPer=new Persona();
        try {
            if (!listaPersona.add(unPer)){
                throw new Exception(unPer.nombre);
            }
        }catch (Excepcion e){
            return;
        }


    }

    private static void menu() {
        System.out.println("1 nueva persona \n 2 buscar persona \n 3 recorrer lista \n 4 recorrer array");
    }
}
