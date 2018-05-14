import javax.swing.*;
import java.awt.FlowLayout;

public class EjemploInterfaz extends JFrame {

    public EjemploInterfaz() {
        initComponents();
    }

    private void initComponents() {
        // 1) Crear los componentes
        JLabel etiqueta1 = new JLabel("Mensaje");
        JTextField campoDeTexto = new JTextField(20);
        JButton boton = new JButton("Aceptar");

        // 2) Asigna un layout FlowLayot al panel por defecto y añade los componentes
        FlowLayout miFlowLayout = new FlowLayout( FlowLayout.CENTER,3,3 );
        setLayout(miFlowLayout);
        add(etiqueta1);
        add(campoDeTexto);
        add(boton);

        // 3) Configuracion de los parametros de la ventana
        setSize(250, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
}
