import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Clase {
    static ArrayList<String> listaClase=new ArrayList<String>();
    static ArrayList<String> listaDaw1= new ArrayList <String>();
    static ArrayList<String> listaDaw2=new ArrayList<String>();
    static Iterator<String> iterator=listaClase.iterator();
    static TreeSet<Alumno> Completo=new TreeSet<Alumno>();
    static HashSet<Alumno> Algunafalt=new HashSet<Alumno>();
    static String nombre;
    static int aula;

    public static void main(String[] args) throws IOException {
        Clase clase=new Clase();
        listaClase= clase.CargarDatos("/home/raistlin/ExamenRecu/clase.txt");
        clase.LeerLista();

        int opcion;
        Scanner sc=new Scanner(System.in);
        clase.menu();
        opcion=sc.nextInt();

        while (opcion!=3){
                if (opcion==1){
                clase.FaltasCompletas();
            }
            clase.menu();
                opcion=sc.nextInt();
            if (opcion==2){
                clase.Algunafalta();
            }
        }
    }

    private void Algunafalta() {
        Alumno falta=new Alumno();
        if (listaDaw2.size()!=0) {
            for (int i = 0; i < listaDaw2.size(); i++) {
                falta.nombre=nombre;
                falta.aula=aula;
                try {
                    Completo.add(falta);
                    Completo.stream().forEach(a-> System.out.println(a.nombre+" "+a.aula));
                    throw new Exception(falta.nombre);
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

        }
        else if(listaDaw2.size()!=0){
            for (int i = 0; i <listaDaw2.size() ; i++) {
                falta.nombre=nombre;
                falta.aula=aula;
                try {
                    Algunafalt.add(falta);
                    Algunafalt.stream().forEach(a-> System.out.println(a.nombre+" "+a.aula));
                    throw new Exception(falta.nombre);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

        }else{
            System.out.println("no hay fichero para leer");
        }

    }

    private void LeerLista() throws IOException {
        iterator = listaClase.iterator();
        String contendor;
        int registros = listaClase.size();
            if (registros==0){
                System.out.println("no hay registros en el fichero");
            }
            else if (registros < 2) {

                while (iterator.hasNext()) {
                    contendor = iterator.next();
                    if (contendor.equals("daw1")) {
                        listaDaw1 = CargarDatos("/home/raistlin/ExamenRecu/daw1.txt");
                        break;
                    }

                    else if (contendor.equals("daw2")){
                        listaDaw2 = CargarDatos("/home/raistlin/ExamenRecu/daw2.txt");
                    }
                }
            }
    }

    private void FaltasCompletas() {
        Alumno aux=new Alumno();
        if (listaDaw1.size()!=0) {
            for (int i = 0; i < listaDaw1.size(); i++) {
                aux.nombre=nombre;
                aux.aula=aula;
                try {
                    Completo.add(aux);
                    throw new Exception(aux.nombre);
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

        }
        else if(listaDaw2.size()!=0){
            for (int i = 0; i <listaDaw2.size() ; i++) {
                aux.nombre=nombre;
                aux.aula=aula;
                try {
                    Completo.add(aux);
                    throw new Exception(aux.nombre);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }


    }

    private static void menu(){
        System.out.println("- 1 Faltas completas");
        System.out.println("- 2 Alumnos con alguna falta");
        System.out.println("- 3 Salir del programa");
    }

    private ArrayList<String>  CargarDatos(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        BufferedReader buffer = new BufferedReader(reader);
        ArrayList<String> lista = new ArrayList<String>();

        String aux=buffer.readLine();

        while (aux!=null){

            String [] arrstring=aux.split(" ");
            nombre=arrstring[0];
            aula = Integer.parseInt(arrstring[1]);
            lista.add(aux);
            aux = buffer.readLine();
        }
        return lista;
    }
}

