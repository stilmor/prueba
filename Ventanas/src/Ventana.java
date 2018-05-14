import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Ventana extends JFrame {

    private JLabel etiqueta;
    private JTextField valor1;
    private JButton boton;
    private JButton sumar;

    public Ventana(){
        InitComponent();
    }

    private void InitComponent() {


        FlowLayout flowLayout= new FlowLayout(FlowLayout.CENTER , 3,3);
        setLayout(flowLayout);
        /*add(etiqueta);
        add(texto);
        add(boton);
        add(sumar);*/

        sumar=new JButton("Sumar");
        sumar.addMouseListener(new MyClickListenerSumar());

        valor1=new JTextField("0",15);
        valor1.setEditable(true);

        etiqueta=new JLabel();

        add(etiqueta);
        add(valor1);
        add(sumar);


        setSize(250,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Prueba de ventana");
        setVisible(true);
        setResizable(false);



    }

    private class MyClickListenerSumar implements MouseListener {
        public void mouseClicked(MouseEvent event) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}
