public class Excepcion extends Exception {
    String nombre;
    //static ArrayList<String> repes= new ArrayList<String>();
    //static Iterator<String> iter=repes.iterator();

    public Excepcion(String[] nombre) {

    }

    public Excepcion(String nombre) {
        this.nombre=nombre;
        //repes.add(this.nombre);
        //System.out.println("elige una opcion");
        //int opcion;
        //Scanner sc=new Scanner(System.in);
        //opcion=Integer.parseInt(sc.nextLine());
        /*if (opcion==1){
            iter=repes.iterator();
            Object aux;
            while (iter.hasNext()){
                aux=iter.next();
                System.out.println(aux);
            }
        }*/
    }

    @Override
    public String getMessage() {
        return "La persona "+ nombre+ " ya se encuentra registrado";
    }
}
