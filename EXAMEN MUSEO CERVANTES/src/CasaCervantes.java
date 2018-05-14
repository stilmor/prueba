import java.io.*;
import java.util.*;

public class CasaCervantes {

    //ArraList para manejar los Datos//
    static ArrayList <String> listaCandi= new ArrayList <String>();
    static ArrayList<String> listaVisi=new ArrayList<String>();
    static TreeSet <NombreApar> candidatos = new TreeSet<NombreApar>();

    //Iteradores para moverse por las listas //
    static Iterator<String> iterLista=listaVisi.iterator();
    static Iterator<NombreApar> iterca;


    //main
    public static void main(String[] args) throws Exception {

        int opcion;
        Scanner sc=new Scanner(System.in);

        menu();
        opcion=Integer.parseInt(sc.nextLine());

        while (opcion!=0){
            if (opcion==1){
                NumApariciones();
                Buscar();
            }
            else if (opcion==2){
                MaxApariciones();
            }
            else if (opcion==3){
                iterca=candidatos.iterator();
                String aux;
                int cont;
                Object a;
                while (iterca.hasNext()){
                    a=iterca.next();

                    System.out.println(((NombreApar) a).nombre+" "+ ((NombreApar) a).apariciones);

                }
            }
            else if (opcion==4){
                SalvarNombreApar();
            }

            else if (opcion==5){
                iterLista=listaVisi.iterator();
                String aux;
                while (iterLista.hasNext()){
                    aux=iterLista.next();
                    System.out.println(aux);
                }
            }

            menu();
            opcion=Integer.parseInt(sc.nextLine());
        }
    }

    private static void MaxApariciones() throws IOException {
        CargarVisitantes();
        CargarAparNombre();
        max();
        contar();



        System.out.println("el turista con el maximo de visitas es "+ max() +" con " + contar()+" visitas" );
    }
    private static String max(){
        iterca=candidatos.iterator();
        NombreApar aux = null;
        while (iterca.hasNext()){
            aux=iterca.next();
            int comparador=aux.apariciones;
            if (comparador== contar()){}
        }
        return aux.nombre ;
    }
    private static int contar() {
        int max=0;
        NombreApar aux;
        iterca=candidatos.iterator();
        while (iterca.hasNext()){
            aux=iterca.next();
            max=aux.apariciones;
            if (max < aux.apariciones) {
                max=aux.apariciones;
            }
            return max;
        }
        return 0;

    }

    private static void SalvarNombreApar() throws IOException {
        CargarVisitantes();
        CargarAparNombre();
        ObjectOutputStream file=null;

        try {
            file = new ObjectOutputStream(new FileOutputStream("C:\\fichero\\NombreApar"));
        }
        catch (IOException a){

        }
        Object aux;
        iterca=candidatos.iterator();

        while (iterca.hasNext()){
            aux=iterca.next();
            file.writeObject(aux);
        }
        file.close();
    }


    private static String entrada(String mensaje) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println(mensaje);
        return sc.nextLine();
    }

    private static void Buscar() throws Exception {
        String opcion=entrada("Nombre de la persona para buscar");

        NombreApar resultado=null;
        for (NombreApar candidato: candidatos) {
            if (candidato.nombre.equals(opcion)) {
                resultado = candidato;
                System.out.println(resultado.nombre+" "+ resultado.apariciones);
            }
        }
        try {
            if (resultado==null){
                throw new ExcepcionCandidato(opcion);
            }
        }catch (ExcepcionCandidato e){
            System.out.println(e.getMessage());
        }


       /* while (iterca.hasNext()){
            aux=iterca.next();
            try {
                if (aux.nombre.equals(opcion)){
                    System.out.println( aux.nombre +" "+ aux.apariciones);
                    break;
                }
                else{
                    throw new ExcepcionCandidato(opcion);
                }
            }
            catch (ExcepcionCandidato e){
                System.out.println(e.getMessage());
                break;
            }
        }*/
    }

    private static void NumApariciones() throws IOException {
        CargarVisitantes();
        CargarAparNombre();
    }

    private static void CargarVisitantes() throws IOException {
        listaVisi= CargarDatos("C:\\fichero\\Visitas.txt");
    }

    private static void CargarAparNombre() throws IOException {
        listaCandi= CargarDatos("C:\\fichero\\Candidatos.txt");

        for (String nombreCandidato : listaCandi) {
            NombreApar candidato = new NombreApar(nombreCandidato,  Collections.frequency(listaVisi, nombreCandidato));
            candidatos.add(candidato);
        }
    }

    private static ArrayList<String>  CargarDatos(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        BufferedReader buffer = new BufferedReader(reader);
        ArrayList<String> lista = new ArrayList<String>();

        String aux=buffer.readLine();

        while (aux!=null){
            lista.add(aux);
            aux = buffer.readLine();
        }
        return lista;
    }


    private static void menu(){
        System.out.println("- 0 salir");
        System.out.println("- 1 Consultar Nombre");
        System.out.println("- 2 Nombre de Turista con mas Visitas");
        System.out.println("- 3 Mostarr listado Candidatos-Apariciones");
        System.out.println("- 4 Guardar a disco");
        System.out.println("- 5 ver array");
    }
}


