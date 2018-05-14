import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class Index {
    static HashSet<Persona> listaPersona= new HashSet<Persona>();
    static Iterator<Persona> iterPer= listaPersona.iterator();
    static ArrayList<Persona> arraPer= new ArrayList<Persona>();


    public static void main(String[] args) throws ClassNotFoundException, IOException, Excepcion {
        Scanner sc = new Scanner(System.in);

        // ObjectOutputStream file;
        //ObjectInputStream file1;

        menu();

        int opcion = Integer.parseInt(sc.nextLine());

        while (opcion != 0) {
            if (opcion == 1) {
                Persona nuevaPer=new Persona(sc);
                try {
                    if (!listaPersona.add(nuevaPer)){
                        throw new Excepcion(nuevaPer.nombre);
                    }
                }
                catch (Exception a){
                    System.out.println(a.getMessage());
                }
            }
            else if (opcion ==2){
                leer();

            }
            else if (opcion==3){
                escribir();
            }
            else if (opcion==4){
                System.out.println(listaPersona.size());
            }
            else if (opcion==7){
                escribirTexto();
            }
            else if (opcion==8){
                leertexto();
            }
            else if (opcion==9){
                leerColeccion();
            }

            menu();
            opcion=Integer.parseInt(sc.nextLine());

        }

    }

    private static void leerColeccion() {
        iterPer=listaPersona.iterator();
        while (iterPer.hasNext()){
            Persona aux=iterPer.next();
            System.out.println(aux.nombre);
        }
    }

    private static void leertexto() throws IOException, Excepcion {
        System.out.println("traza 1");
        FileReader reader= new FileReader("C:\\fichero\\prueba.txt");
        BufferedReader buffer=new BufferedReader(reader);
        String aux = null;
        aux=buffer.readLine();
        while (aux!=null) {
            String [] arrstring=aux.split(" ");
            String nombree=arrstring[0];
            int edada = Integer.parseInt(arrstring[1]);
            String letra=arrstring[2];
            System.out.println(arrstring[0]+" con edad "+arrstring[1]+"con la inicial "+arrstring[2]);
            Persona pAux= new Persona();
            pAux.nombre=nombree;
            pAux.edad=edada;
            aux=buffer.readLine();

            if (!listaPersona.add(pAux)){
                System.out.println("añadiendo a la lista");
                throw new Excepcion(pAux.nombre);
            }
        }
        buffer.close();
    }

    private static void escribirTexto() throws IOException {
        FileWriter writer = new FileWriter("C:\\fichero\\prueba.txt");
        BufferedWriter bwriter = new BufferedWriter(writer);
        iterPer=listaPersona.iterator();
        Persona pAux;
        while (iterPer.hasNext()){
            pAux=iterPer.next();
            bwriter.write(pAux.nombre+ " " + pAux.edad);
            bwriter.newLine();
        }
        bwriter.close();
    }

    private static void escribir() throws IOException {
        ObjectOutputStream file = null;
        try {
            file = new ObjectOutputStream(new FileOutputStream("C:\\fichero\\guardar"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        iterPer=listaPersona.iterator();
        Persona next;

        while (iterPer.hasNext()){
            next=iterPer.next();

            try {
                file.writeObject(next);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        file.close();
    }

    private static void leer() throws IOException, ClassNotFoundException {
        ObjectInputStream file1 = null;

        try {
            file1 = new ObjectInputStream(new FileInputStream("C:\\fichero\\guardar"));
        }
        catch (IOException e) {
            e.getMessage();
        }

        Object contenedor = null;
        Persona pAux = null;

        try {
            contenedor = (Object) file1.readObject();

            while(true)
            {
                if(contenedor instanceof Persona){
                    pAux = (Persona)  contenedor;
                    listaPersona.add(pAux);
                    System.out.println(pAux.nombre + " tiene una edad de : " + pAux.edad);
                }

                contenedor = (Object) file1.readObject();
            }
        }

        catch(EOFException a){}
        catch(IOException a){}

        file1.close();

    }

    private static void menu() {
        System.out.println("1-introducir");
        System.out.println("2-leer");
        System.out.println("3- escribir");
        System.out.println("4- imprimir");
        System.out.println("5- leer en texto");
        System.out.println("6- imprimir en texto");
        System.out.println("7- escribir texto");
        System.out.println("8- leer texto");
        System.out.println("9- leer coleccion");
    }
}
