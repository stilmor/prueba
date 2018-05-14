import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio1datos extends JFrame implements MouseListener, ActionListener {

    private JPanel miPanel;
    private JLabel usuario;
    private JLabel password;
    private JTextField usu;
    private JPasswordField passwordField;
    private JButton aceptar;
    private JButton cancelar;

    // segundo panel
    private JPanel mipanel2;
    private JTextArea texto1;
    private JTextArea texto2;
    private JButton boton1;
    private JLabel label1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;




    public static void main(String[] args) {

        Ejercicio1datos Start=new Ejercicio1datos();
        Start.initComponent();
        Start.initComponent2();


            /*Scanner sc=new Scanner(System.in);
            int opcion;
            menu();
            opcion=Integer.parseInt(sc.nextLine());

            while (opcion!=0){
                if (opcion==1){
                    String consulta;
                    stmt = (Statement) conn.createStatement();
                    System.out.println("indica la consulta");
                    consulta=sc.nextLine();
                    String sqlStr = consulta;
                    System.out.println("la consulta es:" + sqlStr);
                    ResultSet rset = stmt.executeQuery(sqlStr);
                    while (rset.next()) {
                        System.out.println(rset.getString("pru_numero") + ", " +
                                rset.getString("pru_texto"));
                    }
                }
                else if (opcion==2){
                    String insert;
                    stmt = (Statement) conn.createStatement();
                    System.out.println("indica la insercion");
                    insert=sc.nextLine();
                    String sqlStr = insert;
                    System.out.println("la insercion es: " + sqlStr);
                    int rset = stmt.executeUpdate(sqlStr);
                }
                else if (opcion==3){
                    String update;
                    stmt = (Statement) conn.createStatement();
                    System.out.println("indica el update");
                    update=sc.nextLine();
                    String sqlStr = update;
                    System.out.println("el update es: " + sqlStr);
                    int rset = stmt.executeUpdate(sqlStr);
                }
                else if (opcion==4){
                    String delete;
                    stmt = (Statement) conn.createStatement();
                    System.out.println("indica el delete");
                    delete=sc.nextLine();
                    String sqlStr = delete;
                    System.out.println("el delete es: " + sqlStr);
                    int rset = stmt.executeUpdate(sqlStr);
                }

                menu();
                opcion=Integer.parseInt(sc.nextLine());
            }*/


    }

    private void initComponent2() {
        //caracteristicas de ventana
        setSize(350,200);
        this.setTitle("Gestion Base de datos");
        this.setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //componentes de la ventana2
        texto2 = new JTextArea();
        texto2.setBounds(50, 25, 500, 50);
        texto1 = new JTextArea();
        texto1.setBounds(50, 150, 500, 125);
        boton1 = new JButton("consulta");
        boton1.setBounds(50, 100, 100, 25);
        boton2 = new JButton("insert");
        boton2.setBounds(175, 100, 100, 25);
        boton3 = new JButton("update");
        boton3.setBounds(300, 100, 100, 25);
        boton4 = new JButton("Delete");
        boton4.setBounds(425, 100, 100, 25);
        boton1.addMouseListener(this);
        boton2.addMouseListener(this);
        boton3.addMouseListener(this);
        boton4.addMouseListener(this);

        mipanel2=new JPanel();
        mipanel2.setLayout(null);
        this.add(mipanel2);

        mipanel2.add(boton1);
        mipanel2.add(boton2);
        mipanel2.add(boton3);
        mipanel2.add(boton4);
        mipanel2.add(texto2);
        mipanel2.add(texto1);

    }

    private void initComponent() {
        //caracteristicas de ventana
        setSize(300,200);
        this.setTitle("Conexion a base de datos");
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //componentes de la ventana

        usuario=new JLabel("Usuario");
        password=new JLabel("Password");
        usu=new JTextField(20);
        passwordField=new JPasswordField(20);
        aceptar=new JButton("Aceptar");
        cancelar=new JButton("Cancelar");

        //instanciar el panel

        miPanel= new JPanel();
        miPanel.setLayout(null);

        //asociar componentes
        usuario.setBounds(100,50,90,40);
        miPanel.add(usuario);
        password.setBounds(100,90,90,20);
        miPanel.add(password);
        usu.setBounds(190,60,90,20);
        miPanel.add(usu);
        passwordField.setBounds(190,90,90,20);
        miPanel.add(passwordField);
        aceptar.setBounds(70,150,90,20);
        aceptar.addMouseListener(this);
        miPanel.add(aceptar);
        cancelar.setBounds(180,150,100,20);
        cancelar.addMouseListener(this);
        miPanel.add(cancelar);

        //asociar panel

        this.setContentPane(miPanel);

        //mostrar panel
        this.setVisible(true);

    }

    private void conexion (){
        // Objetos conexion y Sentencia
        Connection conn = null;
        Statement stmt = null;
        try {
// Paso 1: cargar el driver JDBC.No es necesario incluirlo
            Class.forName("com.mysql.jdbc.Driver").newInstance();
// Paso2: conectarse a la BBDD utilizando la clase Connection
            String userName = usu.getText();
            char[] password = passwordField.getPassword();
// URL de la base de datos (equipo, puerto, base de datos)
            String url = "jdbc:mysql:" + "//127.0.0.1/sqlddbb";
// 10.0.2.15-Ip de mysql
// String url="jdbc:mysql://localhost/sqlbbdd?autoReconnect=true&useSSL=false";
            conn = (Connection) DriverManager.getConnection(url, userName, String.valueOf(password));
            if (conn != null) {
                JOptionPane.showMessageDialog(null, "Conexion a base de datos " + url
                        + " ... Ok", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            // Paso 3: crear sentencias SQL, utilizando objetos de tipo Statement
            stmt = (Statement) conn.createStatement();
// Paso 4: Ejecutar las sentencias
            String sqlStr = "select * from prueba";
// String sqlStr = "select * from prueba where pru_numero= '1'";
// Mostrar el resultado de la consulta por consola
            System.out.println("Tu consulta es: " + sqlStr);
            ResultSet rset = stmt.executeQuery(sqlStr);
// Paso 5: procesar el conjunto de registros utilizando ResultSet
            while (rset.next()) {
                System.out.println(rset.getString("pru_numero") + ", " +
                        rset.getString("pru_texto"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
// Cerramos el resto de recursos
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    private static void menu() {
        System.out.println("Opciones: \n - 1 select \n - 2 insert \n - 3 update \n - 4 delete \n -0 salir");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==aceptar){
            conexion();
            miPanel.setVisible(false);
            setSize(720,720);
            setContentPane(mipanel2);
            mipanel2.repaint();

        }

        else if (e.getSource()==cancelar){
            System.exit(1);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {}
}